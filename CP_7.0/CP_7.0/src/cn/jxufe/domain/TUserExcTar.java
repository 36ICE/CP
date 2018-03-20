package cn.jxufe.domain;
/***********************************************************************
 * Module:  TUserExcTar.java
 * Author:  Administrator
 * Purpose: Defines the Class TUserExcTar
 ***********************************************************************/

import java.util.*;

/** 用户预期目标
 * 
 * @pdOid 5968ad56-cfdb-4197-a2a3-1edf6e889ca4 */
public class TUserExcTar {
   /** @pdOid 3270c302-57d5-4c3e-8169-4985873adb1f */
   public long userExcTarId;
   
   public long getUserExcTarId() {
	return userExcTarId;
}

public void setUserExcTarId(long userExcTarId) {
	this.userExcTarId = userExcTarId;
}

/** 学期号1，2，3，4，5，6，7，8
    * 
    * @pdOid 770da5e9-b06b-4757-9b68-5a88e1e6fa0a */
   public long termNum;
   
   /** @pdRoleInfo migr=no name=TUser assc=reference23 mult=0..1 side=A */
   public TUser tUser;
   /** @pdRoleInfo migr=no name=TExcTar assc=reference45 mult=0..1 side=A */
   public TExcTar tExcTar;
   
   
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
            oldTUser.removeTUserExcTar(this);
         }
         if (newTUser != null)
         {
            this.tUser = newTUser;
            this.tUser.addTUserExcTar(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TExcTar getTExcTar() {
      return tExcTar;
   }
   
   /** @pdGenerated default parent setter
     * @param newTExcTar */
   public void setTExcTar(TExcTar newTExcTar) {
      if (this.tExcTar == null || !this.tExcTar.equals(newTExcTar))
      {
         if (this.tExcTar != null)
         {
            TExcTar oldTExcTar = this.tExcTar;
            this.tExcTar = null;
            oldTExcTar.removeTUserExcTar(this);
         }
         if (newTExcTar != null)
         {
            this.tExcTar = newTExcTar;
            this.tExcTar.addTUserExcTar(this);
         }
      }
   }

}