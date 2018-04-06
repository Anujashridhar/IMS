package in.cdac.db.campus.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class TemplateDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer templateElementId;
	@Transient
	private Integer templateId;
	private String templateElementName;
	private String templateElementType;
	private Character activeFlag;
	private Date dateOfEntry;
	private Date dateOfModification;
	private String parentDiv;
	private String cssClass;
	@ManyToOne
	@JoinColumn(name="templateId",nullable=false)
	private TemplateMaster templateMaster;
	
	public TemplateDetails(Integer templateElementId, Integer templateId, String templateElementName,
			String templateElementType, Character activeFlag, Date dateOfEntry, Date dateOfModification,
			String parentDiv, String cssClass) {
		super();
		this.templateElementId = templateElementId;
		this.templateId = templateId;
		this.templateElementName = templateElementName;
		this.templateElementType = templateElementType;
		this.activeFlag = activeFlag;
		this.dateOfEntry = dateOfEntry;
		this.dateOfModification = dateOfModification;
		this.parentDiv = parentDiv;
		this.cssClass = cssClass;
	}
	
	
	public TemplateDetails() {
		// TODO Auto-generated constructor stub
	}


	public Integer getTemplateElementId() {
		return templateElementId;
	}
	public void setTemplateElementId(Integer templateElementId) {
		this.templateElementId = templateElementId;
	}
	
	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	
	public String getTemplateElementName() {
		return templateElementName;
	}
	public void setTemplateElementName(String templateElementName) {
		this.templateElementName = templateElementName;
	}
	
	public String getTemplateElementType() {
		return templateElementType;
	}
	public void setTemplateElementType(String templateElementType) {
		this.templateElementType = templateElementType;
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
	
	public String getParentDiv() {
		return parentDiv;
	}
	public void setParentDiv(String parentDiv) {
		this.parentDiv = parentDiv;
	}
	
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}


	/**
	 * @return the templateMaster
	 */
	public TemplateMaster getTemplateMaster() {
		return templateMaster;
	}


	/**
	 * @param templateMaster the templateMaster to set
	 */
	public void setTemplateMaster(TemplateMaster templateMaster) {
		this.templateMaster = templateMaster;
	}


	public String toString() {
		return "TemplateDetails [templateElementId=" + templateElementId + ", templateId=" + templateId
				+ ", templateElementName=" + templateElementName + ", templateElementType=" + templateElementType
				+ ", activeFlag=" + activeFlag + ", dateOfEntry=" + dateOfEntry + ", dateOfModification="
				+ dateOfModification + ", parentDiv=" + parentDiv + ", cssClass=" + cssClass + ", templateMaster="
				+ templateMaster + ", getTemplateElementId()=" + getTemplateElementId() + ", getTemplateId()="
				+ getTemplateId() + ", getTemplateElementName()=" + getTemplateElementName()
				+ ", getTemplateElementType()=" + getTemplateElementType() + ", getActiveFlag()=" + getActiveFlag()
				+ ", getDateOfEntry()=" + getDateOfEntry() + ", getDateOfModification()=" + getDateOfModification()
				+ ", getParentDiv()=" + getParentDiv() + ", getCssClass()=" + getCssClass() + ", getTemplateMaster()="
				+ getTemplateMaster() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
