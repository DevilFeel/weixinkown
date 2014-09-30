package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hyit.app.dao.ISessionInfoDAO;
import hyit.app.model.SessionInfo;

public class SessionInfoDAOImpl implements ISessionInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public SessionInfoDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(SessionInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO session_info VALUES(NULL,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, info.getSubjectNumber());
		this.pstmt.setString(2, info.getClassName());
		this.pstmt.setInt(3, info.getStartWeek());
		this.pstmt.setInt(4, info.getEndWeek());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean update(SessionInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SessionInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		SessionInfo info = null;
		String sql = "SELECT session_number,subject_number,class_name,start_week,end_week "
				+ "FROM session_info WHERE session_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new SessionInfo();
			info.setSessionNumber(rs.getInt(1));
			info.setSubjectNumber(rs.getInt(2));
			info.setClassName(rs.getString(3));
			info.setStartWeek(rs.getInt(4));
			info.setEndWeek(rs.getInt(5));
		}
		this.pstmt.close();
		return info;
	}

	@Override
	public List<SessionInfo> getBySubjectNumber(Integer number)
			throws Exception {
		// TODO Auto-generated method stub
		List<SessionInfo> all = new ArrayList<SessionInfo>();
		SessionInfo info = null;
		String sql = "SELECT session_number,subject_number,class_name,start_week,end_week "
				+ "FROM session_info WHERE subject_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new SessionInfo();
			info.setSessionNumber(rs.getInt(1));
			info.setSubjectNumber(rs.getInt(2));
			info.setClassName(rs.getString(3));
			info.setStartWeek(rs.getInt(4));
			info.setEndWeek(rs.getInt(5));
			all.add(info);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<SessionInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionInfo getByName(Integer subjectNumber, String name)
			throws Exception {
		// TODO Auto-generated method stub
		SessionInfo info = null;
		String sql = "SELECT session_number,subject_number,class_name,start_week,end_week "
				+ "FROM session_info WHERE subject_number = ? AND class_name = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, subjectNumber);
		this.pstmt.setString(2, name);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new SessionInfo();
			info.setSessionNumber(rs.getInt(1));
			info.setSubjectNumber(rs.getInt(2));
			info.setClassName(rs.getString(3));
			info.setStartWeek(rs.getInt(4));
			info.setEndWeek(rs.getInt(5));
		}
		this.pstmt.close();
		return info;
	}
	

}
