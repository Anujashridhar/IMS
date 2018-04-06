package in.cdac.auth.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.cdac.db.auth.entity.MstRole;
import in.cdac.db.auth.entity.User;
import in.cdac.db.dashboard.entity.MenuGroup;
import in.cdac.ims.util.entity.ResultDataMap;

@Service
@Transactional
public interface UserService {

	public List<MstRole> getUserRole(Integer userId);
	public List<MenuGroup> getMenuGroups(Integer userId);
	public User getUserById(Integer userId);

	public ResultDataMap saveUser(User user,Integer loggedInUserId,String contextPath);
	public List<User> getAllUserList();

	
}
