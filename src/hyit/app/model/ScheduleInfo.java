package hyit.app.model;

import java.sql.Time;

public class ScheduleInfo {
	private Integer scheduleNumber;
	private Time startTime;
	private Time endTime;

	public Integer getScheduleNumber() {
		return scheduleNumber;
	}

	public void setScheduleNumber(Integer scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
}
