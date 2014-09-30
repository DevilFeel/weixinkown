package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import java.sql.PreparedStatement;

import hyit.app.dao.ICheckInfoDAO;
import hyit.app.model.CheckInfo;

public class CheckInfoDAOImpl implements ICheckInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public CheckInfoDAOImpl(Connection connection){
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(CheckInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CheckInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CheckInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheckInfo> getByCronNumber(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheckInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheckInfo> getByCronNumberAndStudentNumber(Integer cronNumber,
			long studentNumber) throws Exception {
		// TODO Auto-generated method stub
		CheckInfo info = null;
		List<CheckInfo> list = new ArrayList<CheckInfo>();
		String sql = "select * from check_info where cron_number = ? and student_number =?";
		this.pstmt = this.conn.prepareCall(sql);
		this.pstmt.setInt(1, cronNumber);
		this.pstmt.setLong(2, studentNumber);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			info = new CheckInfo();
			info.setCkNumber(rs.getInt(1));
			info.setCronNumber(rs.getInt(2));
			info.setStudentNumber(rs.getLong(3));
			info.setAbsent(rs.getString(4));
			info.setDate(rs.getDate(5));
			info.setTime(rs.getTime(6));
			list.add(info);
		}
		this.pstmt.close();
		return list;
	}

}
