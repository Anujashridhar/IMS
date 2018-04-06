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
public class TemplateModifier {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer templateModId;
	private Integer templateId;
	private Integer templateElementId;
	private String attribute;
	private String value;
	private String cssClass;
	private Character activeFlag;
	private Date dateOfEntry;
	private Date dateOfModification;
	
	
	
	public TemplateModifier(Integer templateModId, Integer templateId, Integer templateElementId, String attribute,
			String value, String cssClass, Character activeFlag, Date dateOfEntry, Date dateOfModification) {
		super();
		this.templateModId = templateModId;
		this.templateId = templateId;
		this.templateElementId = templateElementId;
		this.attribute = attribute;
		this.value = value;
		this.cssClass = cssClass;
		this.activeFlag = activeFlag;
		this.dateOfEntry = dateOfEntry;
		this.dateOfModification = dateOfModification;
	}



	public String toString() {
		return "TemplateModifier [templateModId=" + templateModId + ", templateId=" + templateId
				+ ", templateElementId=" + templateElementId + ", attribute=" + attribute + ", value=" + value
				+ ", cssClass=" + cssClass + ", activeFlag=" + activeFlag + ", dateOfEntry=" + dateOfEntry
				+ ", dateOfModification=" + dateOfModification + ", getTemplateModId()=" + getTemplateModId()
				+ ", getTemplateId()=" + getTemplateId() + ", getTemplateElementId()=" + getTemplateElementId()
				+ ", getAttribute()=" + getAttribute() + ", getValue()=" + getValue() + ", getCssClass()="
				+ getCssClass() + ", getActiveFlag()=" + getActiveFlag() + ", getDateOfEntry()=" + getDateOfEntry()
				+ ", getDateOfModification()=" + getDateOfModification() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}



	public TemplateModifier() {
		// TODO Auto-generated constructor stub
	}



	public Integer getTemplateModId() {
		return templateModId;
	}



	public void setTemplateModId(Integer templateModId) {
		this.templateModId = templateModId;
	}



	public Integer getTemplateId() {
		return templateId;
	}



	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}



	public Integer getTemplateElementId() {
		return templateElementId;
	}



	public void setTemplateElementId(Integer templateElementId) {
		this.templateElementId = templateElementId;
	}



	public String getAttribute() {
		return attribute;
	}



	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public String getCssClass() {
		return cssClass;
	}



	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
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
