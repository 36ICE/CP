package cn.jxufe.domain;
/***********************************************************************
 * Module:  TJobAss.java
 * Author:  Administrator
 * Purpose: Defines the Class TJobAss
 ***********************************************************************/

import java.util.*;

/** 职业评价
 * 
 * @pdOid 3711b3ba-9d33-4514-b1f7-de1e69b7e514 */
public class TJobAss {
   /** @pdOid 4caecee4-d490-42c2-a9f6-d691b950c015 */
   public long jobAssId;
   /** 就业形势
    * 
    * @pdOid b4e2103f-84d1-4972-9459-52b1332c30c0 */
   public java.lang.String employSituation;
   /** 素质要求
    * 
    * @pdOid 188c194a-cb2f-4b1e-9dac-40e466436e9d */
   public java.lang.String qualifications;
   
   /** 知识要求
    * 
    * @pdOid 5501a212-4d0a-4478-8659-16a76a644f6d */
   public java.lang.String knowledge;
   /** 技能要求
    * 
    * @pdOid e08d4dcb-4001-4280-a4fc-18715b44db6c */
   public java.lang.String skills;
   /** 证书要求
    * 
    * @pdOid 9b99a5d3-d181-4fc9-ab22-a230398aa759 */
   public java.lang.String credentials;
   /** 收入状况
    * 
    * @pdOid 128130c1-7c75-4d18-8a13-e422fc09beca */
   public java.lang.String income;
   /** 职业前景
    * 
    * @pdOid 486b9c30-9818-466d-bb63-e12e8abff42e */
   public java.lang.String prospects;
   /** 对学校的建议，比如增加哪些课，教学等等
    * 
    * @pdOid 8948c626-8e83-4f0d-bb61-70598b854239 */
   public java.lang.String suggest;
   
   public String submit;
   

public String getSubmit() {
	return submit;
}
public void setSubmit(String submit) {
	this.submit = submit;
}
public TJobAss()
   {
	   
   }
   public TJobAss(TUser user,String employSituation,String qualifications,String knowledge,String skills,
		   String credentials,String income,String prospects,String suggest,String submit){
	   this.tUser = user;
	   this.credentials = credentials;
	   this.employSituation = employSituation;
	   this.income = income;
	   this.knowledge = knowledge;
	   this.prospects = prospects;
	   this.qualifications = qualifications;
	   this.skills = skills;
	   this.suggest = suggest;
	   this.submit=submit;
   }
public long getJobAssId() {
	return jobAssId;
}

public void setJobAssId(long jobAssId) {
	this.jobAssId = jobAssId;
}

public java.lang.String getEmploySituation() {
	return employSituation;
}

public void setEmploySituation(java.lang.String employSituation) {
	this.employSituation = employSituation;
}

public java.lang.String getQualifications() {
	return qualifications;
}

public void setQualifications(java.lang.String qualifications) {
	this.qualifications = qualifications;
}

public java.lang.String getKnowledge() {
	return knowledge;
}

public void setKnowledge(java.lang.String knowledge) {
	this.knowledge = knowledge;
}

public java.lang.String getSkills() {
	return skills;
}

public void setSkills(java.lang.String skills) {
	this.skills = skills;
}

public java.lang.String getCredentials() {
	return credentials;
}

public void setCredentials(java.lang.String credentials) {
	this.credentials = credentials;
}

public java.lang.String getIncome() {
	return income;
}

public void setIncome(java.lang.String income) {
	this.income = income;
}

public java.lang.String getProspects() {
	return prospects;
}

public void setProspects(java.lang.String prospects) {
	this.prospects = prospects;
}

public java.lang.String getSuggest() {
	return suggest;
}

public void setSuggest(java.lang.String suggest) {
	this.suggest = suggest;
}

/** @pdRoleInfo migr=no name=TUser assc=reference22 mult=0..1 side=A */
   public TUser tUser;
   
   
   /** @pdGenerated default parent getter */
   public TUser getTUser() {
      return tUser;
   }
   
   /** @pdGenerated default parent setter
     * @param newTUser */
   public void setTUser(TUser newTUser) {
      if (this.tUser == null || !this.tUser.equals(newTUser))
      {
         if (this.tUser != null)
         {
            TUser oldTUser = this.tUser;
            this.tUser = null;
            oldTUser.removeTJobAss(this);
         }
         if (newTUser != null)
         {
            this.tUser = newTUser;
            this.tUser.addTJobAss(this);
         }
      }
   }

}