package cn.jxufe.service.user;

import cn.jxufe.domain.TUser;

/**
 * @author 曾传东
 *
 */
public interface TUserService {

	
	/**
	 * 登录服务
	 * @param userNum
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public boolean Login(String userNum,String code,TUser tuser)throws Exception;
	
	/**
	 * 暂时不提供注册服务
	 * @return
	 * @throws Exception
	 */
	public boolean register()throws Exception;
	
	/**
	 * 申请注册服务
	 * @return
	 * @throws Exception
	 */
	public boolean requestRegister()throws Exception;
	
	/**
	 * 处理注册申请服务
	 * @return
	 * @throws Exception
	 */
	public boolean handleRegister()throws Exception;
/*	*//**
	 * 提供授权服务
	 * @return
	 * @throws Exception
	 *//*
	public boolean authorize()throws Exception;*/

	int getTermNumByYear(int year);
	
}
