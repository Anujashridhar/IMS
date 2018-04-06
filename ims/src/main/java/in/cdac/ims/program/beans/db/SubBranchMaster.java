package in.cdac.ims.program.beans.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SubBranchMaster {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer subBranchId;
	private Integer subBranchCode;
	private String subBranchName;
	private Integer branchId;
	private Character activeFlag;
	private Date entryDate;
	private Date modifyDate;
	private Integer enteredBy;
	private Integer modifiedBy;
	
	
	
	public SubBranchMaster() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public SubBranchMaster(Integer subBranchId, Integer subBranchCode, String subBranchName, Integer branchId,
			Character activeFlag, Date entryDate, Date modifyDate, Integer enteredBy, Integer modifiedBy) {
		super();
		this.subBranchId = subBranchId;
		this.subBranchCode = subBranchCode;
		this.subBranchName = subBranchName;
		this.branchId = branchId;
		this.activeFlag = activeFlag;
		this.entryDate = entryDate;
		this.modifyDate = modifyDate;
		this.enteredBy = enteredBy;
		this.modifiedBy = modifiedBy;
	}




	public Integer getSubBranchId() {
		return subBranchId;
	}



	public void setSubBranchId(Integer subBranchId) {
		this.subBranchId = subBranchId;
	}



	public Integer getSubBranchCode() {
		return subBranchCode;
	}



	public void setSubBranchCode(Integer subBranchCode) {
		this.subBranchCode = subBranchCode;
	}



	public String getSubBranchName() {
		return subBranchName;
	}



	public void setSubBranchName(String subBranchName) {
		this.subBranchName = subBranchName;
	}



	public Integer getBranchId() {
		return branchId;
	}



	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}



	public Character getActiveFlag() {
		return activeFlag;
	}



	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}



	public Date getEntryDate() {
		return entryDate;
	}



	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}



	public Date getModifyDate() {
		return modifyDate;
	}



	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}


	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	public Integer getEnteredBy() {
		return enteredBy;
	}



	public void setEnteredBy(Integer enteredBy) {
		this.enteredBy = enteredBy;
	}


	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	public Integer getModifiedBy() {
		return modifiedBy;
	}



	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
	
	
}
