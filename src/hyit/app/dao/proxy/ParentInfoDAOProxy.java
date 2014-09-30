package hyit.app.dao.proxy;

import java.util.List;

import hyit.app.dao.IParentInfoDAO;
import hyit.app.dao.impl.ParentInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.ParentInfo;

public class ParentInfoDAOProxy implements IParentInfoDAO {
	private DatabaseConnection dbc = null;
	private IParentInfoDAO dao = null;
	
	public ParentInfoDAOProxy() throws Exception{
		this.dbc = new DatabaseConnection();
		this.dao = new ParentInfoDAOImpl(this.dbc.getConnection());
	}
	
	@Override
	public boolean doCreate(ParentInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ParentInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ParentInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParentInfo getByOpenid(String openid) throws Exception {
		// TODO Auto-generated method stub
		ParentInfo info = null;
		try{
			info = this.dao.getByOpenid(openid);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return info;
	}

	@Override
	public List<ParentInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
