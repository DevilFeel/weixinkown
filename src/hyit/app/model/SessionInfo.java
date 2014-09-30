package hyit.app.model;

public class SessionInfo {
	private Integer sessionNumber;
	private Integer subjectNumber;
	private String className;
	private Integer startWeek;
	private Integer endWeek;

	public Integer getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(Integer sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	public Integer getSubjectNumber() {
		return subjectNumber;
	}

	public void setSubjectNumber(Integer subjectNumber) {
		this.subjectNumber = subjectNumber;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getStartWeek() {
		return startWeek;
	}

	public void setStartWeek(Integer startWeek) {
		this.startWeek = startWeek;
	}

	public Integer getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(Integer endWeek) {
		this.endWeek = endWeek;
	}
}
