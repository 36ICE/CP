package cn.jxufe.dao.vdao;

import java.util.Collection;

import cn.jxufe.domain.ventity.VAvgEva;

/**
 * @author Administrator
 *
 */
public interface VAvgEvaDao {

    /**
     * @return
     * @throws Exception
     */
    public	Collection<VAvgEva> selectByUserIdAndUnitId(int userId, int unitId)throws Exception;
    
    
    /**
     * @param userNum
     * @param termNum
     * @return
     * @throws Exception
     */
    public Collection<VAvgEva> selectByUserNumAndUnitId(String userNum,
			int unitId)throws Exception;


	VAvgEva selectByUserNumAndUnitIdAndTermNum(String userNum, int unitId,
			int termNum) throws Exception;
}
