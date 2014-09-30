package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hyit.app.dao.ILessonInfoDAO;
import hyit.app.model.LessonInfo;

public class LessonInfoDAOImpl implements ILessonInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public LessonInfoDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(LessonInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO lesson_info VALUES(NULL,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, info.getSessionNumber());
		this.pstmt.setInt(2, info.getDayOfWeek());
		this.pstmt.setInt(3, info.getEvenOld());
		this.pstmt.setInt(4, info.getStartLesson());
		this.pstmt.setInt(5, info.getEndLesson());
		this.pstmt.setString(6, info.getClassroom());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean update(LessonInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LessonInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LessonInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LessonInfo> getBySessionNumber(Integer number) throws Exception {
		// TODO Auto-generated method stub
		List<LessonInfo> all = new ArrayList<LessonInfo>();
		LessonInfo info = null;
		String sql = "SELECT lesson_number,session_number,day_of_week,even_old,start_lesson,"
				+ "end_lesson,classroom FROM lesson_info WHERE session_number = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, number);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new LessonInfo();
			info.setLessonNumber(rs.getInt(1));
			info.setSessionNumber(rs.getInt(2));
			info.setDayOfWeek(rs.getInt(3));
			info.setEvenOld(rs.getInt(4));
			info.setStartLesson(rs.getInt(5));
			info.setEndLesson(rs.getInt(6));
			info.setClassroom(rs.getString(7));
			all.add(info);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<LessonInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LessonInfo getByOther(Integer sessionNumber, Integer week,
			Integer start) throws Exception {
		// TODO Auto-generated method stub
		LessonInfo info = null;
		String sql = "SELECT lesson_number,session_number,day_of_week,even_old,start_lesson,end_lesson,"
				+ "classroom FROM lesson_info WHERE session_number = ? AND day_of_week = ? AND start_lesson = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, sessionNumber);
		this.pstmt.setInt(2, week);
		this.pstmt.setInt(3, start);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			info = new LessonInfo();
			info.setLessonNumber(rs.getInt(1));
			info.setSessionNumber(rs.getInt(2));
			info.setDayOfWeek(rs.getInt(3));
			info.setEvenOld(rs.getInt(4));
			info.setStartLesson(rs.getInt(5));
			info.setEndLesson(rs.getInt(6));
			info.setClassroom(rs.getString(7));
		}
		this.pstmt.close();
		return info;
	}

}
