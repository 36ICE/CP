package cn.jxufe.domain;
/***********************************************************************
 * Module:  TUserRole.java
 * Author:  Administrator
 * Purpose: Defines the Class TUserRole
 ***********************************************************************/

import java.util.*;

/** 用户角色表
 * 
 * @pdOid d0ea665c-810b-41aa-8819-6527fa97bdad */
public class TUserRole {
   /** @pdOid b221203f-60d1-432a-a8fb-8123ea43a8b3 */
   public long userRoleId;
   


/** @pdRoleInfo migr=no name=TUser assc=reference28 mult=0..1 side=A */
   public TUser tUser;
   /** @pdRoleInfo migr=no name=TRole assc=reference31 mult=0..1 side=A */
   public TRole tRole;
   
   
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
            oldTUser.removeTUserRole(this);
         }
         if (newTUser != null)
         {
            this.tUser = newTUser;
            this.tUser.addTUserRole(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TRole getTRole() {
      return tRole;
   }
   
   /** @pdGenerated default parent setter
     * @param newTRole */
   public void setTRole(TRole newTRole) {
      if (this.tRole == null || !this.tRole.equals(newTRole))
      {
         if (this.tRole != null)
         {
            TRole oldTRole = this.tRole;
            this.tRole = null;
            oldTRole.removeTUserRole(this);
         }
         if (newTRole != null)
         {
            this.tRole = newTRole;
            this.tRole.addTUserRole(this);
         }
      }
   }

}