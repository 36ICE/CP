package cn.jxufe.domain;
/***********************************************************************
 * Module:  TFilePermi.java
 * Author:  Administrator
 * Purpose: Defines the Class TFilePermi
 ***********************************************************************/

import java.util.*;

/** 文件权限表
 * 
 * @pdOid 1a5847f8-a551-43a5-9f6e-17b7256bddc1 */
public class TFilePermi {
   /** 文件权限id
    * 
    * @pdOid 40e1021a-2aa1-41ac-8b99-a7f7ed452b99 */
   public long permFileId;
   
   public void setPermFileId(long permFileId) {
	this.permFileId = permFileId;
}

/** @pdRoleInfo migr=no name=TPermission assc=reference32 mult=0..1 side=A */
   public TPermission tPermission;
   /** @pdRoleInfo migr=no name=TFile assc=reference37 mult=0..1 side=A */
   public TFile tFile;
   
   
   public long getPermFileId() {
	return permFileId;
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
            oldTPermission.removeTFilePermi(this);
         }
         if (newTPermission != null)
         {
            this.tPermission = newTPermission;
            this.tPermission.addTFilePermi(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TFile getTFile() {
      return tFile;
   }
   
   /** @pdGenerated default parent setter
     * @param newTFile */
   public void setTFile(TFile newTFile) {
      if (this.tFile == null || !this.tFile.equals(newTFile))
      {
         if (this.tFile != null)
         {
            TFile oldTFile = this.tFile;
            this.tFile = null;
            oldTFile.removeTFilePermi(this);
         }
         if (newTFile != null)
         {
            this.tFile = newTFile;
            this.tFile.addTFilePermi(this);
         }
      }
   }

}