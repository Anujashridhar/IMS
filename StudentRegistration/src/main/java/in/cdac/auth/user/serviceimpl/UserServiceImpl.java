package in.cdac.auth.user.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.cdac.auth.user.dao.UserDao;
import in.cdac.auth.user.service.UserService;
import in.cdac.db.auth.entity.MstRole;
import in.cdac.db.auth.entity.User;
import in.cdac.db.dashboard.entity.MenuGroup;
import in.cdac.ims.util.entity.Mail;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;
import in.cdac.util.Utility;
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userdao;
	String password;
	String mailer;
	String tocken=null;
	public List<MstRole> getUserRole(Integer userId)
	{
		
		return userdao.getUserRole(userId);
	}

	public List<MenuGroup> getMenuGroups(Integer userId) {
		
		return userdao.getMenuGroups(userId);
	}

	public User getUserById(Integer userId) {
		
		return userdao.getUserById(userId);
	}

	public ResultDataMap saveUser(User user,Integer id,String contextPath) {
		ResultDataMap rdm=new ResultDataMap();
		boolean newUser=false;
		if(id==null || id==0) {id=user.getUserId();}
		if(userdao.getUserByIdOrEmailOrMobile(user.getUserEmail())!=null)
		{
			
			return new ResultDataMap().setStatus(false).setMessage(Strings.EmailIdExist);
		}
		if(userdao.getUserByIdOrEmailOrMobile(user.getUserContactNo())!=null)	
		{
			
			return new ResultDataMap().setStatus(false).setMessage(Strings.MobileNoExist);
		}
		
		if(userdao.getUserById(user.getUserId())!=null)
		{
			
			user.setDateOfModification(new Date());
			
			user.setModifiedBy(id);
			
		
		}else {
			newUser=true;
			user.setActiveFlag('1');
			
			if(user.getPassword()!=null && user.getPassword().trim().equals(""))
			{
				 password=RandomStringUtils.randomAlphanumeric(8);
				user.setPassword(password);
				mailer=" User registered successfully your password is :"+password;
			}else {
				tocken=RandomStringUtils.randomAlphanumeric(30);
				user.setTocken(tocken);
				mailer="  Please click On the Link to verify your email Id <a href='http://"+contextPath+"/verify_user?tocken_no="+tocken+"' ></a>" ;
			}
			
			user.setDateofEntry(new Date());
			user.setRegisteredBy(id);
			
		}
		rdm=userdao.saveUser(user);
		rdm.setDataObject(user);
		if(rdm.getStatus() && newUser)
		{
			try {
				new Mail().sendSimpleMail(user.getUserEmail(),mailer, "Registered successfully");
			} catch (Exception e) {
				rdm.setMessage("User Registered, but failed to send email ");
				e.printStackTrace();
			}
		}
				
		return rdm;
		
	}

	public List<User> getAllUserList() {
		
		return userdao.getAllUserList();
	}
}
