package in.cdac.ims.user.registration.serviceimpl;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.auth.user.service.UserService;
import in.cdac.db.auth.entity.User;
import in.cdac.ims.user.registration.dao.UserRegistrationDao;
import in.cdac.ims.user.registration.service.UserRegistrationService;
import in.cdac.ims.util.entity.Mail;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;
@Service
@Transactional
public class UserRegistrationSerivceIMPL implements UserRegistrationService {
	@Autowired
	UserRegistrationDao userRegistrationDao;
	
	@Autowired
	UserService userService;
	
	public ResultDataMap verifyEmailAddress(String tocken) {
		return userRegistrationDao.verifyEmailAddress(tocken);
		
	}
	public ResultDataMap getVerificationLink(String emailId,String contextPath) {
		ResultDataMap rdm=userRegistrationDao.getNewTocken(emailId);
		if(rdm.getStatus())
		{
			User user=(User)rdm.getDataObject();
			String mailer=" Please click On the Link to verify your email Id <a href='http://"+contextPath+"/verify_user?tocken_no="+user.getTocken()+"' ></a>" ;
			
			try {
				new Mail().sendSimpleMail(user.getUserEmail(),mailer, "Registered successfully");
				rdm.setStatus(true);
				rdm.setMessage(Strings.EmailSent);
			} catch (Exception e) {
				rdm.setMessage(Strings.FailedEmailSend);
				rdm.setStatus(false);
				e.printStackTrace();
				return rdm;
			}
			
		}else if(rdm.getMessage().equals(Strings.EmailAlreadyVerified)) {
			
			return rdm;
		}else {
			return rdm;
		}
		return rdm;
		
		
		
		
	}
	@Override
	public ResultDataMap registrationsave(@Valid User user, Integer loggedInUserId, String contextPath) {
		ResultDataMap rdm=new ResultDataMap();
		user.setActiveFlag('Y');
		/*user.setUserName(studentRegisterDetails.getStudentname());
		user.setPassword(studentRegisterDetails.getStudentpassword());
		user.setUserEmail(studentRegisterDetails.getStudentemailid());
		user.setUserContactNo(studentRegisterDetails.getStudentcontactnumber());*/
		user.setUserType(2);
		rdm=userService.saveUser(user, loggedInUserId, contextPath);
		/*if(rdm.getStatus())
		{
			rdm=studentDao.studentSaveData(studentRegisterDetails);
		}*/
		return rdm;
	}
	
	

}
