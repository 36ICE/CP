package cn.jxufe.domain;
/***********************************************************************
 * Module:  TRoleGroup.java
 * Author:  Administrator
 * Purpose: Defines the Class TRoleGroup
 ***********************************************************************/

import java.util.*;

/** 角色组
 * 
 * @pdOid a6a19d04-27ce-468f-867b-d7f5d4b20434 */
public class TRoleGroup {
   /** @pdOid 36b7658c-5f6f-4a50-ae51-81bfd5ba4602 */
   public long roleGroupId;
   
   /** @pdRoleInfo migr=no name=TGroupId assc=reference43 mult=0..1 side=A */
   public TGroup tGroupId;
   /** @pdRoleInfo migr=no name=TRole assc=reference44 mult=0..1 side=A */
   public TRole tRole;
   
   
   public long getRoleGroupId() {
	return roleGroupId;
}

public void setRoleGroupId(long roleGroupId) {
	this.roleGroupId = roleGroupId;
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
            oldTGroupId.removeTRoleGroup(this);
         }
         if (newTGroupId != null)
         {
            this.tGroupId = newTGroupId;
            this.tGroupId.addTRoleGroup(this);
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
            oldTRole.removeTRoleGroup(this);
         }
         if (newTRole != null)
         {
            this.tRole = newTRole;
            this.tRole.addTRoleGroup(this);
         }
      }
   }

}