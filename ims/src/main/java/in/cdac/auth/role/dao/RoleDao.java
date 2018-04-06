package in.cdac.auth.role.dao;

import in.cdac.auth.entity.RoleWrapper;
import in.cdac.ims.util.entity.ResultDataMap;

public interface RoleDao {

	public ResultDataMap saveRole(RoleWrapper roleWrapper,Integer userId);
	public ResultDataMap getRoleByRoleId(Integer roleId);
	public ResultDataMap getAllRoleAuthorities();
	public ResultDataMap getAllRoles();
	public ResultDataMap getFilterdRoles();
}
