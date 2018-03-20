package cn.jxufe.domain;
/***********************************************************************
 * Module:  TOperaPermi.java
 * Author:  Administrator
 * Purpose: Defines the Class TOperaPermi
 ***********************************************************************/

import java.util.*;

/** 操作权限
 * 
 * @pdOid 300192be-a5d7-4f88-857e-4d08a89a2b12 */
public class TOperaPermi {
   /** 操作权限id
    * 
    * @pdOid 5c16f894-66c5-4888-9ef3-eeb7d4968c71 */
   public long operaPermiId;
   
   /** @pdRoleInfo migr=no name=TOperate assc=reference38 mult=0..1 side=A */
   public TOperate tOperate;
   /** @pdRoleInfo migr=no name=TPermission assc=reference39 mult=0..1 side=A */
   public TPermission tPermission;
   
   
   /** @pdGenerated default parent getter */
   public TOperate getTOperate() {
      return tOperate;
   }
   
   /** @pdGenerated default parent setter
     * @param newTOperate */
   public void setTOperate(TOperate newTOperate) {
      if (this.tOperate == null || !this.tOperate.equals(newTOperate))
      {
         if (this.tOperate != null)
         {
            TOperate oldTOperate = this.tOperate;
            this.tOperate = null;
            oldTOperate.removeTOperaPermi(this);
         }
         if (newTOperate != null)
         {
            this.tOperate = newTOperate;
            this.tOperate.addTOperaPermi(this);
         }
      }
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
            oldTPermission.removeTOperaPermi(this);
         }
         if (newTPermission != null)
         {
            this.tPermission = newTPermission;
            this.tPermission.addTOperaPermi(this);
         }
      }
   }

}