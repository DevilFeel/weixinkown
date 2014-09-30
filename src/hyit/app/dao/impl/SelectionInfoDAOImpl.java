package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hyit.app.dao.ISelectionInfoDAO;
import hyit.app.model.SelectionInfo;

public class SelectionInfoDAOImpl implements ISelectionInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public SelectionInfoDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(SelectionInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO selection_info VALUES(NULL,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, info.getSessionNumber());
		this.pstmt.setLong(2, info.getStudentNumber());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean update(SelectionInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SelectionInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SelectionInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SelectionInfo> getBySessionNumber(Integer number)
			throws Exception {
		// TODO Auto-generated method stub
		List<SelectionInfo> all = new ArrayList<SelectionInfo>();
		SelectionInfo info = null;
		String sql = "SELECT selection_number,session_number,student_number FROM selection_info WHERE session_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new SelectionInfo();
			info.setSelectionNumber(rs.getInt(1));
			info.setSessionNumber(rs.getInt(2));
			info.setStudentNumber(rs.getLong(3));
			all.add(info);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<SelectionInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
