package cn.jxufe.dao;
public interface TRoleDao {
	/**
	 * @author A
	 *	角色查找：roleId
	 *	角色的增加：roleId,roleName,roleCom
	 *	角色的删除：roleId
	 *	角色修改：roleId,roleName,roleCom
	 */
	
	public void checkbyID(long roleId)throws Exception;
	public void InsertTRole(long roleId,String roleName,String roleCom)throws Exception;
	public void DeletebyID(long roleId) throws Exception;
	public void UpdatebyID(long roleId,String roleName,String roleCom)throws Exception;
}