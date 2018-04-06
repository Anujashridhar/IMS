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
public class DivDetails {

	
	/*public SiteData getSiteData() {
		return siteData;
	}



	public void setSiteData(SiteData siteData) {
		this.siteData = siteData;
	}*/



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer divId;
	//@Transient
	private Integer siteId;
	private String divName;
	private String divContent;
	private Character activeFlag;
	private Date dateOfEntry;
	private Date dateOfModification;
	/*@ManyToOne
	//@JoinColumn(name="siteId",nullable=false)
	private SiteData siteData;
	*/
	
	
	public DivDetails(Integer divId, Integer siteId, String divName, String divContent, Character activeFlag,
			Date dateOfEntry, Date dateOfModification) {
		super();
		this.divId = divId;
		this.siteId = siteId;
		this.divName = divName;
		this.divContent = divContent;
		this.activeFlag = activeFlag;
		this.dateOfEntry = dateOfEntry;
		this.dateOfModification = dateOfModification;
	}



	public String toString() {
		return "DivDetails [divId=" + divId + ", siteId=" + siteId + ", divName=" + divName + ", divContent="
				+ divContent + ", activeFlag=" + activeFlag + ", dateOfEntry=" + dateOfEntry + ", dateOfModification="
				+ dateOfModification + ", getDivId()=" + getDivId() + ", getSiteId()=" + getSiteId() + ", getDivName()="
				+ getDivName() + ", getDivContent()=" + getDivContent() + ", getActiveFlag()=" + getActiveFlag()
				+ ", getDateOfEntry()=" + getDateOfEntry() + ", getDateOfModification()=" + getDateOfModification()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}



	public DivDetails() {
		// TODO Auto-generated constructor stub
	}



	public Integer getDivId() {
		return divId;
	}



	public void setDivId(Integer divId) {
		this.divId = divId;
	}



	public Integer getSiteId() {
		return siteId;
	}



	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}



	public String getDivName() {
		return divName;
	}



	public void setDivName(String divName) {
		this.divName = divName;
	}


	@Column(length = 200)
	public String getDivContent() {
		return divContent;
	}



	public void setDivContent(String divContent) {
		this.divContent = divContent;
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
	
	
	
	
	
}
