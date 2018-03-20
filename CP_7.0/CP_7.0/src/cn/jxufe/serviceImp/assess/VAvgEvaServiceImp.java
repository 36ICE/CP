package cn.jxufe.serviceImp.assess;

import java.util.Collection;

import cn.jxufe.dao.vdao.VAvgEvaDao;
import cn.jxufe.daoImp.vdaoImp.VAvgEvaDaoImp;
import cn.jxufe.domain.ventity.VAvgEva;
import cn.jxufe.service.assess.VAvgEvaService;

public class VAvgEvaServiceImp implements VAvgEvaService {

	@Override
	public Collection<VAvgEva> findVAvgEvaByuserNumAndUnitId(String userNum,int unitId) throws Exception {
		VAvgEvaDao vAvgEvaDao=new VAvgEvaDaoImp();
		return vAvgEvaDao.selectByUserNumAndUnitId(userNum, unitId);
	}

	@Override
	public Collection<VAvgEva> findVAvgEvaByuserIdAndUnitId(int userId,
			int unitId) throws Exception {
		// TODO Auto-generated method stub
		return new VAvgEvaDaoImp().selectByUserIdAndUnitId(userId, unitId);
	}
	@Override
	public VAvgEva selectByUserNumAndUnitIdAndTermNum(String userNum, int unitId,int termNum)throws Exception{
		return new VAvgEvaDaoImp().selectByUserNumAndUnitIdAndTermNum(userNum, unitId, termNum);
	}
	

}
