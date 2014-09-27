package hyit.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hyit.app.dao.IRoommateInfoDAO;
import hyit.app.vo.RoommateInfo;

public class RoommateInfoDAOimpl implements IRoommateInfoDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public RoommateInfoDAOimpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(RoommateInfo roommateInfo) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO roommate_info VALUES(?,?,?,?,?,?,?,?,?,?);";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, roommateInfo.getCardid());
		this.pstmt.setString(2, roommateInfo.getName());
		this.pstmt.setString(3, roommateInfo.getMac());
		this.pstmt.setInt(4, roommateInfo.getDormitory());
		this.pstmt.setLong(5, roommateInfo.getExamid());
		this.pstmt.setString(6, roommateInfo.getSex());
		this.pstmt.setString(7, roommateInfo.getProfession());
		this.pstmt.setString(8, roommateInfo.getClassname());
		this.pstmt.setString(9, roommateInfo.getIdentificationCard());
		this.pstmt.setString(10, roommateInfo.getMiddleSchool());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<RoommateInfo> getRoommateListByBuildingNumber(
			RoommateInfo roommateInfo) throws Exception {
		// TODO Auto-generated method stub
		List<RoommateInfo> all = new ArrayList<RoommateInfo>();
		RoommateInfo roommateInfoTmp = null;
		String sql = "SELECT cardid,`name`,mac,dormitory,examid,sex,profession,"
				+ "classname,identification_card,middle_school FROM roommate_info WHERE dormitory = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, roommateInfo.getDormitory());
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			roommateInfoTmp = new RoommateInfo();
			roommateInfoTmp.setCardid(rs.getInt(1));
			roommateInfoTmp.setName(rs.getString(2));
			roommateInfoTmp.setMac(rs.getString(3));
			roommateInfoTmp.setDormitory(rs.getInt(4));
			roommateInfoTmp.setExamid(rs.getLong(5));
			roommateInfoTmp.setSex(rs.getString(6));
			roommateInfoTmp.setProfession(rs.getString(7));
			roommateInfoTmp.setClassname(rs.getString(8));
			roommateInfoTmp.setIdentificationCard(rs.getString(9));
			roommateInfoTmp.setMiddleSchool(rs.getString(10));
			all.add(roommateInfoTmp);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public RoommateInfo getByCardID(int cardID) throws Exception {
		// TODO Auto-generated method stub
		RoommateInfo roommateInfo = null;
		String sql = "SELECT `name`,mac,dormitory,examid,sex,profession,"
				+ "classname,identification_card,middle_school FROM roommate_info WHERE cardid = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, cardID);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			roommateInfo = new RoommateInfo();
			roommateInfo.setCardid(rs.getInt(new Integer(cardID)));
			roommateInfo.setName(rs.getString(1));
			roommateInfo.setMac(rs.getString(2));
			roommateInfo.setDormitory(rs.getInt(3));
			roommateInfo.setExamid(rs.getLong(4));
			roommateInfo.setSex(rs.getString(5));
			roommateInfo.setProfession(rs.getString(6));
			roommateInfo.setClassname(rs.getString(7));
			roommateInfo.setIdentificationCard(rs.getString(8));
			roommateInfo.setMiddleSchool(rs.getString(9));
		}
		this.pstmt.close();
		return roommateInfo;
	}

	@Override
	public RoommateInfo getByIdentificationCard(String identificationCard)
			throws Exception {
		// TODO Auto-generated method stub
		RoommateInfo roommateInfo = null;
		String sql = "SELECT cardid,`name`,mac,dormitory,examid,sex,profession,classname,"
				+ "identification_card,middle_school FROM roommate_info WHERE identification_card = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, identificationCard);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			roommateInfo = new RoommateInfo();
			roommateInfo.setCardid(rs.getInt(1));
			roommateInfo.setName(rs.getString(2));
			roommateInfo.setMac(rs.getString(3));
			roommateInfo.setDormitory(rs.getInt(4));
			roommateInfo.setExamid(rs.getLong(5));
			roommateInfo.setSex(rs.getString(6));
			roommateInfo.setProfession(rs.getString(7));
			roommateInfo.setClassname(rs.getString(8));
			roommateInfo.setIdentificationCard(rs.getString(9));
			roommateInfo.setMiddleSchool(rs.getString(10));
		}
		return roommateInfo;
	}
}
