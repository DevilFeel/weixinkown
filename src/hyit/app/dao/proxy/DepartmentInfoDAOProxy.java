package hyit.app.dao.proxy;

import java.util.List;

import hyit.app.dao.IDepartmentInfoDAO;
import hyit.app.dao.impl.DepartmentInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.DepartmentInfo;

public class DepartmentInfoDAOProxy implements IDepartmentInfoDAO {
	private DatabaseConnection dbc = null;
	private IDepartmentInfoDAO dao = null;

	public DepartmentInfoDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new DepartmentInfoDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(DepartmentInfo de) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.getByName(de.getName()) == null) {
				flag = this.dao.doCreate(de);
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
	public DepartmentInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		DepartmentInfo info = null;
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
	public boolean update(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DepartmentInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentInfo getByName(String name) throws Exception {
		// TODO Auto-generated method stub
		DepartmentInfo info = null;
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

	@Override
	public List<DepartmentInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<DepartmentInfo> all = null;
		try {
			all = this.dao.getAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

}
