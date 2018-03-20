package cn.jxufe.dao;

import java.util.Collection;

import cn.jxufe.domain.TSchool;



public interface TSchoolDao {

	/**是否存在schoolNumber
	 * @param schoolNumber
	 * @return
	 * @throws Exception
	 */
	
	
	public boolean checkSchoolNumber(String schoolNumber) throws Exception;
	
	
	
	/**
	 * 是否存在schoolId
	 * @param schoolId
	 * @return
	 * @throws Exception
	 */
	public boolean checkSchoolId(int schoolId)throws Exception;
	
	/**
	 * 添加一条
	 * @param tSchool
	 * @return
	 * @throws Exception
	 */
	public boolean addTSchool(TSchool tSchool)throws Exception;
	/**
	 * 批量添加
	 * @param tSchools
	 * @return
	 * @throws Exception
	 */
	public boolean addManyTSchool(Collection<TSchool> tSchools)throws Exception;
	
	/**
	 * 删除一条
	 * @param schoolNumber
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTSchool(String schoolNumber)throws Exception;
	/**
	 * 批量删除
	 * @param schoolNumbers
	 * @return
	 * @throws Exception
	 */
	public boolean deleteManyTSchool(Collection<String>schoolNumbers)throws Exception;
	
	/**
	 * 修改schoolName
	 * @param schoolName
	 * @return
	 * @throws Exception
	 */
	public boolean alterSchoolName(long schoolId,String schoolName)throws Exception;
	/**
	 * 修改学校代号
	 * @param schoolNumber
	 * @return
	 * @throws Exception
	 */
	public boolean alterSchoolNumber(long schoolId,String schoolNumber)throws Exception;
	/**查找数据
	 * @param schoolId
	 * @return
	 * @throws Exception
	 */
	public TSchool findAllBySchoolId(String schoolId) throws Exception;
	
	
	/**查找数据
	 * @param schoolNumber
	 * @return
	 * @throws Exception
	 */
	public TSchool findAllBySchoolNumber(String schoolNumber)throws Exception;

	/**查找表中数据行数
	 * @return
	 * @throws Exception
	 */
	public int getCount() throws Exception;
	
	
	/**查找所有数据
	 * @return
	 * @throws Exception
	 */
	public Collection<TSchool> findAll()throws Exception;
	

	/**
	 * 查找学校名
	 * @return
	 * @throws Exception
	 */
	public String findSchoolNameBySchoolNumber()throws Exception;



	int findSchoolIdBySchoolName(String schoolName) throws Exception;
}
