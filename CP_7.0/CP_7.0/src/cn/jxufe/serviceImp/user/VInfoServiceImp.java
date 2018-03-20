package cn.jxufe.serviceImp.user;

import java.util.Collection;

import cn.jxufe.dao.vdao.VInfoDao;
import cn.jxufe.daoImp.vdaoImp.VInfoDaoImp;
import cn.jxufe.domain.ventity.VInfo;
import cn.jxufe.service.user.VInfoService;

public class VInfoServiceImp implements VInfoService {

	@Override
	public VInfo findVInfoByUserNum(String userNum) throws Exception {
		VInfoDao vInfoDao=new VInfoDaoImp();
		
		return vInfoDao.findByUserNum(userNum);
		
	}
	@Override
	public VInfo findVInfoByUserId(int userId) throws Exception {
		VInfoDao vInfoDao=new VInfoDaoImp();
		
		return vInfoDao.findByUserId(userId);
		
	}
	@Override
	public Collection<VInfo> findVInfosbyUnitId(int unitId)throws Exception{
		VInfoDao vInfoDao=new VInfoDaoImp();
		
		return vInfoDao.findVInfosbyUnitId(unitId);
	}

}
