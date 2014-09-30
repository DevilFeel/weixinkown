package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import hyit.app.dao.ITeacherInfoDAO;
import hyit.app.model.TeacherInfo;

public class TeacherInfoDAOImpl implements ITeacherInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public TeacherInfoDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(TeacherInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO teacher_info VALUES(null,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		//this.pstmt.setInt(1, info.getTeacherNumber());
		this.pstmt.setString(1, info.getName());
		this.pstmt.setString(2, info.getCardMac());
		this.pstmt.setString(3, info.getAccount());
		this.pstmt.setString(4, info.getPassword());
		this.pstmt.setInt(5, info.getRank());
		this.pstmt.setString(6, info.getEmail());
		this.pstmt.setInt(7, info.getDepartmentNumber());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public TeacherInfo check(TeacherInfo info) throws Exception {
		// TODO Auto-generated method stub
		TeacherInfo info2 = null;
		String sql = "SELECT teacher_number,`name`,card_mac,account,`password`,rank,email,"
				+ "department_number FROM teacher_info WHERE account = ? AND `password` = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, info.getAccount());
		this.pstmt.setString(2, info.getPassword());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			info2 = new TeacherInfo();
			info2.setTeacherNumber(rs.getInt(1));
			info2.setName(rs.getString(2));
			info2.setCardMac(rs.getString(3));
			info2.setAccount(rs.getString(4));
			info2.setPassword(rs.getString(5));
			info2.setRank(rs.getInt(6));
			info2.setEmail(rs.getString(7));
			info2.setDepartmentNumber(rs.getInt(8));
		}
		this.pstmt.close();
		return info2;
	}

	@Override
	public boolean update(TeacherInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TeacherInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		TeacherInfo info = null;
		String sql = "SELECT `name`,card_mac,account,`password`,rank,email,"
				+ "department_number FROM teacher_info WHERE teacher_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new TeacherInfo();
			info.setTeacherNumber(number);
			info.setName(rs.getString(1));
			info.setCardMac(rs.getString(2));
			info.setAccount(rs.getString(3));
			info.setPassword(rs.getString(4));
			info.setRank(rs.getInt(5));
			info.setEmail(rs.getString(6));
			info.setDepartmentNumber(rs.getInt(7));
		}
		this.pstmt.close();
		return info;
	}

	@Override
	public List<TeacherInfo> getByDepartmentNumber(Integer number)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeacherInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
