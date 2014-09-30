package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hyit.app.dao.IDepartmentInfoDAO;
import hyit.app.model.DepartmentInfo;

public class DepartmentInfoDAOImpl implements IDepartmentInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public DepartmentInfoDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(DepartmentInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO department_info VALUES(null,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		//this.pstmt.setInt(1, info.getDepartmentNumber());
		this.pstmt.setString(1, info.getName());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public DepartmentInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		DepartmentInfo info = null;
		String sql = "SELECT `name` FROM department_info WHERE department_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new DepartmentInfo();
			info.setDepartmentNumber(number);
			info.setName(rs.getString(1));
		}
		this.pstmt.close();
		return info;
	}

	@Override
	public boolean update(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DepartmentInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartmentInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<DepartmentInfo> all = new ArrayList<DepartmentInfo>();
		DepartmentInfo info = null;
		String sql = "SELECT department_number,`name` FROM department_info";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new DepartmentInfo();
			info.setDepartmentNumber(rs.getInt(1));
			info.setName(rs.getString(2));
			all.add(info);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public DepartmentInfo getByName(String name) throws Exception {
		// TODO Auto-generated method stub
		DepartmentInfo info = null;
		String sql = "SELECT department_number,`name` FROM department_info WHERE `name` = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, name);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new DepartmentInfo();
			info.setDepartmentNumber(rs.getInt(1));
			info.setName(rs.getString(2));
		}
		this.pstmt.close();
		return info;
	}

}
