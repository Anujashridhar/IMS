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
public class SubMenuDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer subMenuId;
	private Integer siteId;
	private String subMenuName;
	private String subMenuUrl;
	private Integer parentId;
	private Character activeFlag;
	private Date dateOfEntry;
	private Date dateOfModification;
	
	
	
	public Integer getSiteId() {
		return siteId;
	}


	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
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


	public Integer getSubMenuId() {
		return subMenuId;
	}


	public void setSubMenuId(Integer subMenuId) {
		this.subMenuId = subMenuId;
	}


	public String getSubMenuName() {
		return subMenuName;
	}


	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}


	public String getSubMenuUrl() {
		return subMenuUrl;
	}


	public void setSubMenuUrl(String subMenuUrl) {
		this.subMenuUrl = subMenuUrl;
	}


	@Override
	public String toString() {
		return "SubMenuDetails [subMenuId=" + subMenuId + ", siteId=" + siteId + ", subMenuName=" + subMenuName
				+ ", subMenuUrl=" + subMenuUrl + ", parentId=" + parentId + ", activeFlag=" + activeFlag
				+ ", dateOfEntry=" + dateOfEntry + ", dateOfModification=" + dateOfModification + "]";
	}


	
	
}
