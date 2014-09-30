package hyit.app.model;

import java.sql.Date;
import java.sql.Time;

public class CheckInfo {
	private Integer ckNumber;
	private Integer cronNumber;
	private Long studentNumber;
	private String absent;
	private Date date;
	private Time time;

	public Integer getCkNumber() {
		return ckNumber;
	}

	public void setCkNumber(Integer ckNumber) {
		this.ckNumber = ckNumber;
	}

	public Integer getCronNumber() {
		return cronNumber;
	}

	public void setCronNumber(Integer cronNumber) {
		this.cronNumber = cronNumber;
	}

	public Long getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Long studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getAbsent() {
		return absent;
	}

	public void setAbsent(String absent) {
		this.absent = absent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
