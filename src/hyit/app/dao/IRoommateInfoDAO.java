package hyit.app.dao;

import java.util.List;

import hyit.app.vo.RoommateInfo;

public interface IRoommateInfoDAO {
	public boolean doCreate(RoommateInfo roommateInfo) throws Exception;

	public List<RoommateInfo> getRoommateListByBuildingNumber(
			RoommateInfo roommateInfo) throws Exception;

	public RoommateInfo getByCardID(int cardID) throws Exception;

	public RoommateInfo getByIdentificationCard(String identificationCard)
			throws Exception;
}
