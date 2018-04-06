package in.cdac.db.campus.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class ImageDetails {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer imageId;
	//@Transient
	private String imageType;
	private Integer imageSequence;
	private Integer siteId;
	private String imageUrl;
	private Character activeFlag;
	private Date dateOfEntry;
	private Date dateOfModification;
	@Transient
	private MultipartFile file;
	
	/*@ManyToOne
	//@JoinColumn(name="siteId",nullable=false)
	private SiteData siteData;
	*/
	
	public ImageDetails(Integer imageId, Integer siteId, String imageUrl, Character activeFlag, Date dateOfEntry,
			Date dateOfModification) {
		super();
		this.imageId = imageId;
		this.siteId = siteId;
		this.imageUrl = imageUrl;
		this.activeFlag = activeFlag;
		this.dateOfEntry = dateOfEntry;
		this.dateOfModification = dateOfModification;
	}


	public String toString() {
		return "ImageDetails [imageId=" + imageId + ", imageType=" + imageType + ", imageSequence=" + imageSequence
				+ ", siteId=" + siteId + ", imageUrl=" + imageUrl + ", activeFlag=" + activeFlag + ", dateOfEntry="
				+ dateOfEntry + ", dateOfModification=" + dateOfModification + ", file=" + file + ", getImageId()="
				+ getImageId() + ", getSiteId()=" + getSiteId() + ", getImageUrl()=" + getImageUrl()
				+ ", getActiveFlag()=" + getActiveFlag() + ", getDateOfEntry()=" + getDateOfEntry()
				+ ", getDateOfModification()=" + getDateOfModification() + ", getFile()=" + getFile()
				+ ", getImageType()=" + getImageType() + ", getImageSequence()=" + getImageSequence() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}


	public ImageDetails() {
		// TODO Auto-generated constructor stub
	}


	public Integer getImageId() {
		return imageId;
	}


	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}


	public Integer getSiteId() {
		return siteId;
	}


	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}


	@Column(length = 100)
	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public Character getActiveFlag() {
		return activeFlag;
	}


	public void setActiveFlag(Character ativeFlag) {
		this.activeFlag = ativeFlag;
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


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public String getImageType() {
		return imageType;
	}


	public void setImageType(String imageType) {
		this.imageType = imageType;
	}


	public Integer getImageSequence() {
		return imageSequence;
	}


	public void setImageSequence(Integer imageSequence) {
		this.imageSequence = imageSequence;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageId == null) ? 0 : imageId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageDetails other = (ImageDetails) obj;
		if (imageId == null) {
			if (other.imageId != null)
				return false;
		} else if (!imageId.equals(other.imageId))
			return false;
		return true;
	}


	/**
	 * @return the siteData
	 *//*
	public SiteData getSiteData() {
		return siteData;
	}


	*//**
	 * @param siteData the siteData to set
	 *//*
	public void setSiteData(SiteData siteData) {
		this.siteData = siteData;
	}
	*/
	
	
}
