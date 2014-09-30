package hyit.app.dao;

import java.util.List;

import hyit.app.model.LessonInfo;

public interface ILessonInfoDAO {
	public boolean doCreate(LessonInfo info) throws Exception;

	public boolean update(LessonInfo info) throws Exception;

	public LessonInfo delete(Integer number) throws Exception;

	public LessonInfo getByID(Integer number) throws Exception;

	public List<LessonInfo> getBySessionNumber(Integer number) throws Exception;

	public List<LessonInfo> getAll() throws Exception;

	public LessonInfo getByOther(Integer sessionNumber, Integer week,
			Integer start) throws Exception;
	
}
