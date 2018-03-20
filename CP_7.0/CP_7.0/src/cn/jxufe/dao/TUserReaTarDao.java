package cn.jxufe.dao;
public interface TUserReaTarDao {

	/**
	 * @return
	 * @throws Exception
	 */
	public int findReaTarIdByUserIdAndTermNum(int userId,int termNum)throws Exception;

	boolean cheackUserId(int userId, int termNum) throws Exception;
}