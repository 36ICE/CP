package cn.jxufe.service.evaluation;

import java.util.Collection;

import cn.jxufe.domain.TEvaluater;

public interface TEvaluaterService {

	/**
	 * @param evauserNum
	 * @return
	 * @throws Exception
	 */
	public Collection <TEvaluater> findByEvaUserNum(String evauserNum)throws Exception;

	boolean changeSubmitState(int eveluaterId);
}
