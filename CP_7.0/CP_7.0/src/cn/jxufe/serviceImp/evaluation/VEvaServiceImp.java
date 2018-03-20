package cn.jxufe.serviceImp.evaluation;

import cn.jxufe.dao.vdao.VEvaDao;
import cn.jxufe.daoImp.vdaoImp.VEvaDaoImp;
import cn.jxufe.domain.ventity.VEva;
import cn.jxufe.service.evaluation.VEvaService;

public class VEvaServiceImp implements VEvaService {

	@Override
	public VEva findByUserNum(String userNum,int termNum) throws Exception {
		VEvaDao vEvaDao=new VEvaDaoImp();
		
		
		return vEvaDao.findByUserNum(userNum, termNum);
	}

}
