package hyit.app.dao;

import java.util.List;

import hyit.app.model.CronInfo;

public interface ICronInfoDAO {
	public boolean doCreate(CronInfo info) throws Exception;

	public boolean update(CronInfo info) throws Exception;

	public CronInfo delete(Integer number) throws Exception;

	public CronInfo getByID(Integer number) throws Exception;

	public List<CronInfo> getByLessonNumber(Integer number) throws Exception;

	public List<CronInfo> getAll() throws Exception;
}
