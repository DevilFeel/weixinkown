package hyit.app.dao.proxy;

import java.util.List;

import hyit.app.dao.IScheduleInfoDAO;
import hyit.app.dao.impl.ScheduleInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.ScheduleInfo;

public class ScheduleInfoDAOProxy implements IScheduleInfoDAO {
	private DatabaseConnection dbc = null;
	private IScheduleInfoDAO dao = null;

	public ScheduleInfoDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new ScheduleInfoDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(ScheduleInfo info) throws Exception {
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
	public boolean update(ScheduleInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ScheduleInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduleInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		ScheduleInfo info = null;
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
	public List<ScheduleInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
