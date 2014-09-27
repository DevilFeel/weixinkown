package hyit.app.dao.proxy;

import hyit.app.dao.IRoommateInfoDAO;
import hyit.app.dao.impl.RoommateInfoDAOimpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.vo.RoommateInfo;

import java.util.List;

public class RoommateInfoDAOProxy implements IRoommateInfoDAO {
	private DatabaseConnection dbc = null;
	private IRoommateInfoDAO dao = null;

	public RoommateInfoDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new RoommateInfoDAOimpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(RoommateInfo roommateInfo) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.getByCardID(roommateInfo.getCardid()) == null) {
				flag = this.dao.doCreate(roommateInfo);
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
	public List<RoommateInfo> getRoommateListByBuildingNumber(
			RoommateInfo roommateInfo) throws Exception {
		// TODO Auto-generated method stub
		List<RoommateInfo> all = null;
		try {
			all = this.dao.getRoommateListByBuildingNumber(roommateInfo);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public RoommateInfo getByCardID(int cardID) throws Exception {
		// TODO Auto-generated method stub
		RoommateInfo roommateInfo = null;
		try {
			roommateInfo = this.dao.getByCardID(cardID);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return roommateInfo;
	}

	@Override
	public RoommateInfo getByIdentificationCard(String identificationCard)
			throws Exception {
		// TODO Auto-generated method stub
		RoommateInfo roommateInfo = null;
		try {
			roommateInfo = this.dao.getByIdentificationCard(identificationCard);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return roommateInfo;
	}

}
