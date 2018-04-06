package in.cdac.auth.role.serviceimpl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.auth.entity.RoleWrapper;
import in.cdac.auth.role.dao.RoleDao;
import in.cdac.auth.role.service.RoleService;
import in.cdac.db.auth.entity.MstRole;
import in.cdac.db.auth.entity.RoleAuthorities;
import in.cdac.ims.util.entity.ResultDataMap;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	public ResultDataMap saveRole(RoleWrapper wrapper,Integer userId) {
		
		
		
		return roleDao.saveRole(wrapper,userId);
	}

	public ResultDataMap getRoleByRoleId(Integer roleId) {
		
		return roleDao.getRoleByRoleId(roleId);
	}

	public ResultDataMap getAllRoleAuthorities() {
		return roleDao.getAllRoleAuthorities();
	}

	public ResultDataMap getAllRoles() {

		return roleDao.getAllRoles();
	}

	public ResultDataMap getFilterdRoles() {
			return roleDao.getFilterdRoles();
	}

}
