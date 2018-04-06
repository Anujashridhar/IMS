package in.cdac.db.student.entitiy;

import javax.validation.constraints.NotNull;

public class StudentUpdatePersonalDetails {
	private Integer studentId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String mobileNumber;
	private String dateOfBirth;
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
	
	
	
	public StudentUpdatePersonalDetails(Integer studentId, String firstName, String lastName, String emailAddress,
			String mobileNumber, String dateOfBirth, String currentAddressLine1, String currentAddressLine2,
			String currentCity, String currentState, String currentPostcode, String permantAddressLine1,
			String permantAddressLine2, String permantCity, String permantState, String permantPostcode) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
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
	
	


}
