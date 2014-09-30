package hyit.app.dao;

import java.util.List;

import hyit.app.model.ParentInfo;

public interface IParentInfoDAO {
	public boolean doCreate(ParentInfo info) throws Exception;

	public boolean update(ParentInfo info) throws Exception;

	public ParentInfo delete(Integer number) throws Exception;

	public ParentInfo getByOpenid(String openid) throws Exception;

	public List<ParentInfo> getAll() throws Exception;
}
