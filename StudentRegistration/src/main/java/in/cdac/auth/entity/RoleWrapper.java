package in.cdac.auth.entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import in.cdac.db.auth.entity.Authorities;
import in.cdac.db.auth.entity.MstRole;
import in.cdac.db.auth.entity.RoleAuthorities;

public class RoleWrapper {

	
	private String roleName;
	private MstRole role=new MstRole();
	
	private Map<Integer, String> assignedAuthoritiesMap=new LinkedHashMap<Integer, String>();
	private Map<Integer, String> authoritiesNotAssignedMap= new LinkedHashMap<Integer, String>();
	private Map<Integer, String> allauthoritiesMap= new LinkedHashMap<Integer, String>();
	
	private List<Authorities> assignedAuthoritiesList=new ArrayList<Authorities>();
	private List<Authorities> authoritiesNotAssignedList=new ArrayList<Authorities>();
	private List<Authorities> allauthoritiesList=new ArrayList<Authorities>();
	
	private List<RoleAuthorities> roleAuthorities=new ArrayList<RoleAuthorities>();
	private List<String> selectedAuthorities=new ArrayList<String>();
	
	private Integer roleId;

	
	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public MstRole getRole() {
		return role;
	}


	public void setRole(MstRole role) {
		this.role = role;
	}


	public Map<Integer, String> getAssignedAuthoritiesMap() {
		return assignedAuthoritiesMap;
	}


	public void setAssignedAuthoritiesMap(Map<Integer, String> assignedAuthoritiesMap) {
		this.assignedAuthoritiesMap = assignedAuthoritiesMap;
	}


	public Map<Integer, String> getAuthoritiesNotAssignedMap() {
		return authoritiesNotAssignedMap;
	}


	public void setAuthoritiesNotAssignedMap(Map<Integer, String> authoritiesNotAssignedMap) {
		this.authoritiesNotAssignedMap = authoritiesNotAssignedMap;
	}


	public List<Authorities> getAssignedAuthoritiesList() {
		return assignedAuthoritiesList;
	}


	public void setAssignedAuthoritiesList(List<Authorities> assignedAuthoritiesList) {
		this.assignedAuthoritiesList = assignedAuthoritiesList;
	}


	public List<Authorities> getAuthoritiesNotAssignedList() {
		return authoritiesNotAssignedList;
	}


	public void setAuthoritiesNotAssignedList(List<Authorities> authoritiesNotAssignedList) {
		this.authoritiesNotAssignedList = authoritiesNotAssignedList;
	}


	public List<RoleAuthorities> getRoleAuthorities() {
		return roleAuthorities;
	}


	public void setRoleAuthorities(List<RoleAuthorities> roleAuthorities) {
		this.roleAuthorities = roleAuthorities;
	}


	public List<String> getSelectedAuthorities() {
		return selectedAuthorities;
	}


	public void setSelectedAuthorities(List<String> selectedAuthorities) {
		this.selectedAuthorities = selectedAuthorities;
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public void setMaps() {
		System.out.println("running1");
		
		for (Object o : authoritiesNotAssignedList) {
			Authorities authority=(Authorities)o;
			authoritiesNotAssignedMap.put(authority.getId(),authority.getName().substring(5));
		}
		System.out.println("running2");
		
		for (Authorities authorities : this.assignedAuthoritiesList) {
			assignedAuthoritiesMap.put( authorities.getId(),authorities.getName().substring(5));
			selectedAuthorities.add(authorities.getId().toString());
		}
		
		for (Authorities authorities : this.allauthoritiesList) {
			allauthoritiesMap.put( authorities.getId(),authorities.getName().substring(5));
		}
		System.out.println("running");
		/*for (Authorities authoritie2s : this.authoritiesNotAssignedList) {
			authoritiesNotAssignedMap.put( authoritie2s.getId(),authoritie2s.getName());
		}*/
		
	}


	public Map<Integer, String> getAllauthoritiesMap() {
		return allauthoritiesMap;
	}


	public void setAllauthoritiesMap(Map<Integer, String> allauthoritiesMap) {
		this.allauthoritiesMap = allauthoritiesMap;
	}


	public List<Authorities> getAllauthoritiesList() {
		return allauthoritiesList;
	}


	public void setAllauthoritiesList(List<Authorities> allauthoritiesList) {
		this.allauthoritiesList = allauthoritiesList;
	}
	
	
	
	
	
}
