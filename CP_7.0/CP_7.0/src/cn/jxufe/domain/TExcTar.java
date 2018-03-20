package cn.jxufe.domain;
/***********************************************************************
 * Module:  TExcTar.java
 * Author:  Administrator
 * Purpose: Defines the Class TExcTar
 ***********************************************************************/

import java.util.*;

/** 预期学期规划
 * 
 * @pdOid 37a144f5-97c7-4675-85d6-180ef1c34459 */
public class TExcTar {	
	public TExcTar(Long excTarId,java.lang.String eProLea,java.lang.String eNonProLea,
				java.lang.String eExtraLearn,java.lang.String ePhyHealth,java.lang.String eMentalHealth,
				java.lang.String eManageMoney,java.lang.String eInterpersonal,java.lang.String eClubEvent,
				java.lang.String eSocialEvent,String submit){
		this.excTarId=excTarId;
		this.eProLea=eProLea;
		this.eNonProLea=eNonProLea;
		this.eExtraLearn=eExtraLearn;
		this.ePhyHealth=ePhyHealth;
		this.eMentalHealth=eMentalHealth;
		this.eManageMoney=eManageMoney;
		this.eInterpersonal=eInterpersonal;
		this.eClubEvent=eClubEvent;
		this.eSocialEvent=eSocialEvent;
		this.submit=submit;
	}
   public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
public TExcTar() {
		// TODO Auto-generated constructor stub
	}
   public String submit;
   
/** @pdOid b849b676-8ac5-432b-bdd5-e25761a8b014 */
   public long excTarId;
   /** 专业学习
    * 
    * @pdOid 19067110-8f7e-4945-9393-5182cd14ad1d */
   public java.lang.String eProLea;
   /** 非专业学习
    * 
    * @pdOid 4ffaef02-f69d-4a88-8710-a80f5df333c3 */
   public java.lang.String eNonProLea;
   /** 课外学习
    * 
    * @pdOid c2883e22-09fe-48df-b9a1-3225b1b216f7 */
   public java.lang.String eExtraLearn;
   /** 身体健康
    * 
    * @pdOid e6baa0ab-1819-492a-ac99-acf7698f8d76 */
   public java.lang.String ePhyHealth;
   /** 心理健康
    * 
    * @pdOid 3d271a47-f38b-428b-a61c-a1a44335c49e */
   public java.lang.String eMentalHealth;
   /** 理财
    * 
    * @pdOid 76befc00-97ae-45aa-8620-ba820711d019 */
   public java.lang.String eManageMoney;
   /** 人际沟通
    * 
    * @pdOid 4a26e1f3-e3a1-45de-b0a1-cde4f0083a49 */
   public java.lang.String eInterpersonal;
   /** 社团部门
    * 
    * @pdOid a8fe2b27-4be0-4617-ba2f-43775d6aa35a */
   public java.lang.String eClubEvent;
   /** 社会
    * 
    * @pdOid eac26178-fa7d-4c4c-ac08-e9d890cba6f0 */
   public java.lang.String eSocialEvent;
   
   public long getExcTarId() {
	return excTarId;
}

public void setExcTarId(long excTarId) {
	this.excTarId = excTarId;
}

public java.lang.String geteProLea() {
	return eProLea;
}

public void seteProLea(java.lang.String eProLea) {

	this.eProLea = eProLea;
}

public java.lang.String geteNonProLea() {
	return eNonProLea;
}

public void seteNonProLea(java.lang.String eNonProLea) {
	this.eNonProLea = eNonProLea;
}

public java.lang.String geteExtraLearn() {
	return eExtraLearn;
}

public void seteExtraLearn(java.lang.String eExtraLearn) {
	this.eExtraLearn = eExtraLearn;
}

public java.lang.String getePhyHealth() {
	return ePhyHealth;
}

public void setePhyHealth(java.lang.String ePhyHealth) {
	this.ePhyHealth = ePhyHealth;
}

public java.lang.String geteMentalHealth() {
	return eMentalHealth;
}

public void seteMentalHealth(java.lang.String eMentalHealth) {
	this.eMentalHealth = eMentalHealth;
}

public java.lang.String geteManageMoney() {
	return eManageMoney;
}

public void seteManageMoney(java.lang.String eManageMoney) {
	this.eManageMoney = eManageMoney;
}

public java.lang.String geteInterpersonal() {
	return eInterpersonal;
}

public void seteInterpersonal(java.lang.String eInterpersonal) {
	this.eInterpersonal = eInterpersonal;
}

public java.lang.String geteClubEvent() {
	return eClubEvent;
}

public void seteClubEvent(java.lang.String eClubEvent) {
	this.eClubEvent = eClubEvent;
}

public java.lang.String geteSocialEvent() {
	return eSocialEvent;
}

public void seteSocialEvent(java.lang.String eSocialEvent) {
	this.eSocialEvent = eSocialEvent;
}

public java.util.Collection<TUserExcTar> gettUserExcTar() {
	return tUserExcTar;
}

public void settUserExcTar(java.util.Collection<TUserExcTar> tUserExcTar) {
	this.tUserExcTar = tUserExcTar;
}

/** @pdRoleInfo migr=no name=TUserExcTar assc=reference45 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TUserExcTar> tUserExcTar;
   
   
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
   
   /** @pdGenerated default setter
     * @param newTUserExcTar */
   public void setTUserExcTar(java.util.Collection<TUserExcTar> newTUserExcTar) {
      removeAllTUserExcTar();
      for (java.util.Iterator iter = newTUserExcTar.iterator(); iter.hasNext();)
         addTUserExcTar((TUserExcTar)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTUserExcTar */
   public void addTUserExcTar(TUserExcTar newTUserExcTar) {
      if (newTUserExcTar == null)
         return;
      if (this.tUserExcTar == null)
         this.tUserExcTar = new java.util.HashSet<TUserExcTar>();
      if (!this.tUserExcTar.contains(newTUserExcTar))
      {
         this.tUserExcTar.add(newTUserExcTar);
         newTUserExcTar.setTExcTar(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTUserExcTar */
   public void removeTUserExcTar(TUserExcTar oldTUserExcTar) {
      if (oldTUserExcTar == null)
         return;
      if (this.tUserExcTar != null)
         if (this.tUserExcTar.contains(oldTUserExcTar))
         {
            this.tUserExcTar.remove(oldTUserExcTar);
            oldTUserExcTar.setTExcTar((TExcTar)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTUserExcTar() {
      if (tUserExcTar != null)
      {
         TUserExcTar oldTUserExcTar;
         for (java.util.Iterator iter = getIteratorTUserExcTar(); iter.hasNext();)
         {
            oldTUserExcTar = (TUserExcTar)iter.next();
            iter.remove();
            oldTUserExcTar.setTExcTar((TExcTar)null);
         }
      }
   }

}