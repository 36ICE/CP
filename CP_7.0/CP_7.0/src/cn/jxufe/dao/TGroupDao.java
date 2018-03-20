package cn.jxufe.dao;

import cn.jxufe.domain.TGroup;

public interface TGroupDao {

	/**
	 * @author A
	 *	组查找：groupId
	 *	组的增加：groupId,groupName,groupCom
	 *	组的删除：groupId
	 *	组修改：groupId,groupName,groupCom
	 * @return 
	 */
	
	public boolean checkbyID(long groupId)throws Exception;
	public boolean InsertTGroup(long groupId,String groupName,String groupCom)throws Exception;
	public boolean DeletebyID(long groupId) throws Exception;
	public boolean UpdatebyID(long groupId,String groupName,String groupCom)throws Exception;
	boolean InsertTGroup(TGroup tgroup) throws Exception;
	boolean UpdatebyID(TGroup tgroup) throws Exception;
}