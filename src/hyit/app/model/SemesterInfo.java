package hyit.app.model;

import java.sql.Date;

public class SemesterInfo {
	private Integer semesterNumber;
	private String year;
	private String semester;
	private Date date;
	private Integer dayOfWeek;

	public Integer getSemesterNumber() {
		return semesterNumber;
	}

	public void setSemesterNumber(Integer semesterNumber) {
		this.semesterNumber = semesterNumber;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
}
