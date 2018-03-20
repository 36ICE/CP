package cn.jxufe.serviceImp.evaluation;

import cn.jxufe.dao.TExcTarDao;
import cn.jxufe.dao.TReaTarDao;
import cn.jxufe.daoImp.TExcTarDaoImp;
import cn.jxufe.daoImp.TReaTarDaoImp;
import cn.jxufe.domain.TExcTar;
import cn.jxufe.domain.TReaTar;
import cn.jxufe.service.evaluation.TReaTarSevice;

public class TReaTarSeviceImp implements TReaTarSevice {

	@Override
	public TReaTar select(int tReaTarId) throws Exception {
		TReaTarDao tReaTarDao=new TReaTarDaoImp();
		TReaTar   tReaTar   =null;
		//!!!!!daoImp里面不要new，不好判断
		tReaTarDao.findTReaTarByReaTarId(tReaTarId);
		return tReaTar;
	}

	@Override
	public boolean update(TReaTar tReaTar) throws Exception {
		TReaTarDao tReaTarDao=new TReaTarDaoImp();
		try {
			if(true){
				tReaTarDao.alterTReaTarByReaTarId(tReaTar);
				
			}else{
				tReaTarDao.addTReaTar(tReaTar);
				
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	@Override
	public boolean delete(int tReaTarId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	
}
