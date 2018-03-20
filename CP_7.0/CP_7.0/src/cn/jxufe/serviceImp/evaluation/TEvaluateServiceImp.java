package cn.jxufe.serviceImp.evaluation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import cn.jxufe.dao.TEvaluateDao;
import cn.jxufe.daoImp.TEvaluateDaoImp;
import cn.jxufe.domain.TEvaluate;
import cn.jxufe.domain.TEvaluater;
import cn.jxufe.service.evaluation.TEvaluateService;
import cn.jxufe.service.evaluation.TEvaluaterService;

public class TEvaluateServiceImp implements TEvaluateService {

	@Override
	public TEvaluate select() throws Exception {

		return null;
	}




	@Override
	public boolean update(int evaluaterId,TEvaluate tEvaluate) throws Exception {
		TEvaluateDao tEvaluateDao=new  TEvaluateDaoImp();
		
		//检测是否有数据， 学期号对象的数据 
		//tEvaluateDao.checkbyID(tEvaluate.getEvaluateId()
		//如果有则修改哈，否则增加一条数据
		try {
			
				tEvaluateDao.addTEvaluate(tEvaluate);
				//tEvaluateDao.alterByEvaluateId(evaluaterId, tEvaluate);
			//	tEvaluateDao.alterByEvaluateId(1,tEvaluate);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}




	@Override
	public boolean delete(int evaluateId) throws Exception {
		TEvaluateDao tEvaluateDao=new  TEvaluateDaoImp();
		//检查是否存在，存在则删除，否则返回false
		try {
			if(true){
				tEvaluateDao.DeletebyEvaluateId(evaluateId);
				return true;
			}
			else{
				return false;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	
	}
	@Override
	public Collection<TEvaluate> findByUserNumAndTermNum(String userNum){
		Collection<TEvaluate> tEvaluates=new ArrayList<>();
		Collection<TEvaluater> tEvaluaters=new ArrayList<>();
		TEvaluaterService tEvaluaterService=new TEvaluaterServiceImp();
		try {
			tEvaluaters=tEvaluaterService.findByEvaUserNum(userNum);
			
			TEvaluateDao tEvaluateDao=new TEvaluateDaoImp();
			Iterator it=tEvaluaters.iterator();
			while(it.hasNext()){
				TEvaluater tEvaluater=(TEvaluater)it.next();
				int	tEvaluateId=(int) tEvaluater.getEvaluaterId();
				tEvaluates.add(tEvaluateDao.FindByEvalusteId(tEvaluateId));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return tEvaluates;
	}
	

	
}
