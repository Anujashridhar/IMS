package in.cdac.db.student.entity;

public class StudentFileDetails {
	
	int certificated_id;
	String flag;
	String marksheet_10_url;
	String marksheet_12_url;
	String marksheet_graduation_url;
	String marksheet_post_graduation_url;
	String other_1_url;
	String other_2_url;
	
	
	public StudentFileDetails(int certificated_id, String flag, String marksheet_10_url, String marksheet_12_url,
			String marksheet_graduation_url, String marksheet_post_graduation_url, String other_1_url,
			String other_2_url) {
		super();
		this.certificated_id = certificated_id;
		this.flag = flag;
		this.marksheet_10_url = marksheet_10_url;
		this.marksheet_12_url = marksheet_12_url;
		this.marksheet_graduation_url = marksheet_graduation_url;
		this.marksheet_post_graduation_url = marksheet_post_graduation_url;
		this.other_1_url = other_1_url;
		this.other_2_url = other_2_url;
	}
	public int getCertificated_id() {
		return certificated_id;
	}
	public void setCertificated_id(int certificated_id) {
		this.certificated_id = certificated_id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getMarksheet_10_url() {
		return marksheet_10_url;
	}
	public void setMarksheet_10_url(String marksheet_10_url) {
		this.marksheet_10_url = marksheet_10_url;
	}
	public String getMarksheet_12_url() {
		return marksheet_12_url;
	}
	public void setMarksheet_12_url(String marksheet_12_url) {
		this.marksheet_12_url = marksheet_12_url;
	}
	public String getMarksheet_graduation_url() {
		return marksheet_graduation_url;
	}
	public void setMarksheet_graduation_url(String marksheet_graduation_url) {
		this.marksheet_graduation_url = marksheet_graduation_url;
	}
	public String getMarksheet_post_graduation_url() {
		return marksheet_post_graduation_url;
	}
	public void setMarksheet_post_graduation_url(String marksheet_post_graduation_url) {
		this.marksheet_post_graduation_url = marksheet_post_graduation_url;
	}
	public String getOther_1_url() {
		return other_1_url;
	}
	public void setOther_1_url(String other_1_url) {
		this.other_1_url = other_1_url;
	}
	public String getOther_2_url() {
		return other_2_url;
	}
	public void setOther_2_url(String other_2_url) {
		this.other_2_url = other_2_url;
	}
	
}

