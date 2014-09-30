package hyit.app.dao;

import java.util.List;

import hyit.app.model.DepartmentInfo;

public interface IDepartmentInfoDAO {
	public boolean doCreate(DepartmentInfo de) throws Exception;

	public DepartmentInfo getByID(Integer number) throws Exception;

	public boolean update(Integer number) throws Exception;

	public DepartmentInfo delete(Integer number) throws Exception;
	
	public DepartmentInfo getByName(String name)throws Exception;

	public List<DepartmentInfo> getAll() throws Exception;
}
