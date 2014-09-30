package hyit.app.dao;

import java.util.List;

import hyit.app.model.SessionInfo;

public interface ISessionInfoDAO {
	public boolean doCreate(SessionInfo info)throws Exception;
	
	public boolean update(SessionInfo info) throws Exception;
	
	public SessionInfo delete(Integer number)throws Exception;
	
	public SessionInfo getByID(Integer number) throws Exception;
	
	public SessionInfo getByName(Integer subjectNumber, String name)throws Exception;
	
	public List<SessionInfo> getBySubjectNumber(Integer number)throws Exception;
	
	public List<SessionInfo> getAll()throws Exception;
	
}
