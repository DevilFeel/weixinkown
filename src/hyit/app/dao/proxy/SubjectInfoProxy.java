package hyit.app.dao.proxy;

import java.util.List;

import hyit.app.dao.ISubjectInfoDAO;
import hyit.app.dao.impl.SubjectInfoDAOImpl;
import hyit.app.dbc.DatabaseConnection;
import hyit.app.model.SubjectInfo;

public class SubjectInfoProxy implements ISubjectInfoDAO {
	private DatabaseConnection dbc = null;
	private ISubjectInfoDAO dao = null;

	public SubjectInfoProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new SubjectInfoDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(SubjectInfo info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.getByName(info.getName(), info.getTeacherNumber(),
					info.getSemesterNumber()) == null) {
				flag = this.dao.doCreate(info);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean update(SubjectInfo info) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SubjectInfo delete(Integer number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectInfo getByID(Integer number) throws Exception {
		// TODO Auto-generated method stub
		SubjectInfo info = null;
		try {
			info = this.dao.getByID(number);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return info;
	}

	@Override
	public SubjectInfo getByName(String name, Integer teacherNumber,
			Integer semesterNumber) throws Exception {
		// TODO Auto-generated method stub
		SubjectInfo info = null;
		try {
			info = this.dao.getByName(name, teacherNumber, semesterNumber);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return info;
	}

	@Override
	public List<SubjectInfo> getByTeacherNumberAndSemesterNumber(
			Integer teacherNumber, Integer semesterNumber) throws Exception {
		// TODO Auto-generated method stub
		List<SubjectInfo> all = null;
		try {
			all = this.dao.getByTeacherNumberAndSemesterNumber(teacherNumber,
					semesterNumber);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<SubjectInfo> getBySemesterNumber(Integer number)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<SubjectInfo> listAll = null;
		try{
			listAll = this.dao.getAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return listAll;
	}

	@Override
	public List<SubjectInfo> getByTeacherNumber(Integer teacherNumber)
			throws Exception {
		// TODO Auto-generated method stub
		List<SubjectInfo> all = null;
		try {
			all = this.dao.getByTeacherNumber(teacherNumber);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

}
