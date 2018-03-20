package cn.jxufe.dao;

import java.util.ArrayList;
import java.util.Collection;

import cn.jxufe.domain.TReaTar;

public interface TReaTarDao {

	
	/**
	 * 判断是否存在这个预期目标id
	 * @return 
	 * @throws Exception
	 */
	public boolean cheackReaTarId(int reaTarId)throws Exception;
	
	/**
	 * 添加一条预期目标记录
	 * @return
	 * @throws Exception
	 */
	public boolean addTReaTar( TReaTar reaTar)throws Exception;

	/**
	 * 
	 *批量添加预期目标
	 * @param reaTars
	 * @return
	 * @throws Exception
	 */
	public boolean addManyTReaTar(Collection<TReaTar> reaTars)throws Exception;

	/**
	 * 根据中间表找到的id即reaTarId删除一条数据
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTReaTarByReaTarId(int reaTarId)throws Exception;
	
	/**
	 * 根据reaTarId批量删除
	 * @param reaTarId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteManyTReaTarByReaTarId(Collection<Integer> reaTarId)throws Exception;
	
	
	/**
	 * 修改预期目标
	 * @param reaTarId
	 * @return
	 * @throws Exception
	 */
	boolean alterTReaTarByReaTarId(TReaTar tReaTar) throws Exception;
	
	/**
	 * 查找TReaTar通过一个reaTarId
	 * @param reaTarId
	 * @return
	 * @throws Exception
	 */
	public TReaTar findTReaTarByReaTarId(long tReaTarId) throws Exception;
	
	/**
	 * 查找TReaTar通过 多个reaTarId
	 * @param reaTarIds 数组
	 * @return
	 * @throws Exception
	 */
	public  Collection<TReaTar> findManyTReaTarByReaTarId(ArrayList<Integer> reaTarIds)throws Exception;
	
	
	/**
	 * 
	 * 查找TReaTar通过 多个reaTarId
	 * @param reatarIds  集合
	 * @return
	 * @throws exception
	 */
	public Collection<TReaTar> findmanyTReaTarByReaTarId(Collection <Integer> reaTarIds)throws Exception;

	boolean updateByReaTarId(int reaTarId, String name, String value)
			throws Exception;

	boolean addReaTarByNameAndValue(int reaTarId, String name, String value)
			throws Exception;

	int getTReatarKey();



	
	
}