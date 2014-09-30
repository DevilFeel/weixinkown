package hyit.app.model;

public class StudentInfo {
	private Long studentNumber;
	private String name;
	private String cardMac;
	private String enterYear;
	private Integer classNumber;
	private Integer cardID;
	private Integer departmentNumber;
	private String profession;
	private String sex;

	public Long getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Long studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardMac() {
		return cardMac;
	}

	public void setCardMac(String cardMac) {
		this.cardMac = cardMac;
	}

	public String getEnterYear() {
		return enterYear;
	}

	public void setEnterYear(String enterYear) {
		this.enterYear = enterYear;
	}

	public Integer getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}

	public Integer getCardID() {
		return cardID;
	}

	public void setCardID(Integer cardID) {
		this.cardID = cardID;
	}

	public Integer getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(Integer departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
