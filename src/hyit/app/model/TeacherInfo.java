package hyit.app.model;

public class TeacherInfo {
	private Integer teacherNumber;
	private String name;
	private String cardMac;
	private String account;
	private String password;
	private Integer rank;
	private String email;
	private Integer departmentNumber;

	public Integer getTeacherNumber() {
		return teacherNumber;
	}

	public void setTeacherNumber(Integer teacherNumber) {
		this.teacherNumber = teacherNumber;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(Integer departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

}