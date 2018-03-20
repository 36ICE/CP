package cn.jxufe.dao.vdao;

import java.util.Collection;

import cn.jxufe.domain.ventity.VInfo;


public interface VInfoDao {
	

	
	public VInfo findByUserNum(String userNum)throws Exception;

	VInfo findByUserId(int userId) throws Exception;

	Collection<VInfo> findVInfosbyUnitId(int unitId) throws Exception;

	boolean checkUserNum(String userNum);
}
