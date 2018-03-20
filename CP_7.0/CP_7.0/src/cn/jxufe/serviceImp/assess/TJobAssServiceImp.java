package cn.jxufe.serviceImp.assess;

import cn.jxufe.dao.TJobAssDao;
import cn.jxufe.dao.TUserDao;
import cn.jxufe.daoImp.TJobAssDaoImp;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.domain.TJobAss;
import cn.jxufe.domain.TUser;
import cn.jxufe.service.assess.TJobAssService;

public class TJobAssServiceImp implements TJobAssService {

	@Override
	public boolean isSubmit(String userNum,String termNum){
		
		return false;
	}
	@Override
	public boolean updateTJobAss(String userNum,String name, String value) throws Exception {
		
		TUserDao tUserDao=new TUserDaoImp();
		int userId=(int)tUserDao.findAllByUserNum(userNum).getUserId();
		
		TJobAssDao tJobAssDao=new TJobAssDaoImp();
		//如果已存在，则更新，否则增加
		if(tJobAssDao.checkByUserId(userId)){
			if(tJobAssDao.updateByUserIdAndValue(userId, name, value)){
				return true;
			}
		}else{
			if(tJobAssDao.addJobAssByNameAndValue(userId, name, value)){
				return true;
			}
		}
	
		
		return false;
	}

	@Override
	public TJobAss selectTJobAss(String userNum) throws Exception {
		TUserDao tUserDao=new TUserDaoImp();
		int userId=(int)tUserDao.findAllByUserNum(userNum).getUserId();
		TJobAssDao tJobAssDao=new TJobAssDaoImp();
		
	    return tJobAssDao.findByUserId(userId);
	
	}

	@Override
	public boolean deleteTJobAss(String userNum) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



}
