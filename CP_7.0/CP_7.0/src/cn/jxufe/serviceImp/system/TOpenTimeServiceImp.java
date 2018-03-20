package cn.jxufe.serviceImp.system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.jxufe.service.system.TOpenTimeService;

/**
 * 
 *  主要是提供检测是否在一时间段的服务
 * @author Administrator
 *
 */
public class TOpenTimeServiceImp implements TOpenTimeService {

	public String dateformat = "yyyy-MM-dd hh:mm:ss";
	public String nowDate;
	public String startDate;
	public String endDate;
	// -1 出错 0 为开始 1正确 2过期
	private static final int ERROR = -1;
	private static final int BEFORE = 0;
	private static final int NOW = 1;
	private static final int AFTER = 2;

	// 构造函数

	public TOpenTimeServiceImp(String dateformat, String nowDate,
			String startDate, String endDate) {
		this.dateformat = dateformat;
		this.nowDate = nowDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	//
	public TOpenTimeServiceImp() {

	}

	@Override
	public boolean isServiceOut() {
		
		
		return false;
	}

	// 获取当天时间
	public String getNowTime(String dateformat) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式
		String strNow = dateFormat.format(now);
		return strNow;
	}

	public int compare_date(String nowDate, String startDate, String endDate) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date nowDt = df.parse(nowDate);
			Date startDt = df.parse(startDate);
			Date endDt = df.parse(endDate);

			if (nowDt.getTime() >= startDt.getTime()
					& nowDt.getTime() <= endDt.getTime()) {
				System.out.println("nowdate (" + nowDate + ")在startDate"
						+ startDate + "和endDate(" + endDate + "之间");
				return NOW;
			} else if (nowDt.getTime() < startDt.getTime()) {
				System.out.println("nowDate" + nowDate + "在startdate("
						+ startDate + "前，功能未开启");
				return BEFORE;
			} else {
				System.out.println("nowDate" + nowDate + "在ensdate(" + endDate
						+ "后，时间过期");
				return AFTER;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return ERROR;
		}

	}

	public int compare_date() {

		try {
			// 如果未初始化报错
			if (nowDate == "" | startDate == "" | endDate == ""
					| dateformat == "") {

				DateFormat df = new SimpleDateFormat(dateformat);
				Date nowDt = df.parse(nowDate);
				Date startDt = df.parse(startDate);
				Date endDt = df.parse(endDate);

				if (nowDt.getTime() >= startDt.getTime()
						& nowDt.getTime() <= endDt.getTime()) {
					System.out.println("nowdate (" + nowDate + ")在startDate"
							+ startDate + "和endDate(" + endDate + "之间");
					return NOW;
				} else if (nowDt.getTime() < startDt.getTime()) {
					System.out.println("nowDate" + nowDate + "在startdate("
							+ startDate + "前，功能未开启");
					return AFTER;
				} else {
					System.out.println("nowDate" + nowDate + "在ensdate("
							+ endDate + "后，时间过期");
					return BEFORE;
				}
			} else {
				return ERROR;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			return ERROR;
		}

	}

	public int compare_date(String nowDate, String startDate, String endDate,
			String dateformat) {

		try {
			DateFormat df = new SimpleDateFormat(dateformat);
			Date nowDt = df.parse(nowDate);
			Date startDt = df.parse(startDate);
			Date endDt = df.parse(endDate);

			if (nowDt.getTime() >= startDt.getTime()
					& nowDt.getTime() <= endDt.getTime()) {
				System.out.println("nowdate (" + nowDate + ")在startDate"
						+ startDate + "和endDate(" + endDate + "之间");
				return NOW;
			} else if (nowDt.getTime() < startDt.getTime()) {
				System.out.println("nowDate" + nowDate + "在startdate("
						+ startDate + "前，功能未开启");
				return BEFORE;
			} else {
				System.out.println("nowDate" + nowDate + "在ensdate(" + endDate
						+ "后，时间过期");
				return AFTER;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return ERROR;
		}

	}

}
