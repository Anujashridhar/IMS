package in.cdac.db.student.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class StudentPersonalDetails {
	@Id
	private Integer studentId;
	
	
	//@NotNull(message=" date of birth is required")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Past
	private Date dateOfBirth;
	private String currentAddressLine1;
	private String currentAddressLine2;
	private String currentCity;
	private String currentState;
	private String currentPostcode;
	private String permantAddressLine1;
	private String permantAddressLine2;
	private String permantCity;
	private String permantState;
	private String permantPostcode;
	private Character formSubmitted;
	
	
	
	
	@Override
	public String toString() {
		return "StudentPersonalDetails [studentId=" + studentId + ", dateOfBirth=" + dateOfBirth
				+ ", currentAddressLine1=" + currentAddressLine1 + ", currentAddressLine2=" + currentAddressLine2
				+ ", currentCity=" + currentCity + ", currentState=" + currentState + ", currentPostcode="
				+ currentPostcode + ", permantAddressLine1=" + permantAddressLine1 + ", permantAddressLine2="
				+ permantAddressLine2 + ", permantCity=" + permantCity + ", permantState=" + permantState
				+ ", permantPostcode=" + permantPostcode + ", formSubmitted=" + formSubmitted + ", getStudentId()="
				+ getStudentId() + ", getDateOfBirth()=" + getDateOfBirth() + ", getCurrentAddressLine1()="
				+ getCurrentAddressLine1() + ", getCurrentAddressLine2()=" + getCurrentAddressLine2()
				+ ", getCurrentCity()=" + getCurrentCity() + ", getCurrentState()=" + getCurrentState()
				+ ", getCurrentPostcode()=" + getCurrentPostcode() + ", getPermantAddressLine1()="
				+ getPermantAddressLine1() + ", getPermantAddressLine2()=" + getPermantAddressLine2()
				+ ", getPermantCity()=" + getPermantCity() + ", getPermantState()=" + getPermantState()
				+ ", getPermantPostcode()=" + getPermantPostcode() + ", getFormSubmitted()=" + getFormSubmitted()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public StudentPersonalDetails() {
		super();
	}
	public StudentPersonalDetails(Integer studentId, Date dateOfBirth, String currentAddressLine1, String currentAddressLine2,
			String currentCity, String currentState, String currentPostcode, String permantAddressLine1,
			String permantAddressLine2, String permantCity, String permantState, String permantPostcode) {
		super();
		this.studentId = studentId;
		this.dateOfBirth = dateOfBirth;
		this.currentAddressLine1 = currentAddressLine1;
		this.currentAddressLine2 = currentAddressLine2;
		this.currentCity = currentCity;
		this.currentState = currentState;
		this.currentPostcode = currentPostcode;
		this.permantAddressLine1 = permantAddressLine1;
		this.permantAddressLine2 = permantAddressLine2;
		this.permantCity = permantCity;
		this.permantState = permantState;
		this.permantPostcode = permantPostcode;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCurrentAddressLine1() {
		return currentAddressLine1;
	}
	public void setCurrentAddressLine1(String currentAddressLine1) {
		this.currentAddressLine1 = currentAddressLine1;
	}
	public String getCurrentAddressLine2() {
		return currentAddressLine2;
	}
	public void setCurrentAddressLine2(String currentAddressLine2) {
		this.currentAddressLine2 = currentAddressLine2;
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public String getCurrentPostcode() {
		return currentPostcode;
	}
	public void setCurrentPostcode(String currentPostcode) {
		this.currentPostcode = currentPostcode;
	}
	public String getPermantAddressLine1() {
		return permantAddressLine1;
	}
	public void setPermantAddressLine1(String permantAddressLine1) {
		this.permantAddressLine1 = permantAddressLine1;
	}
	public String getPermantAddressLine2() {
		return permantAddressLine2;
	}
	public void setPermantAddressLine2(String permantAddressLine2) {
		this.permantAddressLine2 = permantAddressLine2;
	}
	public String getPermantCity() {
		return permantCity;
	}
	public void setPermantCity(String permantCity) {
		this.permantCity = permantCity;
	}
	public String getPermantState() {
		return permantState;
	}
	public void setPermantState(String permantState) {
		this.permantState = permantState;
	}
	public String getPermantPostcode() {
		return permantPostcode;
	}
	public void setPermantPostcode(String permantPostcode) {
		this.permantPostcode = permantPostcode;
	}
	public Character getFormSubmitted() {
		return formSubmitted;
	}
	public void setFormSubmitted(Character formSubmitted) {
		this.formSubmitted = formSubmitted;
	}
	
	


}
