package cn.jxufe.domain.ventity;

public class VRole {

	/**
	 * 号码唯一标识
	 */
	private String userNum;
	/**
	 * 姓名
	 */
	private String userName;
	/**
	 * 角色名
	 */
	private String roleName;
	
	//
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
