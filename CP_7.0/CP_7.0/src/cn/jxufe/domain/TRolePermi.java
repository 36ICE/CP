package cn.jxufe.domain;
/***********************************************************************
 * Module:  TRolePermi.java
 * Author:  Administrator
 * Purpose: Defines the Class TRolePermi
 ***********************************************************************/

import java.util.*;

/** 角色权限表
 * 
 * @pdOid 327edd0b-d5b4-4327-a1c3-09a165bd4a9b */
public class TRolePermi {
   /** @pdOid f4423177-da44-4afd-9f1d-97a29549a0d5 */
   public long rolePermiId;
   
   /** @pdRoleInfo migr=no name=TPermission assc=reference40 mult=0..1 side=A */
   public TPermission tPermission;
   /** @pdRoleInfo migr=no name=TRole assc=reference41 mult=0..1 side=A */
   public TRole tRole;
   
   
   public long getRolePermiId() {
	return rolePermiId;
}

public void setRolePermiId(long rolePermiId) {
	this.rolePermiId = rolePermiId;
}

/** @pdGenerated default parent getter */
   public TPermission getTPermission() {
      return tPermission;
   }
   
   /** @pdGenerated default parent setter
     * @param newTPermission */
   public void setTPermission(TPermission newTPermission) {
      if (this.tPermission == null || !this.tPermission.equals(newTPermission))
      {
         if (this.tPermission != null)
         {
            TPermission oldTPermission = this.tPermission;
            this.tPermission = null;
            oldTPermission.removeTRolePermi(this);
         }
         if (newTPermission != null)
         {
            this.tPermission = newTPermission;
            this.tPermission.addTRolePermi(this);
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
            oldTRole.removeTRolePermi(this);
         }
         if (newTRole != null)
         {
            this.tRole = newTRole;
            this.tRole.addTRolePermi(this);
         }
      }
   }

}