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
public class MstLocationLevel1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer locLevel1Id;
	private Integer locLevel1Code;
	private String locLevel1Name;
	private Character activeFlag;
	private Integer countryId;
	//private Integer countryCode;
	private Date entryDate;
	private Date modifyDate;
	private Integer enteredBy;
	private Integer modifiedBy;
	
	
	public MstLocationLevel1() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "MstLocationLevel1 [locLevel1Id=" + locLevel1Id + ", locLevel1Code=" + locLevel1Code + ", locLevel1Name="
				+ locLevel1Name + ", activeFlag=" + activeFlag + ", countryId=" + countryId
				+ ", entryDate=" + entryDate + ", modifyDate=" + modifyDate + ", enteredBy=" + enteredBy
				+ ", modifiedBy=" + modifiedBy + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	public Integer getLocLevel1Id() {
		return locLevel1Id;
	}


	public void setLocLevel1Id(Integer locLevel1Id) {
		this.locLevel1Id = locLevel1Id;
	}


	public Integer getLocLevel1Code() {
		return locLevel1Code;
	}


	public void setLocLevel1Code(Integer locLevel1Code) {
		this.locLevel1Code = locLevel1Code;
	}


	public String getLocLevel1Name() {
		return locLevel1Name;
	}


	public void setLocLevel1Name(String locLevel1Name) {
		this.locLevel1Name = locLevel1Name;
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
