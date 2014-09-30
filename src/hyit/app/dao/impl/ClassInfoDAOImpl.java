package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hyit.app.dao.IClassInfoDAO;
import hyit.app.model.ClassInfo;

public class ClassInfoDAOImpl implements IClassInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public ClassInfoDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(ClassInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO class_info VALUES(null,?,?,null)";
		this.pstmt = this.conn.prepareStatement(sql);
		// this.pstmt.setInt(1, info.getClassNumber());
		this.pstmt.setString(1, info.getName());
		this.pstmt.setInt(2, info.getDepartmentNumber());
		// this.pstmt.setInt(3, info.getTeacherNumber());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public ClassInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		ClassInfo info = null;
		String sql = "SELECT class_number,`name`,department_number,teacher_number FROM class_info WHERE class_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new ClassInfo();
			info.setClassNumber(rs.getInt(1));
			info.setName(rs.getString(2));
			info.setDepartmentNumber(rs.getInt(3));
			info.setTeacherNumber(rs.getInt(4));
		}
		this.pstmt.close();
		return info;
	}

	@Override
	public boolean update(ClassInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClassInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassInfo> getByDepartmentNumber(Integer number)
			throws Exception {
		// TODO Auto-generated method stub
		List<ClassInfo> all = new ArrayList<ClassInfo>();
		ClassInfo info = null;
		String sql = "SELECT class_number,`name`,department_number,teacher_number FROM class_info WHERE department_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new ClassInfo();
			info.setClassNumber(rs.getInt(1));
			info.setName(rs.getString(2));
			info.setDepartmentNumber(rs.getInt(3));
			info.setTeacherNumber(rs.getInt(4));
			all.add(info);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<ClassInfo> getByTeacherNumber(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassInfo getByName(String name) throws Exception {
		// TODO Auto-generated method stub
		ClassInfo info = null;
		String sql = "SELECT class_number,`name`,department_number,teacher_number FROM class_info WHERE `name` = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, name);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new ClassInfo();
			info.setClassNumber(rs.getInt(1));
			info.setName(rs.getString(2));
			info.setDepartmentNumber(rs.getInt(3));
			info.setTeacherNumber(rs.getInt(4));
		}
		this.pstmt.close();
		return info;
	}

}
