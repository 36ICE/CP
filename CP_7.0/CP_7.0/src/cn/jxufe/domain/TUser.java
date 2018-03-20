package cn.jxufe.domain;

/***********************************************************************
 * Module:  TUser.java
 * Author:  Administrator
 * Purpose: Defines the Class TUser
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

/**
 * 用户表
 * 
 * @pdOid 0be4e166-1e6d-4e9e-91c2-6899655ef622
 */
public class TUser implements Serializable {
	/**
	 * 用户主键
	 * 
	 * @pdOid 56e60671-ec9c-4a38-a8c3-43fdad95cdef
	 */
	public long userId;
	/**
	 * 用户号
	 * 
	 * @pdOid ee1f5d76-d179-4258-b1cd-d8a9c6effaaf
	 */
	public java.lang.String userNum;
	/**
	 * 姓名
	 * 
	 * @pdOid dfed481e-0c5c-4161-9e07-3a8cbb608c02
	 */
	public java.lang.String userName;
	/**
	 * 密码
	 * 
	 * @pdOid 72bd6252-8902-4bbf-b21d-4b896d7ae3df
	 */
	public java.lang.String code;
	
	public int year;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * 性别
	 */
	public java.lang.String sex;

	/**
	 * 生日
	 */
	public java.util.Date birthday;

	/**
	 * 手机号码
	 */
	public java.lang.String telphone;

	/**
	 * qq号
	 */
	public java.lang.String qq;

	/**
	 * 邮箱
	 */
	public java.lang.String email;
	/**
	 * 创建角色，与角色表关联，联级操作
	 * 
	 * @pdOid 436b9c38-0a9e-408b-81d0-b98cedd639da
	 */
	public java.lang.String createrole;
	/**
	 * 创建日期
	 * 
	 * @pdOid f898143c-0f82-43c4-85c3-644b342d0fd3
	 */
	public java.util.Date createDate;

	public java.lang.String getSex() {
		return sex;
	}

	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public java.lang.String getTelphone() {
		return telphone;
	}

	public void setTelphone(java.lang.String telphone) {
		this.telphone = telphone;
	}

	public java.lang.String getQq() {
		return qq;
	}

