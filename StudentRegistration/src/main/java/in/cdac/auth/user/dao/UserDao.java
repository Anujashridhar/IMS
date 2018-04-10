package in.cdac.auth.user.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import in.cdac.db.auth.entity.MstRole;
import in.cdac.db.auth.entity.Tocken;
import in.cdac.db.auth.entity.User;
import in.cdac.db.dashboard.entity.MenuGroup;
import in.cdac.ims.util.entity.ResultDataMap;
@Repository
public interface UserDao {

	
	public List<MstRole> getUserRole(Integer userId);

	public List<MenuGroup> getMenuGroups(Integer userId);

	public User getUserById(Integer userId);

	public ResultDataMap saveUser(User user);

	public User getUserByIdOrEmailOrMobile(String userName);

	public Collection<? extends GrantedAuthority> getUserAuthorities(Integer userId);

	public List<User> getAllUserList();
	public ResultDataMap saveOrUpdateTocken(Tocken tocken);

	public Tocken getTockenByTockenNo(String tockenNo);

	public ResultDataMap updateUserOnly(User user);
}
