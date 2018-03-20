package cn.jxufe.domain;
/***********************************************************************
 * Module:  TMenuPermi.java
 * Author:  Administrator
 * Purpose: Defines the Class TMenuPermi
 ***********************************************************************/

import java.util.*;

/** 菜单权限
 * 
 * @pdOid 64b16ccd-dfb2-41fd-ae7d-2d3e5c4992a4 */
public class TMenuPermi {
   /** 菜单权限
    * 
    * @pdOid 28987729-0cff-48dc-a8c9-4230bacf122a */
   public long menuPermiId;
   
   /** @pdRoleInfo migr=no name=TPermission assc=reference33 mult=0..1 side=A */
   public TPermission tPermission;
   /** @pdRoleInfo migr=no name=TMenu assc=reference35 mult=0..1 side=A */
   public TMenu tMenu;
   
   
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
            oldTPermission.removeTMenuPermi(this);
         }
         if (newTPermission != null)
         {
            this.tPermission = newTPermission;
            this.tPermission.addTMenuPermi(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TMenu getTMenu() {
      return tMenu;
   }
   
   /** @pdGenerated default parent setter
     * @param newTMenu */
   public void setTMenu(TMenu newTMenu) {
      if (this.tMenu == null || !this.tMenu.equals(newTMenu))
      {
         if (this.tMenu != null)
         {
            TMenu oldTMenu = this.tMenu;
            this.tMenu = null;
            oldTMenu.removeTMenuPermi(this);
         }
         if (newTMenu != null)
         {
            this.tMenu = newTMenu;
            this.tMenu.addTMenuPermi(this);
         }
      }
   }

}