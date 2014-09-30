package hyit.app.dao.proxy;

import java.util.List;

import hyit.app.dao.ICheckInfoDAO;
import hyit.app.dao.impl.CheckInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.CheckInfo;

public class CheckInfoDAOProxy implements ICheckInfoDAO {
	private DatabaseConnection dbc = null;
	private ICheckInfoDAO dao = null;
	
	public CheckInfoDAOProxy() throws Exception{
		this.dbc = new DatabaseConnection();
		this.dao = new CheckInfoDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(CheckInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CheckInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CheckInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheckInfo> getByCronNumber(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheckInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheckInfo> getByCronNumberAndStudentNumber(Integer cronNumber,
			long studentNumber) throws Exception {
		// TODO Auto-generated method stub
		List<CheckInfo> list = null;
		try{
			list = this.dao.getByCronNumberAndStudentNumber(cronNumber, studentNumber);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
		return list;
	}

}
