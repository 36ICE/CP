package cn.jxufe.test;

import cn.jxufe.service.system.TOpenTimeService;
import cn.jxufe.serviceImp.system.TOpenTimeServiceImp;

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TOpenTimeService  tOpenTimeService=new TOpenTimeServiceImp();
		String yearnow=tOpenTimeService.getNowTime("yyyy");
		String month1="03";
		String month2="08";
		String monthnow=tOpenTimeService.getNowTime("MM");
		String year_month=tOpenTimeService.getNowTime("yyyy-MM-dd");
		System.out.println(yearnow);
		System.out.println(monthnow);
		int year=2014;

		System.out.println(month1.compareTo(monthnow));
		System.out.println(month2.compareTo(monthnow));
		System.out.println(String.valueOf(monthnow));
		//int result=tOpenTimeService.compare_date(year_month, year+"-07-01", year+"-12-31");
		//System.out.println(result);
	}

}
