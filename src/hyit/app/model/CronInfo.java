package hyit.app.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class CronInfo {
	private Integer cronNumber;
	private Integer lessonNumber;
	private Time executeTime;
	private Date executeDate;
	private Timestamp orderTime;
	private Integer status;
	private Integer week;
	private String classroom;

	public Integer getCronNumber() {
		return cronNumber;
	}

	public void setCronNumber(Integer cronNumber) {
		this.cronNumber = cronNumber;
	}

	public Integer getLessonNumber() {
		return lessonNumber;
	}

	public void setLessonNumber(Integer lessonNumber) {
		this.lessonNumber = lessonNumber;
	}

	public Time getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(Time executeTime) {
		this.executeTime = executeTime;
	}

	public Date getExecuteDate() {
		return executeDate;
	}

	public void setExecuteDate(Date executeDate) {
		this.executeDate = executeDate;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

}
