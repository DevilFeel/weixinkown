package hyit.app.dao.factory;

import hyit.app.dao.IRoommateInfoDAO;
import hyit.app.dao.proxy.RoommateInfoDAOProxy;

public class DAOFactory {
	public static IRoommateInfoDAO getIIRoommateInfoDAOInstance()
			throws Exception {
		return new RoommateInfoDAOProxy();
	}
}
