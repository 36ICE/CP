package cn.jxufe.service.user;

import java.util.Collection;

import cn.jxufe.domain.ventity.VInfo;

public interface VInfoService {

	public VInfo findVInfoByUserNum(String userNum)throws Exception;


	VInfo findVInfoByUserId(int userId) throws Exception;


	Collection<VInfo> findVInfosbyUnitId(int unitId) throws Exception;
}
