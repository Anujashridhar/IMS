package in.cdac.ims.student.Service;

import org.springframework.stereotype.Service;

import in.cdac.db.student.entity.StudentRegistrationdetails;
import in.cdac.ims.util.entity.ResultDataMap;

public interface StudentAdmissionService {
 public ResultDataMap registrationsave(StudentRegistrationdetails studentRegisterDetails);

}
