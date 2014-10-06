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
		boolean flag = false;
		try {
			if (this.dao.getByOpenid(info.getOpenid()) == null) {
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

	@Override
	public boolean search(String openid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.getByOpenid(openid) == null) {
				flag = this.dao.search(openid);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

}
