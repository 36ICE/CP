package cn.jxufe.domain;
/***********************************************************************
 * Module:  TSelAss.java
 * Author:  Administrator
 * Purpose: Defines the Class TSelAss
 ***********************************************************************/

import java.util.*;

/** 自我评价表
 * 
 * @pdOid 0cfb6d84-ca0f-45fe-a948-0614f14be6af */
public class TSelAss {
   /** @pdOid d9ca2361-d0de-432d-bd00-4c780dc5874d */
   public long selAssId;
   /** 性格
    * 
    * @pdOid 5994dcc3-8462-4112-a834-efe3098b2391 */
   public java.lang.String chater;
   /** 特长
    * 
    * @pdOid 5aee9012-ad51-48a0-8c30-837129dad970 */
   public java.lang.String speciality;
   /** 兴趣
    * 
    * @pdOid d98713e6-3e80-41b9-a642-d0f8f0ec362c */
   public java.lang.String interest;
   /** 情绪状况，能否控制情绪
    * 
    * @pdOid b36a765b-bff7-4df8-ab8a-bb1b3082cd4f */
   public java.lang.String emotionSituation;
   /** 意志力状况
    * 
    * @pdOid 0b850206-1951-46f7-875b-0d13d358a5f8 */
   public java.lang.String willpower;
   /** 外语水平
    * 
    * @pdOid ed2e3c5f-6dd1-4ed6-9f94-600b2cdd5b1a */
   public java.lang.String english;
   /** 计算机水平
    * 
    * @pdOid 6a667351-30cf-43fc-81cd-718fac5a1778 */
   public java.lang.String computer;
   
   public String submit;
   
   /** @pdRoleInfo migr=no name=TUser assc=reference25 mult=0..1 side=A */
   public TUser tUser;
   
   public TSelAss()
   {
	   
   }
   public TSelAss(TUser user,String chater,String speciality,String interest,
		   String emotionSituation,String willpower,String english,String computer,String submit){
	   this.tUser = user;
	   this.chater = chater;
	   this.computer = computer;
	   this.emotionSituation = emotionSituation;
	   this.english = english;
	   this.interest = interest;
	   this.speciality = speciality;
	   this.willpower = willpower;
	   this.submit=submit;
   }
   
   public String getSubmit() {
	return submit;
}
public void setSubmit(String submit) {
	this.submit = submit;
}
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
            oldTUser.removeTSelAss(this);
         }
         if (newTUser != null)
         {
            this.tUser = newTUser;
            this.tUser.addTSelAss(this);
         }
      }
   }
	public long getSelAssId() {
		return selAssId;
	}
	public void setSelAssId(long selAssId) {
		this.selAssId = selAssId;
	}
	public java.lang.String getChater() {
		return chater;
	}
	public void setChater(java.lang.String chater) {
		this.chater = chater;
	}
	public java.lang.String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(java.lang.String speciality) {
		this.speciality = speciality;
	}
	public java.lang.String getInterest() {
		return interest;
	}
	public void setInterest(java.lang.String interest) {
		this.interest = interest;
	}
	public java.lang.String getEmotionSituation() {
		return emotionSituation;
	}
	public void setEmotionSituation(java.lang.String emotionSituation) {
		this.emotionSituation = emotionSituation;
	}
	public java.lang.String getWillpower() {
		return willpower;
	}
	public void setWillpower(java.lang.String willpower) {
		this.willpower = willpower;
	}
	public java.lang.String getEnglish() {
		return english;
	}
	public void setEnglish(java.lang.String english) {
		this.english = english;
	}
	public java.lang.String getComputer() {
		return computer;
	}
	public void setComputer(java.lang.String computer) {
		this.computer = computer;
	}

}