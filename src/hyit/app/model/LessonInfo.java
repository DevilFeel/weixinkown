package hyit.app.model;

public class LessonInfo {
	private Integer lessonNumber;
	private Integer sessionNumber;
	private Integer dayOfWeek;
	private Integer evenOld;
	private Integer startLesson;
	private Integer endLesson;
	private String classroom;

	public Integer getLessonNumber() {
		return lessonNumber;
	}

	public void setLessonNumber(Integer lessonNumber) {
		this.lessonNumber = lessonNumber;
	}

	public Integer getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(Integer sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Integer getEvenOld() {
		return evenOld;
	}

	public void setEvenOld(Integer evenOld) {
		this.evenOld = evenOld;
	}

	public Integer getStartLesson() {
		return startLesson;
	}

	public void setStartLesson(Integer startLesson) {
		this.startLesson = startLesson;
	}

	public Integer getEndLesson() {
		return endLesson;
	}

	public void setEndLesson(Integer endLesson) {
		this.endLesson = endLesson;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

}
