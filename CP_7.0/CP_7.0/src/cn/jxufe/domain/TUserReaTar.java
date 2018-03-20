package cn.jxufe.domain;
/***********************************************************************
 * Module:  TUserReaTar.java
 * Author:  Administrator
 * Purpose: Defines the Class TUserReaTar
 ***********************************************************************/

import java.util.*;

/** 用户_真实情况表
 * 
 * @pdOid dfa7d44d-b7c1-4b0b-9ffa-898e5e54dded */
public class TUserReaTar {
   /** @pdOid 3b46214e-55a1-4a39-b7e6-46ad3a6b30eb */
   public long userReaTarId;
   
   public long getUserReaTarId() {
	return userReaTarId;
}

public void setUserReaTarId(long userReaTarId) {
	this.userReaTarId = userReaTarId;
}

/** 学期号1，2，3，4，5，6，7，8
    * 
    * @pdOid df6df851-166b-46a7-acdd-3df0b2cfc898 */
   public long termNum;
   
   /** @pdRoleInfo migr=no name=TUser assc=reference24 mult=0..1 side=A */
   public TUser tUser;
   /** @pdRoleInfo migr=no name=TReaTar assc=reference46 mult=0..1 side=A */
   public TReaTar tReaTar;
   
   
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
            oldTUser.removeTUserReaTar(this);
         }
         if (newTUser != null)
         {
            this.tUser = newTUser;
            this.tUser.addTUserReaTar(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TReaTar getTReaTar() {
      return tReaTar;
   }
   
   /** @pdGenerated default parent setter
     * @param newTReaTar */
   public void setTReaTar(TReaTar newTReaTar) {
      if (this.tReaTar == null || !this.tReaTar.equals(newTReaTar))
      {
         if (this.tReaTar != null)
         {
            TReaTar oldTReaTar = this.tReaTar;
            this.tReaTar = null;
            oldTReaTar.removeTUserReaTar(this);
         }
         if (newTReaTar != null)
         {
            this.tReaTar = newTReaTar;
            this.tReaTar.addTUserReaTar(this);
         }
      }
   }

}