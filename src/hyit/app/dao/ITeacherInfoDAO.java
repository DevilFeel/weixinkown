package hyit.app.dao;

import java.util.List;

import hyit.app.model.TeacherInfo;

public interface ITeacherInfoDAO {
	public boolean doCreate(TeacherInfo info) throws Exception;

	public TeacherInfo check(TeacherInfo info) throws Exception;

	public boolean update(TeacherInfo info) throws Exception;

	public TeacherInfo delete(Integer number) throws Exception;

	public TeacherInfo getByID(Integer number) throws Exception;

	public List<TeacherInfo> getByDepartmentNumber(Integer number)
			throws Exception;

	public List<TeacherInfo> getAll() throws Exception;
}
