package in.cdac.ims.campus.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import in.cdac.db.campus.entity.MenuDetails;


public class Menus {

	private Integer menuId;
	private Integer parentId;
	private String parentName;
	private String url;
	private List<Menus> sumenuList=new ArrayList<Menus>();
	@NotNull
	@Size(max=100,min=5)
	private String menuName;
	
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Menus> getSumenuList() {
		return sumenuList;
	}
	public void setSumenuList(List<Menus> sumenuList) {
		this.sumenuList = sumenuList;
	}
	@Override
	public String toString() {
		return "Menus [menuId=" + menuId + ", parentId=" + parentId + ", parentName=" + parentName + ", url=" + url
				+ ", sumenuList=" + sumenuList + "]";
	}
	public Menus(Integer menuId, Integer parentId, String parentName, String url, List<Menus> sumenuList) {
		super();
		this.menuId = menuId;
		this.parentId = parentId;
		this.parentName = parentName;
		this.url = url;
		this.sumenuList = sumenuList;
	}
	public Menus() {
		super();
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public MenuDetails convertToMenuDetails(Menus menu)
	{
		MenuDetails menuDetails=new MenuDetails();
		menuDetails.setMenuName(menu.getMenuName());
		menuDetails.setMenuId(menu.getMenuId());
		menuDetails.setMenuUrl(menu.getUrl());
		menuDetails.setParentId(menu.getParentId());
		return menuDetails;
	}
	public Menus convertToMenu(MenuDetails menuDetails)
	{
		
		this.menuId=menuDetails.getMenuId();
		this.menuName=menuDetails.getMenuName();
		this.url=menuDetails.getMenuUrl();
		this.parentId=menuDetails.getParentId();
		return this;
	}
}
