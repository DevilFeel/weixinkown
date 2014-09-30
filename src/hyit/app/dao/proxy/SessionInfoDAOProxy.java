package hyit.app.dao.proxy;

import java.util.List;

import hyit.app.dao.ISessionInfoDAO;
import hyit.app.dao.impl.SessionInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.SessionInfo;

public class SessionInfoDAOProxy implements ISessionInfoDAO {
	private DatabaseConnection dbc = null;
	private ISessionInfoDAO dao = null;

	public SessionInfoDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new SessionInfoDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(SessionInfo info) throws Exception {
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
	public boolean update(SessionInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SessionInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		SessionInfo info = null;
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
	public List<SessionInfo> getBySubjectNumber(Integer number)
			throws Exception {
		// TODO Auto-generated method stub
		List<SessionInfo> all = null;
		try {
			all = this.dao.getBySubjectNumber(number);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<SessionInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionInfo getByName(Integer subjectNumber, String name)
			throws Exception {
		// TODO Auto-generated method stub
		SessionInfo info = null;
		try {
			info = this.dao.getByName(subjectNumber, name);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return info;
	}

}
