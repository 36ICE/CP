package cn.jxufe.dao.vdao;

import java.util.Collection;

import cn.jxufe.domain.ventity.VTar;

public interface VTarDao {

	
   /**
    * 
 * @param userId  用户id
 * @param termNum  学期号
 * @return
 * @throws Exception
 */
public VTar	selectTVarByUserIdAndTermNum(int userId,int termNum)throws Exception;

/**
 * @param unitId 单位id
 * @return
 * @throws Exception
 */
public Collection<VTar>	selectTVarByUnitId(int unitId,int termNum)throws Exception;

/**
 * @param departId 部门id
 * @return
 * @throws Exception
 */
public Collection<VTar>	selectTVarByDepartId(int departId)throws Exception;

/** 利用vtest视图
 * @return
 * @throws Exception
 */
public VTar selectTVarEvaluateByUserNumAndTermNum(String userNum,int termNum)throws Exception;
}
