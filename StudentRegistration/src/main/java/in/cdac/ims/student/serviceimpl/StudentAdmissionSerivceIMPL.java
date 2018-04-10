package in.cdac.ims.student.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.cdac.auth.user.service.UserService;
import in.cdac.db.auth.entity.User;
import in.cdac.db.student.entity.StudentPersonalDetails;
import in.cdac.ims.student.Service.StudentAdmissionService;
import in.cdac.ims.student.admission.dao.StudentAdmisionDao;
import in.cdac.ims.util.entity.Mail;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;
@Service
@Transactional
public class StudentAdmissionSerivceIMPL implements StudentAdmissionService {
	@Autowired
	StudentAdmisionDao studentDao;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserService userService;
	public ResultDataMap registrationsave(User student, Integer loggedInUserId, String contextPath) 
	{
		ResultDataMap rdm=new ResultDataMap();
		student.setActiveFlag('Y');
		/*user.setUserName(studentRegisterDetails.getStudentname());
		user.setPassword(studentRegisterDetails.getStudentpassword());
		user.setUserEmail(studentRegisterDetails.getStudentemailid());
		user.setUserContactNo(studentRegisterDetails.getStudentcontactnumber());*/
		student.setPassword(encoder.encode(student.getPassword()));
		student.setUserType(2);
		rdm=userService.saveUser(student, loggedInUserId, contextPath);
		if(rdm.getDataObject()==null)
		{
			return rdm.setStatus(false).setMessage(rdm.getMessage());
		}else{
		StudentPersonalDetails studentPersonalDetails=new StudentPersonalDetails();
		User user=(User)rdm.getDataObject();
		studentPersonalDetails.setStudentId(user.getUserId());
		studentPersonalDetails.setFormSubmitted('N');
		studentDao.saveStudentPersonalDetails(studentPersonalDetails);
		}
		/*if(rdm.getStatus())
		{
			rdm=studentDao.studentSaveData(studentRegisterDetails);
		}*/
		return rdm;
	}
	public ResultDataMap verifyEmailAddress(String tocken) {
		return studentDao.verifyEmailAddress(tocken);
		
	}
	public ResultDataMap getVerificationLink(String emailId,String contextPath) {
		ResultDataMap rdm=studentDao.getNewTocken(emailId);
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
	public Boolean ifFormSubmitted(Integer userId) {
		
		return studentDao.ifFormSubmitted(userId);
	}
	
	

}