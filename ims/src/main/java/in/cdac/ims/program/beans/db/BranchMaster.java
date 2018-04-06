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
public class BranchMaster {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer branchId;
	private Integer branchCode;
	private String branchName;
	private Character activeFlag;
	private Date entryDate;
	private Date modifyDate;
	private Integer enteredBy;
	private Integer modifiedBy;
	
	
	
	public BranchMaster() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public BranchMaster(Integer branchId, Integer branchCode, String branchName, Character activeFlag, Date entryDate,
			Date modifyDate, Integer enteredBy, Integer modifiedBy) {
		super();
		this.branchId = branchId;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.activeFlag = activeFlag;
		this.entryDate = entryDate;
		this.modifyDate = modifyDate;
		this.enteredBy = enteredBy;
		this.modifiedBy = modifiedBy;
	}




	public Integer getBranchId() {
		return branchId;
	}



	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}



	public Integer getBranchCode() {
		return branchCode;
	}



	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}



	public String getBranchName() {
		return branchName;
	}



	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}



	public Character getActiveFlag() {
		return activeFlag;
	}



	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
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
