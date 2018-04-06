package in.cdac.auth.role.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.auth.entity.RoleWrapper;
import in.cdac.auth.role.dao.RoleDao;
import in.cdac.db.auth.entity.Authorities;
import in.cdac.db.auth.entity.MstRole;
import in.cdac.db.auth.entity.RoleAuthorities;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	SessionFactory sessionFactory;

	public ResultDataMap saveRole(RoleWrapper roleWrapper, Integer userId) {

		ResultDataMap rdm = new ResultDataMap();
		/*
		 * MstRole role=roleWrapper.getRole();
		 * role.setRoleName(roleWrapper.getRoleName());
		 */

		Session session = sessionFactory.getCurrentSession();
		if(roleWrapper.getRole().getRoleId()!=null)
		{
			MstRole dbRole=session.get(MstRole.class, roleWrapper.getRole().getRoleId());
			if(dbRole!=null)
			{
				String deleteQuery="delete from RoleAuthorities where roleId=:roleId";
				session.createQuery(deleteQuery).setParameter("roleId",dbRole.getRoleId()).executeUpdate();
				session.merge(roleWrapper.getRole());
			}else {
				session.save(roleWrapper.getRole());
			}
		}else {
			
			session.save(roleWrapper.getRole());
		}
		for (String authority : roleWrapper.getSelectedAuthorities()) {
			RoleAuthorities roleAuthority = new RoleAuthorities();
			roleAuthority.setCreatedBy(userId);
			roleAuthority.setCreatedDate(new Date());
			roleAuthority.setEnabled(true);
			roleAuthority.setRoleId(roleWrapper.getRole().getRoleId());
			roleAuthority.setAuthorityId(Integer.parseInt(authority));
			session.save(roleAuthority);

		}
		
		
		return rdm.setStatus(true).setMessage(Strings.savedSuccessfully).setDataObject(roleWrapper);
	}

	public ResultDataMap getRoleByRoleId(Integer roleId) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		MstRole role = (MstRole) session.createQuery("from MstRole where roleId=:roleId").setParameter("roleId", roleId)
				.uniqueResult();
		if (role == null) {
			role = new MstRole();
		}
		@SuppressWarnings("unchecked")
		List<Authorities> assignedAuthorities = (List<Authorities>) session.createQuery(
				"from Authorities where id  in (select authorityId from RoleAuthorities where roleId=:roleId)",Authorities.class)
				.setParameter("roleId", roleId).list();

		@SuppressWarnings("unchecked")
		List<Authorities> notAssignedAuthorities = (List<Authorities>) session.createQuery(
				" from Authorities where id not in (select authorityId from RoleAuthorities where roleId=:roleId)",Authorities.class)
				.setParameter("roleId", roleId).list();
		
		RoleWrapper roleWrapper = new RoleWrapper();
		roleWrapper.setAllauthoritiesList(getAllAuthorities());
		roleWrapper.setRole(role);
		roleWrapper.setAssignedAuthoritiesList(assignedAuthorities);
		roleWrapper.setAuthoritiesNotAssignedList(notAssignedAuthorities);
		roleWrapper.setMaps();

		ResultDataMap rdm = new ResultDataMap();
		rdm.setStatus(true);

		rdm.setDataObject(roleWrapper);
		return rdm;
	}

	public ResultDataMap getAllRoleAuthorities() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<MstRole> roleList = (List<MstRole>) session.createQuery("from MstRole").list();
		List<RoleWrapper> roleWrapperList=new ArrayList<RoleWrapper>();		
		for (MstRole role : roleList) {
			List<Authorities> assignedAuthoritiesList = (List<Authorities>) session.createQuery(
					"from Authorities where id  in (select authorityId from RoleAuthorities where roleId=:roleId)",Authorities.class)
					.setParameter("roleId", role.getRoleId()).list();
			RoleWrapper roleWrapper=new RoleWrapper();
			roleWrapper.setRole(role);
			roleWrapper.setAssignedAuthoritiesList(assignedAuthoritiesList);
			roleWrapper.setMaps();
			roleWrapperList.add(roleWrapper);
		}
		

	
		ResultDataMap rdm = new ResultDataMap();
		rdm.setStatus(true);

		rdm.setDataObject(roleWrapperList);
		return rdm;
	}
	
	private List<Authorities> getAllAuthorities()
	{
		Session session=sessionFactory.getCurrentSession();
		List<Authorities> list=(List<Authorities>)session.createQuery("from Authorities order by name").list();
		return list;
	}

	public ResultDataMap getAllRoles() {
		Session session=sessionFactory.getCurrentSession();
		List<MstRole> list=(List<MstRole>)session.createQuery("from MstRole order by roleName").list();
		LinkedHashMap<Integer, String> roleMap=new LinkedHashMap();
		roleMap.put(0, "----Select Role----");
		for (MstRole mstRole : list) {
			roleMap.put(mstRole.getRoleId(), mstRole.getRoleName());
			System.out.println(mstRole);
		}
		ResultDataMap map=new ResultDataMap();
		map.setDataObject(roleMap);
		return map;
	}

	public ResultDataMap getFilterdRoles() {
		Session session=sessionFactory.getCurrentSession();
		List<MstRole> list=(List<MstRole>)session.createQuery("from MstRole where roleName='FACULTY' or roleName='EMPLOYEE' order by roleName").list();
		LinkedHashMap<Integer, String> roleMap=new LinkedHashMap();
		roleMap.put(0, "----Select Role----");
		for (MstRole mstRole : list) {
			roleMap.put(mstRole.getRoleId(), mstRole.getRoleName());
			System.out.println(mstRole);
		}
		ResultDataMap map=new ResultDataMap();
		map.setDataObject(roleMap);
		return map;
	}

}
