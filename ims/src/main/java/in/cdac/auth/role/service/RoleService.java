package in.cdac.auth.role.service;

import in.cdac.auth.entity.RoleWrapper;
import in.cdac.ims.util.entity.ResultDataMap;

public interface RoleService {

	public ResultDataMap saveRole(RoleWrapper wrapper,Integer userId);
	public ResultDataMap getRoleByRoleId(Integer roleId);
	public ResultDataMap getAllRoleAuthorities();
	public ResultDataMap getAllRoles();
	public ResultDataMap getFilterdRoles();
}
