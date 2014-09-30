package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import hyit.app.dao.IScheduleInfoDAO;
import hyit.app.model.ScheduleInfo;

public class ScheduleInfoDAOImpl implements IScheduleInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public ScheduleInfoDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(ScheduleInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO schedule_info VALUES(?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, info.getScheduleNumber());
		this.pstmt.setTime(2, info.getStartTime());
		this.pstmt.setTime(3, info.getEndTime());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean update(ScheduleInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ScheduleInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduleInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		ScheduleInfo info = null;
		String sql = "SELECT schedule_number,start_time,end_time FROM schedule_info WHERE schedule_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new ScheduleInfo();
			info.setScheduleNumber(rs.getInt(1));
			info.setStartTime(rs.getTime(2));
			info.setEndTime(rs.getTime(3));
		}
		this.pstmt.close();
		return info;
	}

	@Override
	public List<ScheduleInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
