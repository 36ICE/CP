package cn.jxufe.test;

import cn.jxufe.service.system.TOpenTimeService;
import cn.jxufe.serviceImp.system.TOpenTimeServiceImp;

public class ZCDTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TOpenTimeService tOpenTimeService=new TOpenTimeServiceImp();
		//"yyyy-MM-dd HH:mm" 24小时制  "yyyy-MM-dd hh:mm"   12小时制
		String dateformat="yyyy-MM-dd HH:mm:ss";
		int i;
		i= tOpenTimeService.compare_date("2016-04-30 10:58:00", "2016-04-29 09:59:00","2016-05-01 09:59:00");
		System.out.println(tOpenTimeService.getNowTime(dateformat));
		i= tOpenTimeService.compare_date(tOpenTimeService.getNowTime(dateformat), "2016-04-29 09:59:00","2016-05-01 09:59:00");
	}

}
