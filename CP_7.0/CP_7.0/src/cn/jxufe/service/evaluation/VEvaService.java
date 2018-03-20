package cn.jxufe.service.evaluation;

import cn.jxufe.domain.ventity.VEva;

public interface VEvaService {

	VEva findByUserNum(String userNum, int termNum) throws Exception;

	
}
