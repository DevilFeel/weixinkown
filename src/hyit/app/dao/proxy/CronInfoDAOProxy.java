package hyit.app.dao.proxy;

import java.util.List;

import hyit.app.dao.ICronInfoDAO;
import hyit.app.dao.impl.CronInfoDAOImpls;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.CronInfo;

public class CronInfoDAOProxy implements ICronInfoDAO {
	private DatabaseConnection dbc = null;
	private ICronInfoDAO dao = null;

	public CronInfoDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new CronInfoDAOImpls(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(CronInfo info) throws Exception {
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
	public boolean update(CronInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CronInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CronInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CronInfo> getByLessonNumber(Integer number) throws Exception {
		// TODO Auto-generated method stub
		List<CronInfo> all = null;
		try {
			all = this.dao.getByLessonNumber(number);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<CronInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
