package in.cdac.db.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
public class StudentRegistrationdetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer studentid;
	@NotNull(message=" name is required")
	private String studentname;
	@NotNull(message=" name is required")
	private String studentemailid;
	@NotNull(message=" name is required")
	private String studentcontactnumber;
	@NotNull(message=" name is required")
	private String studentpassword;

	@Override
	public String toString() {
		return "StudentRegistrationdetails [studentname=" + studentname + ", studentemailid=" + studentemailid
				+ ", studentcontactnumber=" + studentcontactnumber + ", studentpassword=" + studentpassword + "]";
	}
	public StudentRegistrationdetails() {
		super();
	}

	public StudentRegistrationdetails(Integer studentid,String studentname, String studentemailid, String studentcontactnumber,
			String studentpassword) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentemailid = studentemailid;
		this.studentcontactnumber = studentcontactnumber;
		this.studentpassword = studentpassword;
	}


	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentemailid() {
		return studentemailid;
	}

	public void setStudentemailid(String studentemailid) {
		this.studentemailid = studentemailid;
	}

	public String getStudentcontactnumber() {
		return studentcontactnumber;
	}

	public void setStudentcontactnumber(String studentcontactnumber) {
		this.studentcontactnumber = studentcontactnumber;
	}

	public String getStudentpassword() {
		return studentpassword;
	}

	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}
	
	
}
