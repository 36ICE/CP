package cn.jxufe.dao;

import java.util.ArrayList;
import java.util.Collection;

import cn.jxufe.domain.TExcTar;

public interface TExcTarDao {

	/**
	 * 判断是否存在这个预期目标id
	 * @return 
	 * @throws Exception
	 */
	public boolean cheackExcTarId(int excTarId)throws Exception;
	
	/**
	 * 添加一条预期目标记录
	 * @return
	 * @throws Exception
	 */
	public boolean addTExcTar( TExcTar excTar)throws Exception;

	/**
	 * 
	 *批量添加预期目标
	 * @param exctars
	 * @return
	 * @throws Exception
	 */
	public boolean addManyTExcTar(Collection<TExcTar> exctars)throws Exception;

	
	public boolean addExcTarByNameAndValue(int excTarId,String name,String value)throws Exception;
	/**
	 * 根据中间表找到的id即excTarId删除一条数据
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTExcTarByExcTarId(long excTarId)throws Exception;
	
	/**
	 * 根据excTarId批量删除
	 * @param excTarId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteManyTExceTarByExcTarId(Collection<Integer> excTarId)throws Exception;
	
	
	/**
	 * 修改预期目标
	 * @param excTarId
	 * @return
	 * @throws Exception
	 */
	public boolean alterTExcTarByExcTarId(TExcTar excTar)throws Exception;
	
	/**
	 * 查找TExcTar通过一个excTarId
	 * @param excTarId
	 * @return
	 * @throws Exception
	 */
	public TExcTar findTExcTarByExcTarId(long excTarId)throws Exception;
	
	
	/**
	 * 查找TExcTar通过 多个excTarId
	 * @param excTarIds 数组
	 * @return
	 * @throws Exception
	 */
	public  Collection<TExcTar> findManyTExcTarByExcTarId(ArrayList<Integer> excTarIds)throws Exception;
	
	
	/**
	 * 
	 * 查找TExcTar通过 多个excTarId
	 * @param exctarIds  集合
	 * @return
	 * @throws exception
	 */
	public Collection<TExcTar> findmanyTExcTarByExcTarId(Collection <Integer> excTarIds)throws Exception;

	
	
	
	public boolean updateByExcTarId(int excTarId,String name,String value)throws Exception;

	int getTExctarKey();
	
	
}