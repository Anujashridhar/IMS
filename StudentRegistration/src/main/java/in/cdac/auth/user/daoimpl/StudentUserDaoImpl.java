package in.cdac.auth.user.daoimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import in.cdac.auth.user.dao.UserDao;
import in.cdac.db.auth.entity.Authorities;
import in.cdac.db.auth.entity.MstRole;
import in.cdac.db.auth.entity.RoleAuthorities;
import in.cdac.db.auth.entity.Tocken;
import in.cdac.db.auth.entity.User;
import in.cdac.db.auth.entity.UserRole;
import in.cdac.db.dashboard.entity.Menu;
import in.cdac.db.dashboard.entity.MenuGroup;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;
@Repository
public class StudentUserDaoImpl implements UserDao {

	@Autowired
	 SessionFactory sessionFactory;

	public List<MstRole> getUserRole(Integer userId) {
		List<MstRole> roles=new ArrayList();
		MstRole role=new MstRole();
		Session session=sessionFactory.getCurrentSession();
   		/*authorities=(List<Authorities>) session.createQuery("from Authorities a,UserRole u,RoleAuthorities r " + 
				" where a.id=r.authorityId " + 
				" and r.roleId=u.roleId " + 
				" and u.userId=? ",Authorities.class)*/
		roles=(List<MstRole>) session.createQuery(" FROM MstRole r where r.roleId in (select roleId from UserRole where userId=:userId) ",MstRole.class)
																	.setParameter("userId", userId)
																	.getResultList();
		
		return roles;
	}

	public List<MenuGroup> getMenuGroups(Integer userId) {
		List<MenuGroup> menuGroups=new ArrayList();
		MstRole role=new MstRole();
		Session session=sessionFactory.getCurrentSession();
   		/*authorities=(List<Authorities>) session.createQuery("from Authorities a,UserRole u,RoleAuthorities r " + 
				" where a.id=r.authorityId " + 
				" and r.roleId=u.roleId " + 
				" and u.userId=? ",Authorities.class)*/
		List<Menu> menus=(List<Menu>) session.createNativeQuery("SELECT distinct m.*,mg.menuGroupName FROM Menu m,UserRole ur, RoleAuthorities ra,MenuGroup mg " + 
																					"where m.authorityId=ra.authorityId " + 
																					"and ra.roleId=ur.roleId " + 
																					"and m.menuGroup=mg.groupId " + 
																					"and ur.userId=?",Menu.class)
																	.setParameter(1, userId)
																	.getResultList();
		System.out.println(menus);
		menuGroups=getMenuGroups(menus);
		return menuGroups;
	}

	private List<MenuGroup> getMenuGroups(List<Menu> menus) {
	
		List<MenuGroup> menuGroups=new ArrayList();
		
		for (Menu menu : menus) {
			MenuGroup menuGroup=new MenuGroup();
			menuGroup.setGroupId(menu.getMenuGroup());
			if(menuGroups.contains(menuGroup))
			{
				
				menuGroups.get(menuGroups.indexOf(menuGroup)).getMenuList().add(menu);
			}else {
				menuGroup.setMenuGroupName(menu.getMenuGroupName());
				menuGroup.getMenuList().add(menu);
				menuGroups.add(menuGroup);
			}
		}
		
		return menuGroups;
	}

	public User getUserById(Integer userId) {
		Session session=sessionFactory.getCurrentSession();
		User user=null;
		if(userId!=null) {
			user=session.get(User.class, userId);
		}
		
		return user;
	}

