package cn.jxufe.service.evaluation;

import java.util.Collection;

import cn.jxufe.domain.ventity.VTar;

public interface VTarService {

	/**
	 * @param userNum
	 * @param termNum
	 * @return
	 * @throws Exception
	 */
	public VTar findVTar(String userNum,int termNum)throws Exception;
	
	/**
	 * @param unitId
	 * @return
	 * @throws Exception
	 */
	public Collection<VTar> findVtarsByUnitName(String unitName,int termNum)throws Exception;
	
	/**
	 * @param departId 部门id
	 * @return
	 * @throws Exception
	 */
	public Collection<VTar> findVTarsByDepartName(String departName)throws Exception;
	
	/**
	 * @param userNum
	 * @param termNum
	 * @return
	 * @throws Exception
	 */
	public VTar findVTarEvaluateByUserNumAndTermNum(String userNum,int termNum)throws Exception;
}
