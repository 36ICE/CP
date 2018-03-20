package cn.jxufe.domain.ventity;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class VInfo {


	private  int eveluaterId;

	public int getEveluaterId() {
		return eveluaterId;
	}

	public void setEveluaterId(int eveluaterId) {
		this.eveluaterId = eveluaterId;
	}

	private int userId;
	/**
	 * 
	 */
	private String userNum;
	/**
	 * 
	 */
	private String userName;

	/**
	 * 
	 */
	private String unitName;
	/**
	 * 
	 */
	private String departName;
	/**
	 * 
	 */
	private String schoolName;
	/**
	 * 
	 */
	private String qq;
	/**
	 * 
	 */
	private String telphone;
	/**
	 * 
	 */

	private String email;
	/**
	 * 
	 */
	private Date birthday;
	
	/**
	 * 
	 */
	private int unitId;

	private String roleName;
	
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
