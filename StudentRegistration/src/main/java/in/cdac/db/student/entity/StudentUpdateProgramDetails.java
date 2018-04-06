package in.cdac.db.student.entity;

public class StudentUpdateProgramDetails {
	
	private String chooselevel;
	private String chooseCourse;
	private String chooseCourseField;
	
		
	
	public StudentUpdateProgramDetails(String chooselevel, String chooseCourse, String chooseCourseField) {
		super();
		this.chooselevel = chooselevel;
		this.chooseCourse = chooseCourse;
		this.chooseCourseField = chooseCourseField;
	}
	public String getChooselevel() {
		return chooselevel;
	}
	public void setChooselevel(String chooselevel) {
		this.chooselevel = chooselevel;
	}
	public String getChooseCourse() {
		return chooseCourse;
	}
	public void setChooseCourse(String chooseCourse) {
		this.chooseCourse = chooseCourse;
	}
	public String getChooseCourseField() {
		return chooseCourseField;
	}
	public void setChooseCourseField(String chooseCourseField) {
		this.chooseCourseField = chooseCourseField;
	}
	
	
}
