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

public class MstState {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer stateId;
	private Integer stateCode;
	private String stateName;
	private Character activeFlag;
	private Integer countryId;
	private Integer countryCode;
	private Date entryDate;
	
	
	
	public MstState() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public Integer getStateCode() {
		return stateCode;
	}
	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
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
	
	
	
	
	@Override
	public String toString() {
		return "MstState [stateId=" + stateId + ", stateCode=" + stateCode + ", stateName=" + stateName
				+ ", activeFlag=" + activeFlag + ", countryId=" + countryId + ", countryCode=" + countryCode
				+ ", entryDate=" + entryDate + "]";
	}
	
	
	

}
