package hyit.app.dao;

import java.util.List;

import hyit.app.model.SemesterInfo;

public interface ISemesterInfoDAO {
	public boolean doCreate(SemesterInfo info) throws Exception;

	public boolean update(SemesterInfo info) throws Exception;

	public SemesterInfo delete(Integer number) throws Exception;

	public SemesterInfo getByID(Integer number) throws Exception;
	
	public List<SemesterInfo> getAll() throws Exception;

}
