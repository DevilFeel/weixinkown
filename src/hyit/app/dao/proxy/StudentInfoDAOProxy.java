package hyit.app.dao.proxy;

import java.util.List;

import hyit.app.dao.IStudentInfoDAO;
import hyit.app.dao.impl.StudentInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.StudentInfo;

public class StudentInfoDAOProxy implements IStudentInfoDAO {
	private DatabaseConnection dbc = null;
	private IStudentInfoDAO dao = null;

	public StudentInfoDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new StudentInfoDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(StudentInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.getByID(info.getStudentNumber()) == null) {
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
	public boolean update(StudentInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StudentInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentInfo getByID(Long number) throws Exception {
		// TODO Auto-generated method stub
		StudentInfo info = null;
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
	public List<StudentInfo> getByClassNumber(Integer number) throws Exception {
		// TODO Auto-generated method stub
		List<StudentInfo> all = null;
		try {
			all = this.dao.getByClassNumber(number);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<StudentInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
