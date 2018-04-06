package in.cdac.db.masters.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MstLocationLevel4 {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer locLevel4Id;
	private Integer locLevel4Code;
	private Integer locLevel3Id;
	//private Integer locLevel3Code;
	private Integer locLevel2Id;
	//private Integer locLevel2Code;
	private Integer locLevel1Id;
	//private Integer locLevel1Code;
	private String locLevel4Name;
	private Character activeFlag;
	private Integer countryId;
	//private Integer countryCode;
	private Date entryDate;
	private Date modifyDate;
	private Integer enteredBy;
	private Integer modifiedBy;
	
	
	public MstLocationLevel4() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "MstLocationLevel4 [locLevel4Id=" + locLevel4Id + ", locLevel4Code=" + locLevel4Code + ", locLevel3Id="
				+ locLevel3Id + ", locLevel2Id=" + locLevel2Id 
				+ ", locLevel1Id=" + locLevel1Id 
				+ ", locLevel4Name=" + locLevel4Name + ", activeFlag=" + activeFlag + ", countryId=" + countryId
				+ ", entryDate=" + entryDate + ", modifyDate=" + modifyDate
				+ ", enteredBy=" + enteredBy + ", modifiedBy=" + modifiedBy + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	public Integer getLocLevel4Id() {
		return locLevel4Id;
	}


	public void setLocLevel4Id(Integer locLevel4Id) {
		this.locLevel4Id = locLevel4Id;
	}


	public Integer getLocLevel4Code() {
		return locLevel4Code;
	}


	public void setLocLevel4Code(Integer locLevel4Code) {
		this.locLevel4Code = locLevel4Code;
	}


	public Integer getLocLevel3Id() {
		return locLevel3Id;
	}


	public void setLocLevel3Id(Integer locLevel3Id) {
		this.locLevel3Id = locLevel3Id;
	}


	public Integer getLocLevel2Id() {
		return locLevel2Id;
	}


	public void setLocLevel2Id(Integer locLevel2Id) {
		this.locLevel2Id = locLevel2Id;
	}
	

	public Integer getLocLevel1Id() {
		return locLevel1Id;
	}


	public void setLocLevel1Id(Integer locLevel1Id) {
		this.locLevel1Id = locLevel1Id;
	}


	public String getLocLevel4Name() {
		return locLevel4Name;
	}


	public void setLocLevel4Name(String locLevel4Name) {
		this.locLevel4Name = locLevel4Name;
	}


	public Character getActiveFlag() {
		return activeFlag;
	}


	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}


	public Integer getCountryId() {
		return countryId;
	}


	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	
	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	public Date getEntryDate() {
		return entryDate;
	}


	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}


	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	public Date getModifyDate() {
		return modifyDate;
	}


	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
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
	
	
	
	
}
