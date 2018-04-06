package in.cdac.db.campus.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import in.cdac.db.util.entity.Address;

@Component
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class SiteRegistrationDetail {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer siteId;
	private String registeredBy;
	@NotNull(message=" name is required")
	@Size(min=5,message="min size is 5")
	private String name;
	@NotNull(message=" Contact Number is required")
	@Size(min=10,max=10,message="Please give 10 digit phone no")
	@Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Numbers are allowed only")
	private String contactNumber;
	@NotNull(message=" Email is required")
	@Email@Size(min=3,message="email not correct")
	private String contactEmail;
	private Character activeFlag;
	private Date dateOfEntry;
	private Date dateOfModification;
	private Address address;
	private Integer adminId;
	
	
	
	public SiteRegistrationDetail(Integer siteId, String registeredBy, String name, String contactNumber,
			String contactEmail, Character activeFlag, Date dateOfEntry, Date dateOfModification) {
		super();
		this.siteId = siteId;
		this.registeredBy = registeredBy;
		this.name = name;
		this.contactNumber = contactNumber;
		this.contactEmail = contactEmail;
		this.activeFlag = activeFlag;
		this.dateOfEntry = dateOfEntry;
		this.dateOfModification = dateOfModification;
	}
	
	
	public SiteRegistrationDetail() {
		// TODO Auto-generated constructor stub
	}


	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	
	public String getRegisteredBy() {
		return registeredBy;
	}
	public void setRegisteredBy(String registeredBy) {
		this.registeredBy = registeredBy;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
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


	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "SiteRegistrationDetail [siteId=" + siteId + ", registeredBy=" + registeredBy + ", name=" + name
				+ ", contactNumber=" + contactNumber + ", contactEmail=" + contactEmail + ", activeFlag=" + activeFlag
				+ ", dateOfEntry=" + dateOfEntry + ", dateOfModification=" + dateOfModification + ", address=" + address
				+ "]";
	}


	public Integer getAdminId() {
		return adminId;
	}


	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	
	
	
}
