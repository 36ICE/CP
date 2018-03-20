package cn.jxufe.service.assess;

import java.util.Collection;

import cn.jxufe.domain.ventity.VAvgEva;

public interface VAvgEvaService {

	Collection<VAvgEva> findVAvgEvaByuserNumAndUnitId(String userNum,
			int unitId)throws Exception;
	
	Collection<VAvgEva> findVAvgEvaByuserIdAndUnitId(int userId,
			int unitId)throws Exception;

	VAvgEva selectByUserNumAndUnitIdAndTermNum(String userNum, int unitId,
			int termNum) throws Exception;
}
