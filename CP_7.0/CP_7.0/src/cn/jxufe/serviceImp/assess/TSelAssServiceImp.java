package cn.jxufe.serviceImp.assess;

import cn.jxufe.dao.TSelAssDao;
import cn.jxufe.dao.TUserDao;
import cn.jxufe.daoImp.TSelAssDaoImp;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.domain.TSelAss;
import cn.jxufe.service.assess.TSelAssService;

public class TSelAssServiceImp implements TSelAssService {

	@Override
	public boolean updateTSelAss(String userNum,String name, String value) throws Exception {
		//更新到数据库,每次改变一列，调用服务，参数为 value
		TUserDao tUserDao=new TUserDaoImp();
		int userId=(int)tUserDao.findAllByUserNum(userNum).getUserId();
		TSelAssDao tSelAssDao =new TSelAssDaoImp();
		if(tSelAssDao.checkUserId(userId)){
			if(tSelAssDao.updateByUserIdAndValue(userId, name, value)){
				return true;
			}
		}else{
			if(tSelAssDao.addJobAssByNameAndValue(userId, name, value)){
				return true;
			}
		}
		
				return false;
	}
	


	@Override
	public boolean deleteTSelAss(int selAssId) throws Exception {
	
		return false;
	}


	@Override
	public TSelAss selectTSelAss(String userNum) throws Exception {
		TUserDao tUserDao=new TUserDaoImp();
		int userId=(int)tUserDao.findAllByUserNum(userNum).getUserId();
		TSelAssDao tSelAssDao=new TSelAssDaoImp();
		return tSelAssDao.findByUserId(userId);
	}

}
