package hyit.app.dao.proxy;

import hyit.app.dao.ITeacherInfoDAO;
import hyit.app.dao.impl.TeacherInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.TeacherInfo;

import java.util.List;

public class TeacherInfoDAOProxy implements ITeacherInfoDAO {
	private DatabaseConnection dbc = null;
	private ITeacherInfoDAO dao = null;

	public TeacherInfoDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new TeacherInfoDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(TeacherInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.getByID(info.getTeacherNumber()) == null) {
				flag = this.dao.doCreate(info);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public TeacherInfo check(TeacherInfo info) throws Exception {
		// TODO Auto-generated method stub
		TeacherInfo info2 = null;
		try {
			info2 = this.dao.check(info);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return info2;
	}

	@Override
	public boolean update(TeacherInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TeacherInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		TeacherInfo info = null;
		try {
			info = this.dao.getByID(number);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return info;
	}

	@Override
	public List<TeacherInfo> getByDepartmentNumber(Integer number)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeacherInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
