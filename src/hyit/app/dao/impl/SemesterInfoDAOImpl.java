package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hyit.app.dao.ISemesterInfoDAO;
import hyit.app.model.SemesterInfo;

public class SemesterInfoDAOImpl implements ISemesterInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public SemesterInfoDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(SemesterInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO semester_info VALUES(null,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, info.getYear());
		this.pstmt.setString(2, info.getSemester());
		this.pstmt.setDate(3, info.getDate());
		this.pstmt.setInt(4, info.getDayOfWeek());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean update(SemesterInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SemesterInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SemesterInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		SemesterInfo info = null;
		String sql = "SELECT `year`,semester,`start`,day_of_week FROM semester_info WHERE semester_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new SemesterInfo();
			info.setSemesterNumber(number);
			info.setYear(rs.getString(1));
			info.setSemester(rs.getString(2));
			info.setDate(rs.getDate(3));
			info.setDayOfWeek(rs.getInt(4));
		}
		this.pstmt.close();
		return info;
	}

	@Override
	public List<SemesterInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<SemesterInfo> all = new ArrayList<SemesterInfo>();
		SemesterInfo info = null;
		String sql = "SELECT semester_number,`year`,semester,`start`,day_of_week FROM semester_info";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new SemesterInfo();
			info.setSemesterNumber(rs.getInt(1));
			info.setYear(rs.getString(2));
			info.setSemester(rs.getString(3));
			info.setDate(rs.getDate(4));
			info.setDayOfWeek(rs.getInt(5));
			all.add(info);
		}
		this.pstmt.close();
		return all;
	}

}
