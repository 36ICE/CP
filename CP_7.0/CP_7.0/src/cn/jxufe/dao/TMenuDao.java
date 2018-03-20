package cn.jxufe.dao;

public interface TMenuDao {
	/**
	 * @author A
	 *	菜单查找：menuId
	 *	菜单的增加：menuId,menuName,menuUrl,parentId,menuComment
	 *	菜单的删除：menuId
	 *	菜单修改：menuId,menuName,menuUrl,parentId,menuComment
	 * @return 
	 */
	
	public boolean checkbyID(long menuId)throws Exception;
	public void InsertTMenu(long menuId,String menuName,String menuUrl,long parentId,String menuComment)throws Exception;
	public void DeletebyID(long menuId) throws Exception;
	public void UpdatebyID(long menuId,String menuName,String menuUrl,long parentId,String menuComment)throws Exception;
	

}