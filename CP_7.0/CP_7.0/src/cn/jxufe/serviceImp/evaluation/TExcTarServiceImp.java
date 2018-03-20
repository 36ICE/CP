package cn.jxufe.serviceImp.evaluation;

import java.util.Collection;

import cn.jxufe.dao.TExcTarDao;
import cn.jxufe.daoImp.TExcTarDaoImp;
import cn.jxufe.domain.TExcTar;
import cn.jxufe.service.evaluation.TExcTarService;

public class TExcTarServiceImp implements TExcTarService {


	@Override
	public TExcTar select(int excTarId) throws Exception {
		TExcTarDao tExcTarDao=new TExcTarDaoImp();
		TExcTar   tExcTar   =null;
		//!!!!!daoImp里面不要new，不好判断
		tExcTar=tExcTarDao.findTExcTarByExcTarId(excTarId);
		
		return tExcTar;
	}

	@Override
	public boolean update(TExcTar tExcTar) throws Exception {
		TExcTarDao tExcTarDao=new TExcTarDaoImp();
		try {
			if(true){
				tExcTarDao.alterTExcTarByExcTarId(tExcTar);
				
			}else{
				tExcTarDao.addTExcTar(tExcTar);
				
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		
		
	}

	@Override
	public boolean delete(int tExcTarId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}




}
