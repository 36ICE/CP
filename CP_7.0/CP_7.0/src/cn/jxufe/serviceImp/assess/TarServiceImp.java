package cn.jxufe.serviceImp.assess;


import cn.jxufe.dao.TExcTarDao;
import cn.jxufe.dao.TReaTarDao;
import cn.jxufe.dao.TUserDao;
import cn.jxufe.dao.TUserExcTarDao;
import cn.jxufe.dao.TUserReaTarDao;
import cn.jxufe.daoImp.TExcTarDaoImp;
import cn.jxufe.daoImp.TReaTarDaoImp;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.daoImp.TUserExcTarDaoImp;
import cn.jxufe.daoImp.TUserReaTarDaoImp;
import cn.jxufe.domain.TExcTar;
import cn.jxufe.domain.TReaTar;
import cn.jxufe.service.assess.TarService;

public class TarServiceImp implements TarService {

	

	@Override
	public boolean updateExcTar(String userNum, String name, String value,int termNum) throws Exception {
		TUserDao tUserDao=new TUserDaoImp();
		int userId=(int)tUserDao.findAllByUserNum(userNum).getUserId();
		
		TUserExcTarDao tUserExcTarDao=new TUserExcTarDaoImp();
		TExcTarDao tExcTarDao=new TExcTarDaoImp();
		int excTarId=tUserExcTarDao.findExcTarIdByUserIdAndTermNum(userId, termNum);
		//未填
		if(excTarId==0){
			tExcTarDao.addExcTarByNameAndValue(excTarId, name, value);
			return false;
		}else{
			if(tExcTarDao.cheackExcTarId(excTarId) & tExcTarDao.updateByExcTarId(excTarId, name, value)){
				return true;
			}else{
				return false;
			}	
				
		}
		
		
	}

	@Override
	public boolean updateReaTar(String userNum, String name, String value,
			int termNum) throws Exception {
		TUserDao tUserDao=new TUserDaoImp();
		int userId=(int)tUserDao.findAllByUserNum(userNum).getUserId();
		
		TUserReaTarDao tUserReaTarDao=new TUserReaTarDaoImp();
		TReaTarDao tReaTarDao=new TReaTarDaoImp();
		int reaTarId=tUserReaTarDao.findReaTarIdByUserIdAndTermNum(userId, termNum);
		//未填
		if(reaTarId==0){
			
			tReaTarDao.addReaTarByNameAndValue(reaTarId, name, value);
			return false;
		}else{
			if(tReaTarDao.cheackReaTarId(reaTarId) & tReaTarDao.updateByReaTarId(reaTarId, name, value)){
				return true;
			}else{
				return false;
			}	
				
		}
		
	}

	@Override
	public TReaTar selectReaTar(String userNum, int termNum)
			throws Exception {
		
		TReaTar tReaTar =new TReaTar();
		TUserDao tUserDao=new TUserDaoImp();
		int userId=(int)tUserDao.findAllByUserNum(userNum).getUserId();
		
		TUserReaTarDao tUserReatarDao=new TUserReaTarDaoImp();
		try {
			if(tUserReatarDao.cheackUserId(userId, termNum)){
				TReaTarDao tReaTarDao=new TReaTarDaoImp();
				int reaTarId=tUserReatarDao.findReaTarIdByUserIdAndTermNum(userId, termNum);
				
				return tReaTarDao.findTReaTarByReaTarId(reaTarId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tReaTar;
		
		
	}

	@Override
	public TExcTar selectExcTar(String userNum, int termNum)
			throws Exception {
		TExcTar tExcTar=new TExcTar();
		
		TUserDao tUserDao=new TUserDaoImp();
		int userId=(int)tUserDao.findAllByUserNum(userNum).getUserId();
			
		TUserExcTarDao tUserExcTarDao=new TUserExcTarDaoImp();
		
		TExcTarDao tExcTarDao=new TExcTarDaoImp();
		try {
			if(tUserExcTarDao.cheackUserId(userId, termNum)){
				int excTarId=tUserExcTarDao.findExcTarIdByUserIdAndTermNum(userId, termNum);
			
				return tExcTarDao.findTExcTarByExcTarId(excTarId);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		return tExcTar;
			
	}

	@Override
	public boolean deleteReaTar(String userNum, int termNum)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteExcTar(String userNum, int termNum)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
