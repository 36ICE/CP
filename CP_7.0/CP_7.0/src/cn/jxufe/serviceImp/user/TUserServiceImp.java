package cn.jxufe.serviceImp.user;

import javax.xml.crypto.Data;

import cn.jxufe.dao.TUserDao;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.domain.TUser;
import cn.jxufe.service.system.TOpenTimeService;
import cn.jxufe.service.user.TUserService;
import cn.jxufe.serviceImp.system.TOpenTimeServiceImp;

public class TUserServiceImp implements TUserService {

	@Override
	public boolean Login(String userNum, String code,TUser tuser) throws Exception {
		TUserDao userdao=new TUserDaoImp();
		if(userdao.checkUserNumAndCode(userNum, code,tuser))
			return true;
		else{
			return false;
		}
		
		
	}

	@Override
	public boolean register() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requestRegister() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleRegister() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTermNumByYear(int year){
		TOpenTimeService  tOpenTimeService=new TOpenTimeServiceImp();
		int yearnow=Integer.parseInt(tOpenTimeService.getNowTime("yyyy"));
		String monthnow=tOpenTimeService.getNowTime("MM");
		String month1="03";
		String month2="07";
		if(month1.compareTo(monthnow)>=0){
			return 2*(yearnow-year)-1;
		}else if(month1.compareTo(monthnow)<0 & month2.compareTo(monthnow)>0){
			return 2*(yearnow-year);
		}else{
			return 2*(yearnow-year)+1;
		}
		
	}
}
