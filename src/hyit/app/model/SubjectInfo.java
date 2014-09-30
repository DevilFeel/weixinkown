package hyit.app.model;

public class SubjectInfo {
	private Integer subjectNumber;
	private String name;
	private Integer semesterNumber;
	private Integer teacherNumber;

	public Integer getSubjectNumber() {
		return subjectNumber;
	}

	public void setSubjectNumber(Integer subjectNumber) {
		this.subjectNumber = subjectNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSemesterNumber() {
		return semesterNumber;
	}

	public void setSemesterNumber(Integer semesterNumber) {
		this.semesterNumber = semesterNumber;
	}

	public Integer getTeacherNumber() {
		return teacherNumber;
	}

	public void setTeacherNumber(Integer teacherNumber) {
		this.teacherNumber = teacherNumber;
	}
}
