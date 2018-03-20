package cn.jxufe.domain;
/***********************************************************************
 * Module:  TFile.java
 * Author:  Administrator
 * Purpose: Defines the Class TFile
 ***********************************************************************/

import java.util.*;

/** 文件表
 * 
 * @pdOid 6640e674-33fc-40d1-83c3-4b7ef2b999c4 */
public class TFile {
   /** @pdOid dc617ea9-da1d-41ba-86dc-5b2483504d43 */
   public long fileId;
   /** 文件名
    * 
    * @pdOid 87d9f424-db6c-49e8-bf55-67aba46aa50e */
   public java.lang.String fileName;
   /** 文件url
    * 
    * @pdOid 6061f657-ab1c-4f1c-852b-61e925e8a438 */
   public java.lang.String fileUrl;
   /** 文件说明
    * 
    * @pdOid 42fcbdda-70ca-4301-a556-59610cd532e0 */
   public java.lang.String fileComent;
   
   public long getFileId() {
	return fileId;
}

public void setFileId(long fileId) {
	this.fileId = fileId;
}

public java.lang.String getFileName() {
	return fileName;
}

public void setFileName(java.lang.String fileName) {
	this.fileName = fileName;
}

public java.lang.String getFileUrl() {
	return fileUrl;
}

public void setFileUrl(java.lang.String fileUrl) {
	this.fileUrl = fileUrl;
}

public java.lang.String getFileComent() {
	return fileComent;
}

public void setFileComent(java.lang.String fileComent) {
	this.fileComent = fileComent;
}

public java.util.Collection<TFilePermi> gettFilePermi() {
	return tFilePermi;
}

public void settFilePermi(java.util.Collection<TFilePermi> tFilePermi) {
	this.tFilePermi = tFilePermi;
}

/** @pdRoleInfo migr=no name=TFilePermi assc=reference37 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TFilePermi> tFilePermi;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TFilePermi> getTFilePermi() {
      if (tFilePermi == null)
         tFilePermi = new java.util.HashSet<TFilePermi>();
      return tFilePermi;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTFilePermi() {
      if (tFilePermi == null)
         tFilePermi = new java.util.HashSet<TFilePermi>();
      return tFilePermi.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTFilePermi */
   public void setTFilePermi(java.util.Collection<TFilePermi> newTFilePermi) {
      removeAllTFilePermi();
      for (java.util.Iterator iter = newTFilePermi.iterator(); iter.hasNext();)
         addTFilePermi((TFilePermi)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTFilePermi */
   public void addTFilePermi(TFilePermi newTFilePermi) {
      if (newTFilePermi == null)
         return;
      if (this.tFilePermi == null)
         this.tFilePermi = new java.util.HashSet<TFilePermi>();
      if (!this.tFilePermi.contains(newTFilePermi))
      {
         this.tFilePermi.add(newTFilePermi);
         newTFilePermi.setTFile(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTFilePermi */
   public void removeTFilePermi(TFilePermi oldTFilePermi) {
      if (oldTFilePermi == null)
         return;
      if (this.tFilePermi != null)
         if (this.tFilePermi.contains(oldTFilePermi))
         {
            this.tFilePermi.remove(oldTFilePermi);
            oldTFilePermi.setTFile((TFile)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTFilePermi() {
      if (tFilePermi != null)
      {
         TFilePermi oldTFilePermi;
         for (java.util.Iterator iter = getIteratorTFilePermi(); iter.hasNext();)
         {
            oldTFilePermi = (TFilePermi)iter.next();
            iter.remove();
            oldTFilePermi.setTFile((TFile)null);
         }
      }
   }

}