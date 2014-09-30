package hyit.app.dao;

import java.util.List;

import hyit.app.model.CheckInfo;

public interface ICheckInfoDAO {
	public boolean doCreate(CheckInfo info) throws Exception;

	public boolean update(CheckInfo info) throws Exception;

	public CheckInfo delete(Integer number) throws Exception;

	public CheckInfo getByID(Integer number) throws Exception;

	public List<CheckInfo> getByCronNumber(Integer number) throws Exception;

	public List<CheckInfo> getAll() throws Exception;
	
	public List<CheckInfo> getByCronNumberAndStudentNumber(Integer cronNumber, long studentNumber) throws Exception;
}
