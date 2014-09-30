package hyit.app.dao;

import java.util.List;

import hyit.app.model.ScheduleInfo;

public interface IScheduleInfoDAO {
	public boolean doCreate(ScheduleInfo info) throws Exception;

	public boolean update(ScheduleInfo info) throws Exception;

	public ScheduleInfo delete(Integer number) throws Exception;

	public ScheduleInfo getByID(Integer number) throws Exception;

	public List<ScheduleInfo> getAll() throws Exception;
}
