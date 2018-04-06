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
public class ProgramMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer programId;
	private String programName;
	private Character activeFlag;
	private Integer programCode;
	private Integer branchId;
	private Integer subBranchId;
	private String description;
	private String eligibility;
	private String semYearly;
	private String fees;
	private Date entryDate;
	private Date modifyDate;
	private Integer enteredBy;
	private Integer modifiedBy;
	private String durationOfCourse;
	
	public ProgramMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ProgramMaster(Integer programId, String programName, Character activeFlag, Integer programCode,
			Integer branchId, Integer subBranchId, String description, String eligibility, String semYearly,
			String fees, Date entryDate, Date modifyDate, Integer enteredBy, Integer modifiedBy,
			String durationOfCourse) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.activeFlag = activeFlag;
		this.programCode = programCode;
		this.branchId = branchId;
		this.subBranchId = subBranchId;
		this.description = description;
		this.eligibility = eligibility;
		this.semYearly = semYearly;
		this.fees = fees;
		this.entryDate = entryDate;
		this.modifyDate = modifyDate;
		this.enteredBy = enteredBy;
		this.modifiedBy = modifiedBy;
		this.durationOfCourse = durationOfCourse;
	}


	@Override
	public String toString() {
		return "ProgramMaster [programId=" + programId + ", programName=" + programName + ", activeFlag=" + activeFlag
				+ ", programCode=" + programCode + ", branchId=" + branchId + ", subBranchId=" + subBranchId
				+ ", description=" + description + ", eligibility=" + eligibility + ", semYearly=" + semYearly
				+ ", fees=" + fees + ", entryDate=" + entryDate + ", modifyDate=" + modifyDate + ", enteredBy="
				+ enteredBy + ", modifiedBy=" + modifiedBy + ", durationOfCourse=" + durationOfCourse + "]";
	}



	public Integer getProgramId() {
		return programId;
	}


	public void setProgramId(Integer programId) {
		this.programId = programId;
	}


	public String getProgramName() {
		return programName;
	}


	public void setProgramName(String programName) {
		this.programName = programName;
	}


	public Character getActiveFlag() {
		return activeFlag;
	}


	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}


	public Integer getProgramCode() {
		return programCode;
	}


	public void setProgramCode(Integer programCode) {
		this.programCode = programCode;
	}


	public Integer getBranchId() {
		return branchId;
	}


	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}


	public Integer getSubBranchId() {
		return subBranchId;
	}


	public void setSubBranchId(Integer subBranchId) {
		this.subBranchId = subBranchId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getEligibility() {
		return eligibility;
	}


	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}


	public String getSemYearly() {
		return semYearly;
	}


	public void setSemYearly(String semYearly) {
		this.semYearly = semYearly;
	}


	public String getFees() {
		return fees;
	}


	public void setFees(String fees) {
		this.fees = fees;
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


	


	public String getDurationOfCourse() {
		return durationOfCourse;
	}



	public void setDurationOfCourse(String durationOfCourse) {
		this.durationOfCourse = durationOfCourse;
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
