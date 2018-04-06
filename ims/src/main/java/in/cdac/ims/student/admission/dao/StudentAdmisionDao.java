package in.cdac.ims.student.admission.dao;

import org.springframework.stereotype.Repository;

import in.cdac.db.student.entity.StudentRegistrationdetails;
import in.cdac.ims.util.entity.ResultDataMap;
public interface StudentAdmisionDao {
	public ResultDataMap studentSaveData(StudentRegistrationdetails studentRegistrationdetails);

}
