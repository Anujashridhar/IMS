package in.cdac.ims.student.Service;

import in.cdac.db.auth.entity.User;
import in.cdac.ims.util.entity.ResultDataMap;

public interface StudentAdmissionService {
 public ResultDataMap registrationsave(User student, Integer loggedInUserId, String contextPath);

public ResultDataMap verifyEmailAddress(String tocken);

public Boolean ifFormSubmitted(Integer userId);

public ResultDataMap getVerificationLink(String email,String contextPath);

}