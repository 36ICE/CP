package cn.jxufe.dao;

import java.util.Collection;

import cn.jxufe.domain.TDepart;
import cn.jxufe.domain.TSchool;

public interface TDepartDao {

	/**是否存在departNum
	 * @param departNum
	 * @return
	 * @throws Exception
	 */
	
	
	public Boolean checkDepartNumber(String departNum) throws Exception;
	
	
	
	/**
	 * 是否存在departId
	 * @param departId
	 * @return
	 * @throws Exception
	 */
	public Boolean checkDepartId(int departId)throws Exception;
	
	/**
	 * 添加一条
	 * @param tDepart
	 * @return
	 * @throws Exception
	 */
	public boolean addTDepart(TDepart tDepart)throws Exception;
	/**
	 * 批量添加
	 * @param tDeparts
	 * @return
	 * @throws Exception
	 */
	public boolean addManyTDepart(Collection<TDepart> tDepart)throws Exception;
	
	/**
	 * 删除一条
	 * @param DepartNumber
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTDepart(String departNumber)throws Exception;
	/**
	 * 批量删除
	 * @param DepartNumbers
	 * @return
	 * @throws Exception
	 */
	public boolean deleteManyTDepart(Collection<String>departNumbers)throws Exception;
	
	/**
	 * 修改departName
	 * @param DepartName
	 * @return
	 * @throws Exception
	 */
	public boolean alterDepartName(long departId,String departName)throws Exception;
	/**
	 * 修改学院代号
	 * @param departNumber
	 * @return
	 * @throws Exception
	 */
	public boolean alterDepartNumber(long departId,String departNumber)throws Exception;
	/**查找数据
	 * @param sDepartId
	 * @return
	 * @throws Exception
	 */
	public TDepart findAllByDepartId(String DepartId) throws Exception;
	
	
	/**查找数据
	 * @param schoolNumber
	 * @return
	 * @throws Exception
	 */
	public TDepart findAllByDepartNumber(String departNumber)throws Exception;

	/**查找表中数据行数
	 * @return
	 * @throws Exception
	 */
	public int getCount() throws Exception;
	
	
	/**查找所有数据
	 * @return
	 * @throws Exception
	 */
	public Collection<TDepart> findAll()throws Exception;
	

	/**
	 * 查找学院名
	 * @return
	 * @throws Exception
	 */
	public String findDepartNameByDepartNumber()throws Exception;



	int findDepartIdByDepartName(String departName) throws Exception;
}