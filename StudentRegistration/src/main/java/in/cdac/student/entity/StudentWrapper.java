package in.cdac.student.entity;

import javax.validation.Valid;

import in.cdac.db.auth.entity.User;
import in.cdac.db.student.entity.StudentPersonalDetails;
public class StudentWrapper {
	@Valid
	private User user;
	@Valid
	private StudentPersonalDetails studentPersonalDetails;

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public StudentPersonalDetails getStudentPersonalDetails() {
		return studentPersonalDetails;
	}
	public void setStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
		this.studentPersonalDetails = studentPersonalDetails;
	}
	@Override
	public String toString() {
		return "StudentWrapper [user=" + user + ", studentPersonalDetails=" + studentPersonalDetails + ", getUser()="
				+ getUser() + ", getStudentPersonalDetails()=" + getStudentPersonalDetails() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	}

