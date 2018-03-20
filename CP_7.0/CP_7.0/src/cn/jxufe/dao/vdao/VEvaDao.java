package cn.jxufe.dao.vdao;

import cn.jxufe.domain.ventity.VEva;

public interface VEvaDao {

	

	VEva findByUserNum(String userNum, int termNum) throws Exception;
}
