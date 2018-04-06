package in.cdac.ims.user.registration.service;

import javax.validation.Valid;

import in.cdac.db.auth.entity.User;
import in.cdac.ims.util.entity.ResultDataMap;

public interface UserRegistrationService {
	ResultDataMap registrationsave(@Valid User user, Integer loggedInUserId, String contextPath);

	ResultDataMap verifyEmailAddress(String tocken);

	ResultDataMap getVerificationLink(String emailId, String contextPath);

}
