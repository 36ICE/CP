package cn.jxufe.service.system;

/**
 * @author Administrator
 *
 */
public interface TOpenTimeService {
	//系统根据不同的时间开放不同的服务，显示不同的页面
	/**
	 * @return
	 */
	public boolean isServiceOut();
	/**
	 * @param dateformat
	 * @return
	 */
	public String getNowTime(String dateformat);
	/**
	 * 比较两个日期大小
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */

	public  int compare_date(String nowDate, String startDate,String endDate);
	/**
	 * @return
	 */
	public  int compare_date();
	/**
	 * @param nowDate
	 * @param startDate
	 * @param endDate
	 * @param dateformat
	 * @return
	 */
	public  int compare_date(String nowDate, String startDate,String endDate,String dateformat);

}
