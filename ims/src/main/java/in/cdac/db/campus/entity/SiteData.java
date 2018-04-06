package in.cdac.db.campus.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity

public class SiteData  {

	
	@Id

	private Integer siteId;
	private String logo;
	@NotNull
	@Size(max=50,min=5,message="value should have atleast five characters and maximum of fifty characters")
	private String name;
	private String urlName;
	private Integer noOfMenu;
	private Integer noOfDivs;
	private Integer noOfSlidingImg;
	private Character activeFlag;
	private Date dateOfEntry;
	private Date dateOfModification;
	private Integer templateId;
	@Max(value=4,message="value can not be greater than four")
	@Min(value=0,message="value can not be less than zero")
	private Integer noOfHierarchyLevels;
	
	private String locLevel1;
	private String locLevel2;
	private String locLevel3;
	private String locLevel4;
	private Integer enteredBy;
	private Integer modifiedBy;
	
	@Transient
	private MultipartFile file;
	
	
	
	
	


	public SiteData() {
		// TODO Auto-generated constructor stub
	}


	public SiteData(Integer siteId, String logo, String name, Integer noOfMenu, Integer noOfSlidingImg,
		Character activeFlag, Date dateOfEntry, Date dateOfModification, Integer templateId,
		Integer noOfHierarchyLevels, String locLevel1, String locLevel2, String locLevel3, String locLevel4,
		MultipartFile file) {
	super();
	this.siteId = siteId;
	this.logo = logo;
	this.name = name;
	this.noOfMenu = noOfMenu;
	this.noOfSlidingImg = noOfSlidingImg;
	this.activeFlag = activeFlag;
	this.dateOfEntry = dateOfEntry;
	this.dateOfModification = dateOfModification;
	this.templateId = templateId;
	this.noOfHierarchyLevels = noOfHierarchyLevels;
	this.locLevel1 = locLevel1;
	this.locLevel2 = locLevel2;
	this.locLevel3 = locLevel3;
	this.locLevel4 = locLevel4;
	this.file = file;
}


	public Integer getSiteId() {
		return siteId;
	}


	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	
	@Column(length = 100)
	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getNoOfMenu() {
		return noOfMenu;
	}


	public void setNoOfMenu(Integer noOfMenu) {
		this.noOfMenu = noOfMenu;
	}


	public Integer getNoOfSlidingImg() {
		return noOfSlidingImg;
	}


	public void setNoOfSlidingImg(Integer noOfSlidingImg) {
		this.noOfSlidingImg = noOfSlidingImg;
	}


	public Character getActiveFlag() {
		return activeFlag;
	}


	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	
	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	public Date getDateOfEntry() {
		return dateOfEntry;
	}


	public void setDateOfEntry(Date dateOfEntry) {
		if(dateOfEntry==null)
		{
			dateOfEntry=new Date();
		}else{
		 this.dateOfEntry = dateOfEntry;
		}
	}


	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	public Date getDateOfModification() {
		return dateOfModification;
	}


	public void setDateOfModification(Date dateOfModification) {
		this.dateOfModification = dateOfModification;
	}

/*
	*//**
	 * @return the menus
	 *//*
	public Collection<MenuDetails> getMenus() {
		return menus;
	}


	*//**
	 * @param menus the menus to set
	 *//*
	public void setMenus(Collection<MenuDetails> menus) {
		this.menus = menus;
	}


	*//**
	 * @return the images
	 *//*
	public Collection<ImageDetails> getImages() {
		return images;
	}

*/
	/**
	 * @param images the images to set
	 *//*
	public void setImages(Collection<ImageDetails> images) {
		this.images = images;
	}


	*//**
	 * @return the divData
	 *//*
	public Collection<DivDetails> getDivData() {
		return divData;
	}


	*//**
	 * @param divData the divData to set
	 *//*
	public void setDivData(Collection<DivDetails> divData) {
		this.divData = divData;
	}
*/

	public Integer getTemplateId() {
		return templateId;
	}


	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}


	public Integer getNoOfHierarchyLevels() {
		return noOfHierarchyLevels;
	}


	public void setNoOfHierarchyLevels(Integer noOfHierarchyLevels) {
		this.noOfHierarchyLevels = noOfHierarchyLevels;
	}


	public String getLocLevel1() {
		return locLevel1;
	}


	public void setLocLevel1(String locLevel1) {
		this.locLevel1 = locLevel1;
	}


	public String getLocLevel2() {
		return locLevel2;
	}


	public void setLocLevel2(String locLevel2) {
		this.locLevel2 = locLevel2;
	}


	public String getLocLevel3() {
		return locLevel3;
	}


	public void setLocLevel3(String locLevel3) {
		this.locLevel3 = locLevel3;
	}


	public String getLocLevel4() {
		return locLevel4;
	}


	public void setLocLevel4(String locLevel4) {
		this.locLevel4 = locLevel4;
	}


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}


	@Override
	public String toString() {
		return "SiteData [siteId=" + siteId + ", logo=" + logo + ", name=" + name + ", noOfMenu=" + noOfMenu
				+ ", noOfSlidingImg=" + noOfSlidingImg + ", activeFlag=" + activeFlag + ", dateOfEntry=" + dateOfEntry
				+ ", dateOfModification=" + dateOfModification + ", templateId=" + templateId + ", noOfHierarchyLevels="
				+ noOfHierarchyLevels + ", locLevel1=" + locLevel1 + ", locLevel2=" + locLevel2 + ", locLevel3="
				+ locLevel3 + ", locLevel4=" + locLevel4 + ", file=" + file + "]";
	}


	public Integer getEnteredBy() {
		return enteredBy;
	}


	public void setEnteredBy(Integer enteredBy) {
		this.enteredBy = enteredBy;
	}


	public Integer getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public String getUrlName() {
		return urlName;
	}


	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}


	public Integer getNoOfDivs() {
		return noOfDivs;
	}


	public void setNoOfDivs(Integer noOfDivs) {
		this.noOfDivs = noOfDivs;
	}

/*
	public SiteRegistrationDetail getRegistrationDetail() {
		return registrationDetail;
	}


	public void setRegistrationDetail(SiteRegistrationDetail registrationDetail) {
		this.registrationDetail = registrationDetail;
	}
	*/
	
	
}
