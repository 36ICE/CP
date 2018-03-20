package cn.jxufe.dao;
public interface TUserExcTarDao {

	/**
	 * @return
	 * @throws Exception
	 */
	public int findExcTarIdByUserIdAndTermNum(int userId,int termNum)throws Exception;

	boolean cheackUserId(int userId, int termNum) throws Exception;



	
}