package in.cdac.auth.login.serviceimpl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.cdac.auth.login.dao.LoginDao;
import in.cdac.auth.login.service.LoginService;
import in.cdac.auth.user.dao.UserDao;
import in.cdac.db.auth.entity.User;
@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDao userDao;
	
	public User getUserByIdOrEmailOrMobile(String userName) {
		
		return userDao.getUserByIdOrEmailOrMobile(userName);
	}
	public Collection<? extends GrantedAuthority> getUserAuthorities(Integer userId) {
		return userDao.getUserAuthorities(userId);
	}

}
