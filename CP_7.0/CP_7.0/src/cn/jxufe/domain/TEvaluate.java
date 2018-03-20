package cn.jxufe.domain;
/***********************************************************************
 * Module:  TEvaluate.java
 * Author:  Administrator
 * Purpose: Defines the Class TEvaluate
 ***********************************************************************/

import java.util.*;

/** 评价分数
 * 
 * @pdOid 7807d168-b661-4dc0-b317-1346e2950f25 */
public class TEvaluate {
	
	
    public 	String submit ;
   /** @pdOid 20ac8b48-8d15-405b-95e2-7cce1ab75a84 */
   public long evaluateId;
   /** 专业学习
    * 
    * @pdOid 1f2e3d9c-6395-408d-9808-3bf3b1c2ce5c */
   public long gProLea;
   /** 非专业学习
    * 
    * @pdOid 26b04746-589d-4a8b-8d84-924726246f3e */
   public long gNonProLea;
   /** 课外学习
    * 
    * @pdOid 0adee881-72a8-4d0b-9b07-6bc3f799d69b */
   public long gExtraLearn;
   /** 身体健康
    * 
    * @pdOid 82741941-3242-47f7-9d5f-9ec85c01bc3e */
   public long gPhyHealth;
   /** 心理健康
    * 
    * @pdOid fd4d2449-11dc-4b59-9d8c-27a0188ffcf3 */
   public long gMentalHealth;
   /** 理财
    * 
    * @pdOid 553bfe26-2ccb-4a05-83e8-cb4363cea977 */
   public long gManageMoney;
   /** 人际沟通
    * 
    * @pdOid 72a541e1-a276-4260-aeeb-dd5fb983557b */
   public long gInterpersonal;
   /** 社团部门
    * 
    * @pdOid 5ca705c8-a880-4566-8409-0bdfae33ac9f */
   public long gClubEvent;
   /** 社会
    * 
    * @pdOid 182392b2-e651-4e35-8baa-be78f97a0111 */
   public long gSocialEvent;
   /** 评价人id
    * 
    * @pdOid 91a74bbb-4415-4ac6-bfb4-acb05a4b6075 */
   public long eveluaterId;
   
   public String getSubmit() {
	return submit;
}

public void setSubmit(String submit) {
	this.submit = submit;
}

public long getEvaluateId() {
	return evaluateId;
}

public void setEvaluateId(long evaluateId) {
	this.evaluateId = evaluateId;
}

public long getgProLea() {
	return gProLea;
}

public void setgProLea(long gProLea) {
	this.gProLea = gProLea;
}

public long getgNonProLea() {
	return gNonProLea;
}

public void setgNonProLea(long gNonProLea) {
	this.gNonProLea = gNonProLea;
}

public long getgExtraLearn() {
	return gExtraLearn;
}

public void setgExtraLearn(long gExtraLearn) {
	this.gExtraLearn = gExtraLearn;
}

public long getgPhyHealth() {
	return gPhyHealth;
}

public void setgPhyHealth(long gPhyHealth) {
	this.gPhyHealth = gPhyHealth;
}

public long getgMentalHealth() {
	return gMentalHealth;
}

public void setgMentalHealth(long gMentalHealth) {
	this.gMentalHealth = gMentalHealth;
}

public long getgManageMoney() {
	return gManageMoney;
}

public void setgManageMoney(long gManageMoney) {
	this.gManageMoney = gManageMoney;
}

public long getgInterpersonal() {
	return gInterpersonal;
}

public void setgInterpersonal(long gInterpersonal) {
	this.gInterpersonal = gInterpersonal;
}

public long getgClubEvent() {
	return gClubEvent;
}

public void setgClubEvent(long gClubEvent) {
	this.gClubEvent = gClubEvent;
}

public long getgSocialEvent() {
	return gSocialEvent;
}

public void setgSocialEvent(long gSocialEvent) {
	this.gSocialEvent = gSocialEvent;
}

public long getEveluaterId() {
	return eveluaterId;
}

public void setEveluaterId(long eveluaterId) {
	this.eveluaterId = eveluaterId;
}

public java.util.Collection<TUserEva> gettUserEva() {
	return tUserEva;
}

public void settUserEva(java.util.Collection<TUserEva> tUserEva) {
	this.tUserEva = tUserEva;
}

/** @pdRoleInfo migr=no name=TUserEva assc=reference47 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TUserEva> tUserEva;
   
   
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
   
   /** @pdGenerated default setter
     * @param newTUserEva */
   public void setTUserEva(java.util.Collection<TUserEva> newTUserEva) {
      removeAllTUserEva();
      for (java.util.Iterator iter = newTUserEva.iterator(); iter.hasNext();)
         addTUserEva((TUserEva)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTUserEva */
   public void addTUserEva(TUserEva newTUserEva) {
      if (newTUserEva == null)
         return;
      if (this.tUserEva == null)
         this.tUserEva = new java.util.HashSet<TUserEva>();
      if (!this.tUserEva.contains(newTUserEva))
      {
         this.tUserEva.add(newTUserEva);
         newTUserEva.setTEvaluate(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTUserEva */
   public void removeTUserEva(TUserEva oldTUserEva) {
      if (oldTUserEva == null)
         return;
      if (this.tUserEva != null)
         if (this.tUserEva.contains(oldTUserEva))
         {
            this.tUserEva.remove(oldTUserEva);
            oldTUserEva.setTEvaluate((TEvaluate)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTUserEva() {
      if (tUserEva != null)
      {
         TUserEva oldTUserEva;
         for (java.util.Iterator iter = getIteratorTUserEva(); iter.hasNext();)
         {
            oldTUserEva = (TUserEva)iter.next();
            iter.remove();
            oldTUserEva.setTEvaluate((TEvaluate)null);
         }
      }
   }

}