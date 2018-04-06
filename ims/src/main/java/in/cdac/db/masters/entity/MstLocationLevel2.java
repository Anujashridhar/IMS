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
public class MstLocationLevel2 {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer locLevel2Id;
	private Integer locLevel2Code;
	private Integer locLevel1Id;
	//private Integer locLevel1Code;
	private String locLevel2Name;
	private Character activeFlag;
	private Integer countryId;
	//private Integer countryCode;
	private Date entryDate;
	private Date modifyDate;
	private Integer enteredBy;
	private Integer modifiedBy;
	
	
	public MstLocationLevel2() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "MstLocationLevel2 [locLevel2Id=" + locLevel2Id + ", locLevel2Code=" + locLevel2Code + ", locLevel1Id="
				+ locLevel1Id + ", locLevel2Name=" + locLevel2Name
				+ ", activeFlag=" + activeFlag + ", countryId=" + countryId 
				+ ", entryDate=" + entryDate + ", modifyDate=" + modifyDate + ", enteredBy=" + enteredBy
				+ ", modifiedBy=" + modifiedBy + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	public Integer getLocLevel2Id() {
		return locLevel2Id;
	}


	public void setLocLevel2Id(Integer locLevel2Id) {
		this.locLevel2Id = locLevel2Id;
	}


	public Integer getLocLevel2Code() {
		return locLevel2Code;
	}


	public void setLocLevel2Code(Integer locLevel2Code) {
		this.locLevel2Code = locLevel2Code;
	}


	public Integer getLocLevel1Id() {
		return locLevel1Id;
	}


	public void setLocLevel1Id(Integer locLevel1Id) {
		this.locLevel1Id = locLevel1Id;
	}
	

	public String getLocLevel2Name() {
		return locLevel2Name;
	}


	public void setLocLevel2Name(String locLevel2Name) {
		this.locLevel2Name = locLevel2Name;
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
