package cn.jxufe.dao;
import java.util.*;

import cn.jxufe.domain.TUser;

public interface TUserDao {

	/**是否存在userNum
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public boolean checkUserNum(String userNum)throws Exception;
	
	/**通过用户号和密码验证是否存在并返回布尔值
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public boolean checkUserNumAndCode(String userName,String code,TUser tuser)throws Exception;
	
	/**增加一条数据
	 * @param tUser
	 * @return
	 * @throws Exception
	 */
	public boolean addTUser(TUser tUser)throws Exception;
	/**批量增加
	 * @param tUser
	 * @return
	 * @throws Exception
	 */
	public boolean addManyTUser(Collection<TUser> tUser)throws Exception;
	/**
	 * 批量增加，并传出count为插入数据条数
	 * @param tUser
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public boolean addManyTuser(Collection<TUser> tUser,int count)throws Exception;
	
	
	/**
	 * 删除一条数据
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTUserByUserNum(String userNum)throws Exception;
	/**
	 * 批量删除
	 * @param userNums
	 * @return
	 * @throws Exception
	 */
	public boolean deleteManyTUserByUserNums(Collection<String> userNums)throws Exception;
	
	/**
	 * 批量删除，并传出count删除条数
	 * @param userNums
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public boolean deleteManyTUserByUserNums(Collection<String> userNums,int count)throws Exception;
	
	
	/**
	 * 修改密码
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public boolean alterCodeByUserNum(String userNum)throws Exception;
	
	/**
	 * 修改用户名
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public boolean alterUserNameByUserNum(String userNum)throws Exception;
	/**
	 * 修改单位
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public boolean alterUnitIdByUserNum(String userNum)throws Exception;
	
	
	/**
	 * 修改基本信息
	 * @param sex
	 * @param birthday
	 * @param telphone
	 * @param qq
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public boolean alterInfoByUserNum(String sex,Date birthday,String telphone,String qq,String email,String userNum)throws Exception;
	/**
	 * 通过userNum查找数据返回TUser表，仅仅是表数据，未返回全部结构
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public TUser   findAllByUserNum(String userNum) throws Exception;
	/**
	 * 查找所属单位
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public String  findUnitIdByUserNum(String userNum)throws Exception;
	/**
	 * 查找用户名
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public String  findUserNameByUserNum(String userNum)throws Exception;
	/**查找创建角色
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public String  findCreateRoleByUserNum(String userNum)throws Exception;
	/**
	 * 查找创建日期
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public Date    findCreateDateByUserNum(String userNum)throws Exception;

}
