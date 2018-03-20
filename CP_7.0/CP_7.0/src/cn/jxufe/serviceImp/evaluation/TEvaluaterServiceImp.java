package cn.jxufe.serviceImp.evaluation;

import java.util.Collection;

import cn.jxufe.dao.TEvaluaterDao;
import cn.jxufe.dao.TUserDao;
import cn.jxufe.daoImp.TEvaluaterDaoImp;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.domain.TEvaluate;
import cn.jxufe.domain.TEvaluater;
import cn.jxufe.domain.TUser;
import cn.jxufe.service.evaluation.TEvaluateService;
import cn.jxufe.service.evaluation.TEvaluaterService;
import cn.jxufe.service.user.TUserService;
import cn.jxufe.serviceImp.user.TUserServiceImp;

public class TEvaluaterServiceImp implements TEvaluaterService {

	@Override
	public Collection<TEvaluater> findByEvaUserNum(String evauserNum)
			throws Exception {
		
		TUserDao tUserDao=new TUserDaoImp();
		TUser tUser =tUserDao.findAllByUserNum(evauserNum);
		int evauserId=(int)tUser.getUserId();
		
		
		int year=tUser.getYear();
		TUserService tUserService=new TUserServiceImp();	
		int termNum=tUserService.getTermNumByYear(year);
		
		TEvaluaterDao tEvaluaterDao=new TEvaluaterDaoImp();

		return tEvaluaterDao.findByEvaUserId(evauserId, termNum);
	}
	@Override
	public boolean changeSubmitState(int eveluaterId){
		TEvaluaterDao tEvaluaterDao=new TEvaluaterDaoImp();
		if(tEvaluaterDao.changeSubmitState(eveluaterId)){
			return true;
		}else{
			return false;
		}
		
	}

}
