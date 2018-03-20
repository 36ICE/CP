package cn.jxufe.dao;

import java.util.Collection;

import cn.jxufe.domain.TDepart;
import cn.jxufe.domain.TUnit;

public interface TUnitDao {

	/**是否存在TUnitNum
	 * @param TUnitNum
	 * @return
	 * @throws Exception
	 */
	public boolean checkUnitNumber(String UnitNum) throws Exception;	
	/**
	 * 是否存在TUnitId
	 * @param TUnitId
	 * @return
	 * @throws Exception
	 */
	public boolean checkTUnitId(int UnitId)throws Exception;
	
	/**
	 * 添加一条
	 * @param TUnit
	 * @return
	 * @throws Exception
	 */
	public boolean addTUnit(TUnit tUnit)throws Exception;
	/**
	 * 批量添加
	 * @param tTUnit
	 * @return
	 * @throws Exception
	 */
	public boolean addManyTUnit(Collection<TUnit> tUnit)throws Exception;
	
	/**
	 * 删除一条
	 * @param TUnitNumber
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTUnit(String UnitNumber)throws Exception;
	/**
	 * 批量删除
	 * @param TUnitNumbers
	 * @return
	 * @throws Exception
	 */
	public boolean deleteManyTUnit(Collection<String>tUnitNumbers)throws Exception;
	
	/**
	 * 修改UnitName
	 * @param UnitName
	 * @return
	 * @throws Exception
	 */
	public boolean alterUnitName(long unitId,String unitName)throws Exception;
	/**
	 * 修改单位代号
	 * @param UnitNumber
	 * @return
	 * @throws Exception
	 */
	public boolean alterUnitNumber(long unitId,String tUnitNumber)throws Exception;

	
	
	/**查找数据
	 * @param UnitNumber
	 * @return
	 * @throws Exception
	 */
	public TUnit findAllByUnitNumber(String UnitNumber)throws Exception;

	/**查找表中数据行数
	 * @return
	 * @throws Exception
	 */
	public int getCount() throws Exception;
	
	
	/**查找所有数据
	 * @return
	 * @throws Exception
	 */
	public Collection<TUnit> findAll()throws Exception;
	

	/**
	 * 查找单位名
	 * @return
	 * @throws Exception
	 */
	public String findUnitNameByUnitNumber()throws Exception;
	String findUnitNameByUnitId(int unitId) throws Exception;
	int findUnitIdByUnitName(String unitName) throws Exception;


}