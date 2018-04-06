package in.cdac.auth.user.serviceimpl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.cdac.auth.user.dao.UserDao;
import in.cdac.auth.user.service.UserService;
import in.cdac.db.auth.entity.MstRole;
import in.cdac.db.auth.entity.Tocken;
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
			user.setActiveFlag('0');
			
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

	
	public User getUserByIdOrEmailOrMobile(String userName) {
		
		return userdao.getUserByIdOrEmailOrMobile(userName);
	}
	public Collection<? extends GrantedAuthority> getUserAuthorities(Integer userId) {
		return userdao.getUserAuthorities(userId);
	}
	@Override
	public ResultDataMap generatePasswordResetLink(User user, String contextPath) {
		
		Tocken tocken=new Tocken();
		tocken.setGeneratedDate(new Date());
		tocken.setStatus(Strings.NewTocken);
		tocken.setTypeOfTocken(Strings.PasswordResetTocken);
		tocken.setUserId(user.getUserId());
		tocken.setValidFlag('Y');
		String tockenNo=RandomStringUtils.randomAlphanumeric(30);
		tocken.setTocken(tockenNo);
		ResultDataMap rdm=userdao.saveOrUpdateTocken(tocken);
		if(rdm.getStatus())
		{
			String mailer="  Please click On the Link to verify your email Id <a href='http://"+contextPath+"/resetPassword?tocken_no="+tockenNo+"' ></a>" ;
			try {
				new Mail().sendSimpleMail(user.getUserEmail(),mailer, Strings.passwordResetMailSubject);
				rdm.setMessage("email sent to your email Id please click on the link to reset password ");
			} catch (Exception e) {
				rdm.setMessage("email Found, but failed to send email ");
				e.printStackTrace();
			}
		}else {
			rdm.setMessage(Strings.error);

		}
		
		return rdm;
	}

	@Override
	public ResultDataMap resetPassword(String tockenNo, String password1) {
		ResultDataMap rdm=new ResultDataMap();
		Tocken tocken=ifValidTocken(tockenNo, Strings.PasswordResetTocken);
		if(tocken!=null)
		{
			Integer userId=tocken.getUserId();
			User user=userdao.getUserById(userId);
			user.setPassword(password1);
			user.setModifiedBy(userId);
			user.setDateOfModification(new Date());
			 rdm=userdao.updateUserOnly(user);
			if(rdm.getStatus())
			{
			tocken.setStatus(Strings.VerifiedTocken);
			userdao.saveOrUpdateTocken(tocken);
			rdm.setStatus(true);
			rdm.setMessage(Strings.savedSuccessfully);
			}else {
				rdm.setStatus(false);
				rdm.setMessage(Strings.error);
			}
			
			
		}else {
			rdm.setStatus(false);
			rdm.setMessage(Strings.InvalidTocken);
		}
		return rdm ;
	}

	@Override
	public Tocken ifValidTocken(String tockenNo,String type) {
		Tocken tocken=userdao.getTockenByTockenNo(tockenNo);
		if(tocken!=null
				&& tocken.getTypeOfTocken().equals(type)
				&& tocken.getStatus().equals(Strings.NewTocken)
				&& tocken.getValidFlag().equals('Y'))
		{
			return tocken;
		}else {
			return null;
		}
		
	}
	
}
