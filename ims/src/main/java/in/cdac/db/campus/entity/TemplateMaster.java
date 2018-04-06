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
public class TemplateMaster {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer templateId;
	private String templateName;
	private Character activeFlag;
	private Date dateOfEntry;
	private Date dateOfModification;
	/*@ElementCollection
	@JoinTable(name="TemplateDetails",
				joinColumns=@JoinColumn(referencedColumnName="templateId")
			)*/
	//@GenericGenerator(name="sequence-gen",strategy="sequence")
	//@CollectionId(generator="sequence-gen",columns={@Column(name="templateElementId")},type=@Type(type="int"))
	/*@OneToMany(mappedBy="templateMaster")
	private Collection<TemplateDetails> elementDetails=new ArrayList<>();
	*/
	
	
	public TemplateMaster(Integer templateId, String templateName, Character activeFlag, Date dateOfEntry,
			Date dateOfModification) {
		super();
		this.templateId = templateId;
		this.templateName = templateName;
		this.activeFlag = activeFlag;
		this.dateOfEntry = dateOfEntry;
		this.dateOfModification = dateOfModification;
	}
	
	
	public String toString() {
		return "TemplateMaster [templateId=" + templateId + ", templateName=" + templateName + ", activeFlag="
				+ activeFlag + ", dateOfEntry=" + dateOfEntry + ", dateOfModification=" + dateOfModification + "]";
	}


	public TemplateMaster() {
		// TODO Auto-generated constructor stub
	}


	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
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
	
	public Character getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}


	/**
	 * @return the elementDetails
	 *//*
	public Collection<TemplateDetails> getElementDetails() {
		return elementDetails;
	}


	*//**
	 * @param elementDetails the elementDetails to set
	 *//*
	public void setElementDetails(Collection<TemplateDetails> elementDetails) {
		this.elementDetails = elementDetails;
	}
	*/
	
	
}
