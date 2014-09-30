package hyit.app.dao.proxy;

import java.util.List;

import hyit.app.dao.IClassInfoDAO;
import hyit.app.dao.impl.ClassInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.ClassInfo;

public class ClassInfoDAOProxy implements IClassInfoDAO {
	private DatabaseConnection dbc = null;
	private IClassInfoDAO dao = null;

	public ClassInfoDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new ClassInfoDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(ClassInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.getByName(info.getName()) == null) {
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
	public ClassInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		ClassInfo info = null;
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
	public boolean update(ClassInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClassInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassInfo> getByDepartmentNumber(Integer number)
			throws Exception {
		// TODO Auto-generated method stub
		List<ClassInfo> all = null;
		try {
			all = this.dao.getByDepartmentNumber(number);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<ClassInfo> getByTeacherNumber(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassInfo getByName(String name) throws Exception {
		// TODO Auto-generated method stub
		ClassInfo info = null;
		try {
			info = this.dao.getByName(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return info;
	}

}
