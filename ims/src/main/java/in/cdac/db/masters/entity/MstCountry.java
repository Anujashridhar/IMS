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
public class MstCountry {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer countryId;
	private String countryName;
	private Character activeFlag;
	private Integer countryCode;
	private Date entryDate;
	private Date modifyDate;
	private Integer enteredBy;
	private Integer modifiedBy;
	
	
	public MstCountry() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "MstCountry [countryId=" + countryId + ", countryName=" + countryName + ", activeFlag=" + activeFlag
				+ ", countryCode=" + countryCode + ", entryDate=" + entryDate + ", modifyDate=" + modifyDate
				+ ", enteredBy=" + enteredBy + ", modifiedBy=" + modifiedBy + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	public Integer getCountryId() {
		return countryId;
	}


	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public Character getActiveFlag() {
		return activeFlag;
	}


	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}


	public Integer getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
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
