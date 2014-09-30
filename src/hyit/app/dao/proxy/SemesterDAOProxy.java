package hyit.app.dao.proxy;

import java.util.ArrayList;
import java.util.List;

import hyit.app.dao.ISemesterInfoDAO;
import hyit.app.dao.impl.SemesterInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.SemesterInfo;

public class SemesterDAOProxy implements ISemesterInfoDAO {
	private DatabaseConnection dbc = null;
	private ISemesterInfoDAO dao = null;

	public SemesterDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new SemesterInfoDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(SemesterInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.doCreate(info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}

	@Override
	public boolean update(SemesterInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SemesterInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SemesterInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		SemesterInfo info = null;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see hyit.app.dao.ISemesterInfoDAO#getAll()
	 */
	@Override
	public List<SemesterInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<SemesterInfo> all = new ArrayList<SemesterInfo>();
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
