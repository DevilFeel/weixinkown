package hyit.app.dao;

import java.util.List;

import hyit.app.model.SelectionInfo;

public interface ISelectionInfoDAO {
	public boolean doCreate(SelectionInfo info) throws Exception;

	public boolean update(SelectionInfo info) throws Exception;

	public SelectionInfo delete(Integer number) throws Exception;

	public SelectionInfo getByID(Integer number) throws Exception;

	public List<SelectionInfo> getBySessionNumber(Integer number)
			throws Exception;

	public List<SelectionInfo> getAll() throws Exception;
}
