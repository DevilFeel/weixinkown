package hyit.app.dao.proxy;

import java.util.List;

import hyit.app.dao.ILessonInfoDAO;
import hyit.app.dao.impl.LessonInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.LessonInfo;

public class LessonInfoDAOProxy implements ILessonInfoDAO {
	private DatabaseConnection dbc = null;
	private ILessonInfoDAO dao = null;

	public LessonInfoDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new LessonInfoDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(LessonInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.doCreate(info);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
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
		List<LessonInfo> all = null;
		try {
			all = this.dao.getBySessionNumber(number);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
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
		try {
			info = this.dao.getByOther(sessionNumber, week, start);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return info;
	}

}
