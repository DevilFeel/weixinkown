package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hyit.app.dao.ISubjectInfoDAO;
import hyit.app.model.SubjectInfo;

public class SubjectInfoDAOImpl implements ISubjectInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public SubjectInfoDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(SubjectInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO subject_info VALUES(null,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, info.getName());
		this.pstmt.setInt(2, info.getSemesterNumber());
		this.pstmt.setInt(3, info.getTeacherNumber());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean update(SubjectInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SubjectInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		SubjectInfo info = null;
		String sql = "SELECT subject_number,`name`,semester_number,teacher_number FROM subject_info WHERE subject_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new SubjectInfo();
			info.setSubjectNumber(rs.getInt(1));
			info.setName(rs.getString(2));
			info.setSemesterNumber(rs.getInt(3));
			info.setTeacherNumber(rs.getInt(4));
		}
		this.pstmt.close();
		return info;
	}

	@Override
	public List<SubjectInfo> getByTeacherNumberAndSemesterNumber(Integer teacherNumber,
			Integer semesterNumber) throws Exception {
		// TODO Auto-generated method stub
		List<SubjectInfo> all = new ArrayList<SubjectInfo>();
		SubjectInfo info = null;
		String sql = "SELECT subject_number,`name`,semester_number,teacher_number FROM subject_info "
				+ "WHERE teacher_number = ? AND semester_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, teacherNumber);
		this.pstmt.setInt(2, semesterNumber);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new SubjectInfo();
			info.setSubjectNumber(rs.getInt(1));
			info.setName(rs.getString(2));
			info.setSemesterNumber(rs.getInt(3));
			info.setTeacherNumber(rs.getInt(4));
			all.add(info);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<SubjectInfo> getBySemesterNumber(Integer number)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<SubjectInfo> listAll =  new ArrayList<SubjectInfo>();
		SubjectInfo info = null;
		String sql = "select * from subject_info";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			info = new SubjectInfo();
			info.setSubjectNumber(rs.getInt(1));
			info.setName(rs.getString(2));
			info.setSemesterNumber(rs.getInt(3));
			info.setTeacherNumber(rs.getInt(4));
			listAll.add(info);
		}
		return null;
	}

	@Override
	public SubjectInfo getByName(String name, Integer teacherNumber,
			Integer semesterNumber) throws Exception {
		// TODO Auto-generated method stub
		SubjectInfo info = null;
		String sql = "SELECT subject_number,`name`,semester_number,teacher_number FROM subject_info WHERE `name` = ? "
				+ "AND teacher_number=? AND semester_number=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, name);
		this.pstmt.setInt(2, teacherNumber);
		this.pstmt.setInt(3, semesterNumber);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new SubjectInfo();
			info.setSubjectNumber(rs.getInt(1));
			info.setName(rs.getString(2));
			info.setSemesterNumber(rs.getInt(3));
			info.setTeacherNumber(rs.getInt(4));
		}
		this.pstmt.close();
		return info;
	}

	@Override
	public List<SubjectInfo> getByTeacherNumber(Integer teacherNumber)
			throws Exception {
		// TODO Auto-generated method stub
		List<SubjectInfo> all = new ArrayList<SubjectInfo>();
		SubjectInfo info = null;
		String sql = "SELECT subject_number,`name`,semester_number,teacher_number FROM subject_info "
				+ "WHERE teacher_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, teacherNumber);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new SubjectInfo();
			info.setSubjectNumber(rs.getInt(1));
			info.setName(rs.getString(2));
			info.setSemesterNumber(rs.getInt(3));
			info.setTeacherNumber(rs.getInt(4));
			all.add(info);
		}
		this.pstmt.close();
		return all;
	}
}
