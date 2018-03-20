package cn.jxufe.dao;
public interface TOperateDao {

	/**
	 * @author A
	 *	操作查找：operateId
	 *	操作的增加：operateId,operateName
	 *	操作的删除：operateId
	 *	操作修改：operateId,operateName
	 * @return 
	 */
	
	public boolean checkbyID(long operateId)throws Exception;
	public boolean InsertTOperate(long operateId,String operateName)throws Exception;
	public boolean DeletebyID(long operateId) throws Exception;
	public boolean UpdatebyID(long operateId,String operateName )throws Exception;
}