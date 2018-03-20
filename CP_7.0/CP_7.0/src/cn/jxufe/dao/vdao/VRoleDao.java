package cn.jxufe.dao.vdao;

import cn.jxufe.domain.ventity.VRole;

public interface VRoleDao {

	
	public VRole findByUserNum(String userNum)throws Exception;

	String findRoleNameByUserNum(String userNum) throws Exception;

	String findRoleNameByUserNum2(String userNum) throws Exception;

}
