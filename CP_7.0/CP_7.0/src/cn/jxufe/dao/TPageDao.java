package cn.jxufe.dao;

public interface TPageDao {
	/**
	 * @author A
	 *	页面查找：pageId
	 *  页面增加：pageId，pageName，pageUrl，pageComment
	 *  页面删除：pageId
	 *  页面修改：pageId，pageName，pageUrl，pageComment
	 */
	
	public void checkbyID(long pageId)throws Exception;
	public void InsertTPage(long pageId,String pafeName,String pageUrl,String pageComment)throws Exception;
	public void DeletebyID(long pageId) throws Exception;
	public void UpdatebyID(long pageId,String pafeName,String pageUrl,String pageComment)throws Exception;
	

}