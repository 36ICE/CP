package cn.jxufe.domain;
/***********************************************************************
 * Module:  TUserGroup.java
 * Author:  Administrator
 * Purpose: Defines the Class TUserGroup
 ***********************************************************************/

import java.util.*;

/** 用户_组
 * 
 * @pdOid 0f46c592-7e74-4ddd-93b2-7518ac875ed0 */
public class TUserGroup {
   /** @pdOid 58360b4d-51fa-4b31-a3fa-4ac733110d4b */
   public long id;
   
   public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

/** @pdRoleInfo migr=no name=TUser assc=reference21 mult=0..1 side=A */
   public TUser tUser;
   /** @pdRoleInfo migr=no name=TGroupId assc=reference42 mult=0..1 side=A */
   public TGroup tGroupId;
   
   
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
            oldTUser.removeTUserGroup(this);
         }
         if (newTUser != null)
         {
            this.tUser = newTUser;
            this.tUser.addTUserGroup(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TGroup getTGroupId() {
      return tGroupId;
   }
   
   /** @pdGenerated default parent setter
     * @param newTGroupId */
   public void setTGroupId(TGroup newTGroupId) {
      if (this.tGroupId == null || !this.tGroupId.equals(newTGroupId))
      {
         if (this.tGroupId != null)
         {
            TGroup oldTGroupId = this.tGroupId;
            this.tGroupId = null;
            oldTGroupId.removeTUserGroup(this);
         }
         if (newTGroupId != null)
         {
            this.tGroupId = newTGroupId;
            this.tGroupId.addTUserGroup(this);
         }
      }
   }

}