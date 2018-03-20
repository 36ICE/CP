package cn.jxufe.domain;
/***********************************************************************
 * Module:  TPagePermi.java
 * Author:  Administrator
 * Purpose: Defines the Class TPagePermi
 ***********************************************************************/

import java.util.*;

/** 页面权限表
 * 
 * @pdOid 3c936ab5-3b06-4c2b-beda-014992c4b593 */
public class TPagePermi {
   /** 页面权限id
    * 
    * @pdOid 38616713-0767-4714-b206-de181403d903 */
   public long pagePermiid;
   
   /** @pdRoleInfo migr=no name=TPermission assc=reference34 mult=0..1 side=A */
   public TPermission tPermission;
   /** @pdRoleInfo migr=no name=TPage assc=reference36 mult=0..1 side=A */
   public TPage tPage;
   
   
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
            oldTPermission.removeTPagePermi(this);
         }
         if (newTPermission != null)
         {
            this.tPermission = newTPermission;
            this.tPermission.addTPagePermi(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TPage getTPage() {
      return tPage;
   }
   
   /** @pdGenerated default parent setter
     * @param newTPage */
   public void setTPage(TPage newTPage) {
      if (this.tPage == null || !this.tPage.equals(newTPage))
      {
         if (this.tPage != null)
         {
            TPage oldTPage = this.tPage;
            this.tPage = null;
            oldTPage.removeTPagePermi(this);
         }
         if (newTPage != null)
         {
            this.tPage = newTPage;
            this.tPage.addTPagePermi(this);
         }
      }
   }

}