package hyit.app.dao;

import hyit.app.model.ClassInfo;

import java.util.List;



public interface IClassInfoDAO {
	public boolean doCreate(ClassInfo info) throws Exception;

	public ClassInfo getByID(Integer number) throws Exception;

	public boolean update(ClassInfo info) throws Exception;

	public ClassInfo delete(Integer number) throws Exception;
	
	public ClassInfo getByName(String name)throws Exception;

	public List<ClassInfo> getByDepartmentNumber(Integer number)
			throws Exception;

	public List<ClassInfo> getByTeacherNumber(Integer number) throws Exception;

	public List<ClassInfo> getAll() throws Exception;
}
