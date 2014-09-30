package hyit.app.dao;

import java.util.List;

import hyit.app.model.SubjectInfo;

public interface ISubjectInfoDAO {
	public boolean doCreate(SubjectInfo info) throws Exception;

	public boolean update(SubjectInfo info) throws Exception;

	public SubjectInfo delete(Integer number) throws Exception;

	public SubjectInfo getByID(Integer number) throws Exception;

	public SubjectInfo getByName(String name, Integer teacherNumber,
			Integer semesterNumber) throws Exception;

	public List<SubjectInfo> getByTeacherNumber(Integer teacherNumber)
			throws Exception;

	public List<SubjectInfo> getByTeacherNumberAndSemesterNumber(
			Integer teacherNumber, Integer semesterNumber) throws Exception;

	public List<SubjectInfo> getBySemesterNumber(Integer number)
			throws Exception;

	public List<SubjectInfo> getAll() throws Exception;
}