	public ResultDataMap saveUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		Boolean newUser=false;
		User userdb=null;
		if(user!=null ) 
		{
			
			if(user.getUserId()!=null)
			{
				userdb=session.get(User.class, user.getUserId());
				
				if(userdb!=null)
				{
					// disable Old role if role is changed 
					if(!userdb.getUserType().equals(user.getUserType()))
					{
						
						
						session.createQuery("update  UserRole set enabled=0 where userId=:userId and enabled=1 and userType=:userType")
													.setParameter("userId", user.getUserId())
													.setParameter("userType",user.getUserType())	
													.executeUpdate();
						
					}
					
				}else {
					newUser=true;
				}
			}else {
				newUser=true;
			}
			
			// Save or Update User
			session.saveOrUpdate(user);
			
			//add role Entry in case of new User 
			//	or 
			// user ROle is changed
			if(newUser ||(userdb!=null && !user.getUserType().equals(userdb.getUserType())))
			{
				UserRole userRole=new UserRole();
				userRole.setRoleId(user.getUserType());
				userRole.setUserId(user.getUserId());
				userRole.setEnabled('1');
				session.save(userRole);
			}
			
			//save tocken if new self registerd user
			if(newUser && user.getTocken()!=null)
			{
				Tocken tocken=new Tocken();
				tocken.setUserId(user.getUserId());
				tocken.setGeneratedDate(new Date());
				tocken.setStatus('N');// n=new
				tocken.setTocken(user.getTocken());
				tocken.setTypeOfTocken(Strings.emailVerificationTocken);
				session.save(tocken);
			}
		}
		
		return new ResultDataMap()
				.setDataObject(user)
				.setStatus(true)
				.setMessage(Strings.savedSuccessfully);
	}


	public User getUserByIdOrEmailOrMobile(String userName) {
		User user=null;
		Session session=sessionFactory.getCurrentSession();
		user=session.createQuery("from User where (userEmail=:userName or userId=:userName or userContactNo=:userName) and activeFlag=1",User.class)
				.setParameter("userName", userName)
				.getResultList().stream().findFirst().orElse(null);
		
		System.out.println(user);
		
		return user;
	}
	
	public ResultDataMap saveOrUpdateTocken(Tocken tocken) {
		sessionFactory.getCurrentSession().saveOrUpdate(tocken);

		return new ResultDataMap().setStatus(true).setMessage(Strings.savedSuccessfully);
	}

	@SuppressWarnings("unchecked")
	public Collection<? extends GrantedAuthority> getUserAuthorities(Integer userId) {
		List<Authorities> authorities=new ArrayList();
		Session session=sessionFactory.getCurrentSession();
   		/*authorities=(List<Authorities>) session.createQuery("from Authorities a,UserRole u,RoleAuthorities r " + 
				" where a.id=r.authorityId " + 
				" and r.roleId=u.roleId " + 
				" and u.userId=? ",Authorities.class)*/
		/*authorities=(List<Authorities>) session.createQuery("FROM Authorities a join UserRole ur ON a.id = ur.userId " + 
		"                                  join RoleAuthorities ra ON ur.roleId = ra.roleId " 
*/
		authorities=(List<Authorities>) session.createNativeQuery("SELECT distinct a.* FROM Authorities a,UserRole ur,RoleAuthorities ra " + 
																		"where a.id=ra.authorityId  " + 
																		"and ra.roleId=ur.roleId " + 
																		"and ur.userId=? ",Authorities.class)
																	.setParameter(1, userId)
																	.getResultList();
		for (Authorities authorities2 : authorities) {
			System.out.println(authorities2.getName());
		}
		return authorities;
	}

	public List<User> getAllUserList() {
		return sessionFactory.getCurrentSession().createQuery("from User",User.class).getResultList();
		
	}

public Tocken getTockenByTockenNo(String tockenNo) {
		

		return sessionFactory.getCurrentSession()
				.createQuery("from Tocken where tocken=:tockenNo",Tocken.class)
				.setParameter("tockenNo", tockenNo)
				.uniqueResult();
	}

	public ResultDataMap updateUserOnly(User user) {
		sessionFactory.getCurrentSession().update(user);

		return new ResultDataMap().setStatus(true).setMessage(Strings.savedSuccessfully);
	}

	
}
