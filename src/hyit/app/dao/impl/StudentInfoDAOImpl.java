package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hyit.app.dao.IStudentInfoDAO;
import hyit.app.model.StudentInfo;

public class StudentInfoDAOImpl implements IStudentInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public StudentInfoDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(StudentInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO student_info VALUES(?,?,null,?,?,null,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setLong(1, info.getStudentNumber());
		this.pstmt.setString(2, info.getName());
		// this.pstmt.setString(3, info.getCardMac());
		this.pstmt.setString(3, info.getEnterYear());
		this.pstmt.setInt(4, info.getClassNumber());
		// this.pstmt.setInt(6, info.getCardID());
		this.pstmt.setInt(5, info.getDepartmentNumber());
		this.pstmt.setString(6, info.getProfession());
		this.pstmt.setString(7, info.getSex());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean update(StudentInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StudentInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentInfo> getByClassNumber(Integer number) throws Exception {
		// TODO Auto-generated method stub
		List<StudentInfo> all = new ArrayList<StudentInfo>();
		StudentInfo info = null;
		String sql = "SELECT student_number,`name`,card_mac,enter_year,class_number,card_id,department_number,"
				+ "profession,sex FROM student_info WHERE class_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new StudentInfo();
			info.setStudentNumber(rs.getLong(1));
			info.setName(rs.getString(2));
			info.setCardMac(rs.getString(3));
			info.setEnterYear(rs.getString(4));
			info.setClassNumber(rs.getInt(5));
			info.setCardID(rs.getInt(6));
			info.setDepartmentNumber(rs.getInt(7));
			info.setProfession(rs.getString(8));
			info.setSex(rs.getString(9));
			all.add(info);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<StudentInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentInfo getByID(Long number) throws Exception {
		// TODO Auto-generated method stub
		StudentInfo info = null;
		String sql = "SELECT student_number,`name`,card_mac,enter_year,class_number,card_id,department_number,"
				+ "profession,sex FROM student_info WHERE student_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setLong(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new StudentInfo();
			info.setStudentNumber(rs.getLong(1));
			info.setName(rs.getString(2));
			info.setCardMac(rs.getString(3));
			info.setEnterYear(rs.getString(4));
			info.setClassNumber(rs.getInt(5));
			info.setCardID(rs.getInt(6));
			info.setDepartmentNumber(rs.getInt(7));
			info.setProfession(rs.getString(8));
			info.setSex(rs.getString(9));
		}
		this.pstmt.close();
		return info;
	}

}
