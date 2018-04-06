package in.cdac.ims.campus.entity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import in.cdac.db.campus.entity.DivDetails;
import in.cdac.db.campus.entity.ImageDetails;
import in.cdac.db.campus.entity.MenuDetails;
import in.cdac.db.campus.entity.SiteData;
import in.cdac.db.campus.entity.SiteRegistrationDetail;
import in.cdac.db.campus.entity.SubMenuDetails;
import in.cdac.db.campus.entity.TemplateDetails;

public class Site {

	private Integer siteId;
	@Valid
	private SiteRegistrationDetail siteRegistraionDetail;
	@Valid
	private SiteData siteData;
	private List<DivDetails> divDetails;
	private List<ImageDetails> imageList;
	private List<MenuDetails> menuDetails;
	private List<SubMenuDetails> submenu;
	private List<TemplateDetails> templateDetails;
	
	private Map<MenuDetails, List<SubMenuDetails>> menuSubmenuData=new LinkedHashMap<MenuDetails, List<SubMenuDetails>>();
	
	@Override
	public String toString() {
		return "Site [siteRegistraionDetail=" + siteRegistraionDetail + ", siteData=" + siteData + ", divDetails="
				+ divDetails + ", image=" + imageList + ", menuDetails=" + menuDetails + ", templateDetails="
				+ templateDetails + "]";
	}
	public SiteRegistrationDetail getSiteRegistraionDetail() {
		return siteRegistraionDetail;
	}
	public void setSiteRegistraionDetail(SiteRegistrationDetail siteRegistraionDetail) {
		this.siteRegistraionDetail = siteRegistraionDetail;
	}
	public SiteData getSiteData() {
		return siteData;
	}
	public void setSiteData(SiteData siteData) {
		this.siteData = siteData;
	}
	public List<DivDetails> getDivDetails() {
		return divDetails;
	}
	public void setDivDetails(List<DivDetails> divDetails) {
		this.divDetails = divDetails;
	}
	public List<ImageDetails> getImageList() {
		return imageList;
	}
	public void setImageList(List<ImageDetails> imageList) {
		this.imageList = imageList;
	}
	public List<MenuDetails> getMenuDetails() {
		return menuDetails;
	}
	public void setMenuDetails(List<MenuDetails> menuDetails) {
		this.menuDetails = menuDetails;
	}
	public List<TemplateDetails> getTemplateDetails() {
		return templateDetails;
	}
	public void setTemplateDetails(List<TemplateDetails> templateDetails) {
		this.templateDetails = templateDetails;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	
	
	public Map<MenuDetails, List<SubMenuDetails>> getMenuSubmenuData() {
		return menuSubmenuData;
	}
	public void setMenuSubmenuData(Map<MenuDetails, List<SubMenuDetails>> menuSubmenuData) {
		this.menuSubmenuData = menuSubmenuData;
	}
	public List<SubMenuDetails> getSubmenu() {
		return submenu;
	}
	public void setSubmenu(List<SubMenuDetails> submenu) {
		this.submenu = submenu;
	}

	
}