package cn.jxufe.domain;
/***********************************************************************
 * Module:  TReaTar.java
 * Author:  Administrator
 * Purpose: Defines the Class TReaTar
 ***********************************************************************/

import java.util.*;

/** 实际情况
 * 
 * @pdOid 697d6f7e-a111-440e-864c-f2a1695f55c5 */
public class TReaTar {
	public TReaTar(){
		
	}
	public TReaTar(java.lang.String rProLea,java.lang.String rNonProLea,java.lang.String rExtraLearn,
			java.lang.String rPhyHealth,java.lang.String rMentalHealth,java.lang.String rManageMoney,
			java.lang.String rInterpersonal,java.lang.String rClubEvent,java.lang.String rSocialEvent,String submit){
		this.rProLea=rProLea;
		this.rNonProLea=rNonProLea;
		this.rExtraLearn=rExtraLearn;
		this.rPhyHealth=rPhyHealth;
		this.rMentalHealth=rMentalHealth;
		this.rManageMoney=rManageMoney;
		this.rInterpersonal=rInterpersonal;
		this.rClubEvent=rClubEvent;
		this.rSocialEvent=rSocialEvent;
		this.submit=submit;
	}
	
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String submit;
   /** @pdOid 4d5cb959-26a9-405f-90d0-305581d3433a */
   public long reaTarId;
   /** 专业学习
    * 
    * @pdOid 3e33cc4f-a2c5-42d0-b9ec-b28ee949a867 */
   public java.lang.String rProLea;
   /** 非专业学习
    * 
    * @pdOid 390e1fcd-1ca9-4201-bdd0-c42bcda719b7 */
   public java.lang.String rNonProLea;
   /** 课外学习
    * 
    * @pdOid 9f9a4a79-8b35-4588-9a41-20b62dfa5407 */
   public java.lang.String rExtraLearn;
   /** 身体健康
    * 
    * @pdOid c206da8c-234d-40a8-87c6-fb8c3fa5f9aa */
   public java.lang.String rPhyHealth;
   /** 心理健康
    * 
    * @pdOid bf7b10be-38a7-4a85-9d05-6c7e05e7d708 */
   public java.lang.String rMentalHealth;
   /** 理财
    * 
    * @pdOid be256f13-6806-400d-a759-bc774b2968a1 */
   public java.lang.String rManageMoney;
   /** 人际沟通
    * 
    * @pdOid b4b0da83-b338-4130-a443-6c42af01d9b9 */
   public java.lang.String rInterpersonal;
   /** 社团部门
    * 
    * @pdOid ae041793-93ec-4c95-9870-268c036e5d9a */
   public java.lang.String rClubEvent;
   /** 社会
    * 
    * @pdOid ebe13702-c688-4235-8d01-91925d7f3ef1 */
   public java.lang.String rSocialEvent;
   
   public long getReaTarId() {
	return reaTarId;
}

public void setReaTarId(long reaTarId) {
	this.reaTarId = reaTarId;
}

public java.lang.String getrProLea() {
	return rProLea;
}

public void setrProLea(java.lang.String rProLea) {
	this.rProLea = rProLea;
}

public java.lang.String getrNonProLea() {
	return rNonProLea;
}

public void setrNonProLea(java.lang.String rNonProLea) {
	this.rNonProLea = rNonProLea;
}

public java.lang.String getrExtraLearn() {
	return rExtraLearn;
}

public void setrExtraLearn(java.lang.String rExtraLearn) {
	this.rExtraLearn = rExtraLearn;
}

public java.lang.String getrPhyHealth() {
	return rPhyHealth;
}

public void setrPhyHealth(java.lang.String rPhyHealth) {
	this.rPhyHealth = rPhyHealth;
}

public java.lang.String getrMentalHealth() {
	return rMentalHealth;
}

public void setrMentalHealth(java.lang.String rMentalHealth) {
	this.rMentalHealth = rMentalHealth;
}

public java.lang.String getrManageMoney() {
	return rManageMoney;
}

public void setrManageMoney(java.lang.String rManageMoney) {
	this.rManageMoney = rManageMoney;
}

public java.lang.String getrInterpersonal() {
	return rInterpersonal;
}

public void setrInterpersonal(java.lang.String rInterpersonal) {
	this.rInterpersonal = rInterpersonal;
}

public java.lang.String getrClubEvent() {
	return rClubEvent;
}

public void setrClubEvent(java.lang.String rClubEvent) {
	this.rClubEvent = rClubEvent;
}

public java.lang.String getrSocialEvent() {
	return rSocialEvent;
}

public void setrSocialEvent(java.lang.String rSocialEvent) {
	this.rSocialEvent = rSocialEvent;
}

/** @pdRoleInfo migr=no name=TUserReaTar assc=reference46 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TUserReaTar> tUserReaTar;
   
   
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
   
   /** @pdGenerated default setter
     * @param newTUserReaTar */
   public void setTUserReaTar(java.util.Collection<TUserReaTar> newTUserReaTar) {
      removeAllTUserReaTar();
      for (java.util.Iterator iter = newTUserReaTar.iterator(); iter.hasNext();)
         addTUserReaTar((TUserReaTar)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTUserReaTar */
   public void addTUserReaTar(TUserReaTar newTUserReaTar) {
      if (newTUserReaTar == null)
         return;
      if (this.tUserReaTar == null)
         this.tUserReaTar = new java.util.HashSet<TUserReaTar>();
      if (!this.tUserReaTar.contains(newTUserReaTar))
      {
         this.tUserReaTar.add(newTUserReaTar);
         newTUserReaTar.setTReaTar(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTUserReaTar */
   public void removeTUserReaTar(TUserReaTar oldTUserReaTar) {
      if (oldTUserReaTar == null)
         return;
      if (this.tUserReaTar != null)
         if (this.tUserReaTar.contains(oldTUserReaTar))
         {
            this.tUserReaTar.remove(oldTUserReaTar);
            oldTUserReaTar.setTReaTar((TReaTar)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTUserReaTar() {
      if (tUserReaTar != null)
      {
         TUserReaTar oldTUserReaTar;
         for (java.util.Iterator iter = getIteratorTUserReaTar(); iter.hasNext();)
         {
            oldTUserReaTar = (TUserReaTar)iter.next();
            iter.remove();
            oldTUserReaTar.setTReaTar((TReaTar)null);
         }
      }
   }

}