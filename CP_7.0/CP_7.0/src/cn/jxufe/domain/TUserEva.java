package cn.jxufe.domain;
/***********************************************************************
 * Module:  TUserEva.java
 * Author:  Administrator
 * Purpose: Defines the Class TUserEva
 ***********************************************************************/

import java.util.*;

/** 用户_评价分数表
 * 
 * @pdOid aa8f019b-51e4-45eb-99c7-83689167782b */
public class TUserEva {
   /** @pdOid 78d60291-9be2-460d-943d-0be52a724b89 */
   public long userEvaId;
   /** 学期号1，2，3，4，5，6，7，8
    * 
    * @pdOid 2598d378-7a38-4faa-bbb5-383aee0d0acc */
   public long termNum;
   
   public long getUserEvaId() {
	return userEvaId;
}

public void setUserEvaId(long userEvaId) {
	this.userEvaId = userEvaId;
}

/** @pdRoleInfo migr=no name=TUser assc=reference26 mult=0..1 side=A */
   public TUser tUser;
   /** @pdRoleInfo migr=no name=TEvaluate assc=reference47 mult=0..1 side=A */
   public TEvaluate tEvaluate;
   
   
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
            oldTUser.removeTUserEva(this);
         }
         if (newTUser != null)
         {
            this.tUser = newTUser;
            this.tUser.addTUserEva(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TEvaluate getTEvaluate() {
      return tEvaluate;
   }
   
   /** @pdGenerated default parent setter
     * @param newTEvaluate */
   public void setTEvaluate(TEvaluate newTEvaluate) {
      if (this.tEvaluate == null || !this.tEvaluate.equals(newTEvaluate))
      {
         if (this.tEvaluate != null)
         {
            TEvaluate oldTEvaluate = this.tEvaluate;
            this.tEvaluate = null;
            oldTEvaluate.removeTUserEva(this);
         }
         if (newTEvaluate != null)
         {
            this.tEvaluate = newTEvaluate;
            this.tEvaluate.addTUserEva(this);
         }
      }
   }

}