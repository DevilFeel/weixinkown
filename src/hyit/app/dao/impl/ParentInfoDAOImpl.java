package hyit.app.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;


import java.sql.ResultSet;

import hyit.app.dao.IParentInfoDAO;
import hyit.app.model.ParentInfo;

public class ParentInfoDAOImpl implements IParentInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public ParentInfoDAOImpl(Connection connection) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(ParentInfo info) throws Exception {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		String sql = "INSERT INTO parent_info VALUES(null,null,?,?,null,null)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setLong(1, info.getStudentNumber());
		this.pstmt.setString(2,info.getOpenid());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean update(ParentInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ParentInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParentInfo getByOpenid(String openid) throws Exception {
		// TODO Auto-generated method stub
		ParentInfo info = null;
		String sql = "select * from parent_info where openid = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, openid);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			info = new ParentInfo();
			info.setParentNumber(rs.getInt(1));
			info.setName(rs.getString(2));
			info.setStudentNumber(rs.getLong(3));
			info.setOpenid(rs.getString(4));
			info.setPhone(rs.getString(5));
			info.setQq(rs.getString(6));
		}
		return info;
	}

	@Override
	public List<ParentInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean search(String openid) throws Exception {
		// TODO Auto-generated method stub
		ParentInfo info = null;
		String sql = "select * from parent_info where openid = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, openid);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			return true;
		}
		return false;
	}

}
