package in.cdac.db.campus.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class MenuDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer menuId;

	private Integer siteId;


	private String menuName;
	private String menuUrl;
	private Integer parentId;
	private Character activeFlag;
	private Date dateOfEntry;
	private Date dateOfModification;
	
	public MenuDetails(Integer menuId, Integer siteId, String menuName, Integer parentId, Character activeFlag,
			Date dateOfEntry, Date dateOfModification) {
		super();
		this.menuId = menuId;
		this.siteId = siteId;
		this.menuName = menuName;
		this.parentId = parentId;
		this.activeFlag = activeFlag;
		this.dateOfEntry = dateOfEntry;
		this.dateOfModification = dateOfModification;
	}

	
	public MenuDetails() {
		// TODO Auto-generated constructor stub
	}


	public Integer getMenuId() {
		return menuId;
	}


	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}


	public Integer getSiteId() {
		return siteId;
	}


	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public Integer getParentId() {
		return parentId;
	}


	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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
		this.dateOfEntry = dateOfEntry;
	}


	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	public Date getDateOfModification() {
		return dateOfModification;
	}


	public void setDateOfModification(Date dateOfModification) {
		this.dateOfModification = dateOfModification;
	}


	public String getMenuUrl() {
		return menuUrl;
	}


	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}


	@Override
	public String toString() {
		return "MenuDetails [menuId=" + menuId + ", siteId=" + siteId + ", menuName=" + menuName + ", menuUrl="
				+ menuUrl + ", parentId=" + parentId + ", activeFlag=" + activeFlag + ", dateOfEntry=" + dateOfEntry
				+ ", dateOfModification=" + dateOfModification + "]";
	}
	
	
}
