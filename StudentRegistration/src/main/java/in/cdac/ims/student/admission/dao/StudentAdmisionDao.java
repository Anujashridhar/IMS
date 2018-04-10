package in.cdac.ims.student.admission.dao;

import org.springframework.stereotype.Repository;

import in.cdac.db.student.entity.StudentPersonalDetails;
import in.cdac.ims.util.entity.ResultDataMap;
public interface StudentAdmisionDao {
	
	public ResultDataMap verifyEmailAddress(String tocken);

public Boolean ifFormSubmitted(Integer userId);

	public ResultDataMap getNewTocken(String emailId);

	public ResultDataMap saveStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails);

}