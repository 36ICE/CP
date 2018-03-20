package cn.jxufe.service.permission;

public interface RoleService {

	public boolean isRole(String roleNum,String roleName)throws Exception;

	String getRoleName(String userNum) throws Exception;
}
