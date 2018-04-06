package in.cdac.ims.user.registration.dao;

import in.cdac.ims.util.entity.ResultDataMap;

public interface UserRegistrationDao {

	ResultDataMap verifyEmailAddress(String tocken);

	ResultDataMap getNewTocken(String emailId);

}