	public void setQq(java.lang.String qq) {
		this.qq = qq;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public java.lang.String getUserNum() {
		return userNum;
	}

	public void setUserNum(java.lang.String userNum) {
		this.userNum = userNum;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.String getCode() {
		return code;
	}

	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.lang.String getCreaterole() {
		return createrole;
	}

	public void setCreaterole(java.lang.String createrole) {
		this.createrole = createrole;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public String toString() {
		return "userId:" + getUserId() + " username:" + getUserName()
				+ " userNum:" + getUserNum() + " code:" + getCode()
				+ " createDate:" + getCreateDate() + " createRole:"
				+ getCreaterole() + " ";
	}

	/**
	 * @pdRoleInfo migr=no name=TUserGroup assc=reference21
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	public java.util.Collection<TUserGroup> tUserGroup;
	/**
	 * @pdRoleInfo migr=no name=TSelAss assc=reference25
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	public java.util.Collection<TSelAss> tSelAss;
	/**
	 * @pdRoleInfo migr=no name=TUserRole assc=reference28
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	public java.util.Collection<TUserRole> tUserRole;
	/**
	 * @pdRoleInfo migr=no name=TJobAss assc=reference22
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	public java.util.Collection<TJobAss> tJobAss;
	/**
	 * @pdRoleInfo migr=no name=TUserExcTar assc=reference23
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	public java.util.Collection<TUserExcTar> tUserExcTar;
	/**
	 * @pdRoleInfo migr=no name=TUserReaTar assc=reference24
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	public java.util.Collection<TUserReaTar> tUserReaTar;
	/**
	 * @pdRoleInfo migr=no name=TUserEva assc=reference26
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	public java.util.Collection<TUserEva> tUserEva;
	/**
	 * @pdRoleInfo migr=no name=TEvaluater assc=reference48
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	public java.util.Collection<TEvaluater> tEvaluater;
	/** @pdRoleInfo migr=no name=TUnit assc=reference27 mult=0..1 side=A */
	public TUnit tUnit;

	/** @pdGenerated default getter */
	public java.util.Collection<TUserGroup> getTUserGroup() {
		if (tUserGroup == null)
			tUserGroup = new java.util.HashSet<TUserGroup>();
		return tUserGroup;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTUserGroup() {
		if (tUserGroup == null)
			tUserGroup = new java.util.HashSet<TUserGroup>();
		return tUserGroup.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTUserGroup
	 */
	public void setTUserGroup(java.util.Collection<TUserGroup> newTUserGroup) {
		removeAllTUserGroup();
		for (java.util.Iterator iter = newTUserGroup.iterator(); iter.hasNext();)
			addTUserGroup((TUserGroup) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTUserGroup
	 */
	public void addTUserGroup(TUserGroup newTUserGroup) {
		if (newTUserGroup == null)
			return;
		if (this.tUserGroup == null)
			this.tUserGroup = new java.util.HashSet<TUserGroup>();
		if (!this.tUserGroup.contains(newTUserGroup)) {
			this.tUserGroup.add(newTUserGroup);
			newTUserGroup.setTUser(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTUserGroup
	 */
	public void removeTUserGroup(TUserGroup oldTUserGroup) {
		if (oldTUserGroup == null)
			return;
		if (this.tUserGroup != null)
			if (this.tUserGroup.contains(oldTUserGroup)) {
				this.tUserGroup.remove(oldTUserGroup);
				oldTUserGroup.setTUser((TUser) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllTUserGroup() {
		if (tUserGroup != null) {
			TUserGroup oldTUserGroup;
			for (java.util.Iterator iter = getIteratorTUserGroup(); iter
					.hasNext();) {
				oldTUserGroup = (TUserGroup) iter.next();
				iter.remove();
				oldTUserGroup.setTUser((TUser) null);
			}
		}
	}

	/** @pdGenerated default getter */
	public java.util.Collection<TSelAss> getTSelAss() {
		if (tSelAss == null)
			tSelAss = new java.util.HashSet<TSelAss>();
		return tSelAss;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTSelAss() {
		if (tSelAss == null)
			tSelAss = new java.util.HashSet<TSelAss>();
		return tSelAss.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTSelAss
	 */
	public void setTSelAss(java.util.Collection<TSelAss> newTSelAss) {
		removeAllTSelAss();
		for (java.util.Iterator iter = newTSelAss.iterator(); iter.hasNext();)
			addTSelAss((TSelAss) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTSelAss
	 */
	public void addTSelAss(TSelAss newTSelAss) {
		if (newTSelAss == null)
			return;
		if (this.tSelAss == null)
			this.tSelAss = new java.util.HashSet<TSelAss>();
		if (!this.tSelAss.contains(newTSelAss)) {
			this.tSelAss.add(newTSelAss);
			newTSelAss.setTUser(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTSelAss
	 */
	public void removeTSelAss(TSelAss oldTSelAss) {
		if (oldTSelAss == null)
			return;
		if (this.tSelAss != null)
			if (this.tSelAss.contains(oldTSelAss)) {
				this.tSelAss.remove(oldTSelAss);
				oldTSelAss.setTUser((TUser) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllTSelAss() {
		if (tSelAss != null) {
			TSelAss oldTSelAss;
			for (java.util.Iterator iter = getIteratorTSelAss(); iter.hasNext();) {
				oldTSelAss = (TSelAss) iter.next();
				iter.remove();
				oldTSelAss.setTUser((TUser) null);
			}
		}
	}

	/** @pdGenerated default getter */
	public java.util.Collection<TUserRole> getTUserRole() {
		if (tUserRole == null)
			tUserRole = new java.util.HashSet<TUserRole>();
		return tUserRole;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTUserRole() {
		if (tUserRole == null)
			tUserRole = new java.util.HashSet<TUserRole>();
		return tUserRole.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTUserRole
	 */
	public void setTUserRole(java.util.Collection<TUserRole> newTUserRole) {
		removeAllTUserRole();
		for (Iterator<TUserRole> iter = newTUserRole.iterator(); iter.hasNext();)
			addTUserRole((TUserRole) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTUserRole
	 */
	public void addTUserRole(TUserRole newTUserRole) {
		if (newTUserRole == null)
			return;
		if (this.tUserRole == null)
			this.tUserRole = new java.util.HashSet<TUserRole>();
		if (!this.tUserRole.contains(newTUserRole)) {
			this.tUserRole.add(newTUserRole);
			newTUserRole.setTUser(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTUserRole
	 */
	public void removeTUserRole(TUserRole oldTUserRole) {
		if (oldTUserRole == null)
			return;
		if (this.tUserRole != null)
			if (this.tUserRole.contains(oldTUserRole)) {
				this.tUserRole.remove(oldTUserRole);
				oldTUserRole.setTUser((TUser) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllTUserRole() {
		if (tUserRole != null) {
			TUserRole oldTUserRole;
			for (java.util.Iterator iter = getIteratorTUserRole(); iter
					.hasNext();) {
				oldTUserRole = (TUserRole) iter.next();
				iter.remove();
				oldTUserRole.setTUser((TUser) null);
			}
		}
	}

	/** @pdGenerated default getter */
	public java.util.Collection<TJobAss> getTJobAss() {
		if (tJobAss == null)
			tJobAss = new java.util.HashSet<TJobAss>();
		return tJobAss;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTJobAss() {
		if (tJobAss == null)
			tJobAss = new java.util.HashSet<TJobAss>();
		return tJobAss.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTJobAss
	 */
	public void setTJobAss(java.util.Collection<TJobAss> newTJobAss) {
		removeAllTJobAss();
		for (Iterator<TJobAss> iter = newTJobAss.iterator(); iter.hasNext();)
			addTJobAss((TJobAss) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTJobAss
	 */
	public void addTJobAss(TJobAss newTJobAss) {
		if (newTJobAss == null)
			return;
		if (this.tJobAss == null)
			this.tJobAss = new java.util.HashSet<TJobAss>();
		if (!this.tJobAss.contains(newTJobAss)) {
			this.tJobAss.add(newTJobAss);
			newTJobAss.setTUser(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTJobAss
	 */
	public void removeTJobAss(TJobAss oldTJobAss) {
		if (oldTJobAss == null)
			return;
		if (this.tJobAss != null)
			if (this.tJobAss.contains(oldTJobAss)) {
				this.tJobAss.remove(oldTJobAss);
				oldTJobAss.setTUser((TUser) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllTJobAss() {
		if (tJobAss != null) {
			TJobAss oldTJobAss;
			for (java.util.Iterator iter = getIteratorTJobAss(); iter.hasNext();) {
				oldTJobAss = (TJobAss) iter.next();
				iter.remove();
				oldTJobAss.setTUser((TUser) null);
			}
		}
	}

	/** @pdGenerated default getter */
	public java.util.Collection<TUserExcTar> getTUserExcTar() {
		if (tUserExcTar == null)
			tUserExcTar = new java.util.HashSet<TUserExcTar>();
		return tUserExcTar;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTUserExcTar() {
		if (tUserExcTar == null)
			tUserExcTar = new java.util.HashSet<TUserExcTar>();
		return tUserExcTar.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTUserExcTar
	 */
	public void setTUserExcTar(java.util.Collection<TUserExcTar> newTUserExcTar) {
		removeAllTUserExcTar();
		for (java.util.Iterator iter = newTUserExcTar.iterator(); iter
				.hasNext();)
			addTUserExcTar((TUserExcTar) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTUserExcTar
	 */
	public void addTUserExcTar(TUserExcTar newTUserExcTar) {
		if (newTUserExcTar == null)
			return;
		if (this.tUserExcTar == null)
			this.tUserExcTar = new java.util.HashSet<TUserExcTar>();
		if (!this.tUserExcTar.contains(newTUserExcTar)) {
			this.tUserExcTar.add(newTUserExcTar);
			newTUserExcTar.setTUser(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTUserExcTar
	 */
	public void removeTUserExcTar(TUserExcTar oldTUserExcTar) {
		if (oldTUserExcTar == null)
			return;
		if (this.tUserExcTar != null)
			if (this.tUserExcTar.contains(oldTUserExcTar)) {
				this.tUserExcTar.remove(oldTUserExcTar);
				oldTUserExcTar.setTUser((TUser) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllTUserExcTar() {
		if (tUserExcTar != null) {
			TUserExcTar oldTUserExcTar;
			for (java.util.Iterator iter = getIteratorTUserExcTar(); iter
					.hasNext();) {
				oldTUserExcTar = (TUserExcTar) iter.next();
				iter.remove();
				oldTUserExcTar.setTUser((TUser) null);
			}
		}
	}

	/** @pdGenerated default getter */
	public java.util.Collection<TUserReaTar> getTUserReaTar() {
		if (tUserReaTar == null)
			tUserReaTar = new java.util.HashSet<TUserReaTar>();
		return tUserReaTar;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTUserReaTar() {
		if (tUserReaTar == null)
			tUserReaTar = new java.util.HashSet<TUserReaTar>();
		return tUserReaTar.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTUserReaTar
	 */
	public void setTUserReaTar(java.util.Collection<TUserReaTar> newTUserReaTar) {
		removeAllTUserReaTar();
		for (java.util.Iterator iter = newTUserReaTar.iterator(); iter
				.hasNext();)
			addTUserReaTar((TUserReaTar) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTUserReaTar
	 */
	public void addTUserReaTar(TUserReaTar newTUserReaTar) {
		if (newTUserReaTar == null)
			return;
		if (this.tUserReaTar == null)
			this.tUserReaTar = new java.util.HashSet<TUserReaTar>();
		if (!this.tUserReaTar.contains(newTUserReaTar)) {
			this.tUserReaTar.add(newTUserReaTar);
			newTUserReaTar.setTUser(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTUserReaTar
	 */
	public void removeTUserReaTar(TUserReaTar oldTUserReaTar) {
		if (oldTUserReaTar == null)
			return;
		if (this.tUserReaTar != null)
			if (this.tUserReaTar.contains(oldTUserReaTar)) {
				this.tUserReaTar.remove(oldTUserReaTar);
				oldTUserReaTar.setTUser((TUser) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllTUserReaTar() {
		if (tUserReaTar != null) {
			TUserReaTar oldTUserReaTar;
			for (java.util.Iterator iter = getIteratorTUserReaTar(); iter
					.hasNext();) {
				oldTUserReaTar = (TUserReaTar) iter.next();
				iter.remove();
				oldTUserReaTar.setTUser((TUser) null);
			}
		}
	}

	/** @pdGenerated default getter */
	public java.util.Collection<TUserEva> getTUserEva() {
		if (tUserEva == null)
			tUserEva = new java.util.HashSet<TUserEva>();
		return tUserEva;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTUserEva() {
		if (tUserEva == null)
			tUserEva = new java.util.HashSet<TUserEva>();
		return tUserEva.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTUserEva
	 */
	public void setTUserEva(java.util.Collection<TUserEva> newTUserEva) {
		removeAllTUserEva();
		for (java.util.Iterator iter = newTUserEva.iterator(); iter.hasNext();)
			addTUserEva((TUserEva) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTUserEva
	 */
	public void addTUserEva(TUserEva newTUserEva) {
		if (newTUserEva == null)
			return;
		if (this.tUserEva == null)
			this.tUserEva = new java.util.HashSet<TUserEva>();
		if (!this.tUserEva.contains(newTUserEva)) {
			this.tUserEva.add(newTUserEva);
			newTUserEva.setTUser(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTUserEva
	 */
	public void removeTUserEva(TUserEva oldTUserEva) {
		if (oldTUserEva == null)
			return;
		if (this.tUserEva != null)
			if (this.tUserEva.contains(oldTUserEva)) {
				this.tUserEva.remove(oldTUserEva);
				oldTUserEva.setTUser((TUser) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllTUserEva() {
		if (tUserEva != null) {
			TUserEva oldTUserEva;
			for (java.util.Iterator iter = getIteratorTUserEva(); iter
					.hasNext();) {
				oldTUserEva = (TUserEva) iter.next();
				iter.remove();
				oldTUserEva.setTUser((TUser) null);
			}
		}
	}

	/** @pdGenerated default getter */
	public java.util.Collection<TEvaluater> getTEvaluater() {
		if (tEvaluater == null)
			tEvaluater = new java.util.HashSet<TEvaluater>();
		return tEvaluater;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTEvaluater() {
		if (tEvaluater == null)
			tEvaluater = new java.util.HashSet<TEvaluater>();
		return tEvaluater.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTEvaluater
	 */
	public void setTEvaluater(java.util.Collection<TEvaluater> newTEvaluater) {
		removeAllTEvaluater();
		for (Iterator<TEvaluater> iter = newTEvaluater.iterator(); iter
				.hasNext();)
			addTEvaluater((TEvaluater) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTEvaluater
	 */
	public void addTEvaluater(TEvaluater newTEvaluater) {
		if (newTEvaluater == null)
			return;
		if (this.tEvaluater == null)
			this.tEvaluater = new java.util.HashSet<TEvaluater>();
		if (!this.tEvaluater.contains(newTEvaluater)) {
			this.tEvaluater.add(newTEvaluater);
			newTEvaluater.setTUser(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTEvaluater
	 */
	public void removeTEvaluater(TEvaluater oldTEvaluater) {
		if (oldTEvaluater == null)
			return;
		if (this.tEvaluater != null)
			if (this.tEvaluater.contains(oldTEvaluater)) {
				this.tEvaluater.remove(oldTEvaluater);
				oldTEvaluater.setTUser((TUser) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllTEvaluater() {
		if (tEvaluater != null) {
			TEvaluater oldTEvaluater;
			for (java.util.Iterator iter = getIteratorTEvaluater(); iter
					.hasNext();) {
				oldTEvaluater = (TEvaluater) iter.next();
				iter.remove();
				oldTEvaluater.setTUser((TUser) null);
			}
		}
	}

	/** @pdGenerated default parent getter */
	public TUnit getTUnit() {
		return tUnit;
	}

	/**
	 * @pdGenerated default parent setter
	 * @param newTUnit
	 */
	public void setTUnit(TUnit newTUnit) {
		if (this.tUnit == null || !this.tUnit.equals(newTUnit)) {
			if (this.tUnit != null) {
				TUnit oldTUnit = this.tUnit;
				this.tUnit = null;
				oldTUnit.removeTUser(this);
			}
			if (newTUnit != null) {
				this.tUnit = newTUnit;
				this.tUnit.addTUser(this);
			}
		}
	}

}