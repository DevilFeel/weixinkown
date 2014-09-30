package hyit.app.dao;

import java.util.List;

import hyit.app.model.StudentInfo;

public interface IStudentInfoDAO {
	public boolean doCreate(StudentInfo info)throws Exception;
	
	public boolean update(StudentInfo info) throws Exception;
	
	public StudentInfo delete(Integer number) throws Exception;

	public StudentInfo getByID(Long number) throws Exception;
	
	public List<StudentInfo> getByClassNumber(Integer number)throws Exception;
	
	public List<StudentInfo> getAll()throws Exception;
}
