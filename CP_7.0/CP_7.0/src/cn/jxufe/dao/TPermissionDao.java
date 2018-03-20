package cn.jxufe.dao;

public interface TPermissionDao {
	/**
	 * @author A
	 *权限查找：permiId
	 *权限增加：permiId，permiName，permiCom
	 *权限删除：permiId
	 *权限修改：permiId，permiName，permiCom
	 */
	
	public void checkbyID(long permiId)throws Exception;
	public void InsertTPermi(long permiId,String permiName,String permiCom)throws Exception;
	public void DeletebyID(long permiId) throws Exception;
	public void UpdatebyID(long permiId,String permiName,String permiCom)throws Exception;

}