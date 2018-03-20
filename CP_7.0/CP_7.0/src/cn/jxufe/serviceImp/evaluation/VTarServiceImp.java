package cn.jxufe.serviceImp.evaluation;

import java.util.Collection;

import cn.jxufe.dao.TDepartDao;
import cn.jxufe.dao.TUnitDao;
import cn.jxufe.dao.TUserDao;
import cn.jxufe.dao.vdao.VTarDao;
import cn.jxufe.daoImp.TDepartDaoImp;
import cn.jxufe.daoImp.TUnitDaoImp;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.daoImp.vdaoImp.VTarDaoImp;
import cn.jxufe.domain.ventity.VTar;
import cn.jxufe.service.evaluation.VTarService;

public class VTarServiceImp implements VTarService {

	@Override
	public VTar findVTar(String userNum, int termNum) throws Exception {
		
		
		TUserDao tUserDao=new TUserDaoImp();
		int userId=(int)tUserDao.findAllByUserNum(userNum).getUserId();
		
		VTarDao vTarDao=new VTarDaoImp();
		
		return vTarDao.selectTVarByUserIdAndTermNum(userId, termNum);
	}

	@Override
	public Collection<VTar> findVtarsByUnitName(String unitName,int termNum) throws Exception {
		VTar vTar;
		VTarDao vTarDao=new VTarDaoImp();
		
		TUnitDao tUnitDao=new TUnitDaoImp();
		int unitId=tUnitDao.findUnitIdByUnitName(unitName);
		return vTarDao.selectTVarByUnitId(unitId,termNum);
		
		
	}

	@Override
	public Collection<VTar> findVTarsByDepartName(String departName)
			throws Exception {
		
		VTar vTar;
		VTarDao vTarDao=new VTarDaoImp();
		
		TDepartDao tDepartDao=new TDepartDaoImp();
		int departId=tDepartDao.findDepartIdByDepartName(departName);
		
		return vTarDao.selectTVarByDepartId(departId);
	}

	@Override
	public VTar findVTarEvaluateByUserNumAndTermNum(String userNum, int termNum)
			throws Exception {
		VTarDao vTarDao=new VTarDaoImp();
		
		return vTarDao.selectTVarEvaluateByUserNumAndTermNum(userNum, termNum);
	}

}
