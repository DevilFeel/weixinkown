package hyit.app.dao.proxy;

import java.util.List;

import hyit.app.dao.ISelectionInfoDAO;
import hyit.app.dao.impl.SelectionInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.SelectionInfo;

public class SelectionInfoDAOProxy implements ISelectionInfoDAO {
	private DatabaseConnection dbc = null;
	private ISelectionInfoDAO dao = null;

	/**
	 * @throws Exception
	 */
	public SelectionInfoDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new SelectionInfoDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(SelectionInfo info) throws Exception {
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
	public boolean update(SelectionInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SelectionInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SelectionInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SelectionInfo> getBySessionNumber(Integer number)
			throws Exception {
		// TODO Auto-generated method stub
		List<SelectionInfo> all = null;
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
	public List<SelectionInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
