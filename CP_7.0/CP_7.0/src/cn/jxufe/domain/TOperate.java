package cn.jxufe.domain;
/***********************************************************************
 * Module:  TOperate.java
 * Author:  Administrator
 * Purpose: Defines the Class TOperate
 ***********************************************************************/

import java.util.*;

/** 操作表
 * 
 * @pdOid a9dca0a3-b88d-4ab8-b584-16f8db5f9740 */
public class TOperate {
   /** 操作id
    * 
    * @pdOid 21a4c4bf-5537-4c1a-87a8-999dcb4e9abe */
   public long operateId;
   /** 操作名
    * 
    * @pdOid 4c822e01-1b46-41c4-9a27-5dadd5e6a731 */
   public java.lang.String operateName;
   
   public long getOperateId() {
	return operateId;
}

public void setOperateId(long operateId) {
	this.operateId = operateId;
}
   
   public java.lang.String getOperateName() {
	return operateName;
}

public void setOperateName(java.lang.String operateName) {
	this.operateName = operateName;
}

/** @pdRoleInfo migr=no name=TOperaPermi assc=reference38 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TOperaPermi> tOperaPermi;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TOperaPermi> getTOperaPermi() {
      if (tOperaPermi == null)
         tOperaPermi = new java.util.HashSet<TOperaPermi>();
      return tOperaPermi;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTOperaPermi() {
      if (tOperaPermi == null)
         tOperaPermi = new java.util.HashSet<TOperaPermi>();
      return tOperaPermi.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTOperaPermi */
   public void setTOperaPermi(java.util.Collection<TOperaPermi> newTOperaPermi) {
      removeAllTOperaPermi();
      for (java.util.Iterator iter = newTOperaPermi.iterator(); iter.hasNext();)
         addTOperaPermi((TOperaPermi)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTOperaPermi */
   public void addTOperaPermi(TOperaPermi newTOperaPermi) {
      if (newTOperaPermi == null)
         return;
      if (this.tOperaPermi == null)
         this.tOperaPermi = new java.util.HashSet<TOperaPermi>();
      if (!this.tOperaPermi.contains(newTOperaPermi))
      {
         this.tOperaPermi.add(newTOperaPermi);
         newTOperaPermi.setTOperate(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTOperaPermi */
   public void removeTOperaPermi(TOperaPermi oldTOperaPermi) {
      if (oldTOperaPermi == null)
         return;
      if (this.tOperaPermi != null)
         if (this.tOperaPermi.contains(oldTOperaPermi))
         {
            this.tOperaPermi.remove(oldTOperaPermi);
            oldTOperaPermi.setTOperate((TOperate)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTOperaPermi() {
      if (tOperaPermi != null)
      {
         TOperaPermi oldTOperaPermi;
         for (java.util.Iterator iter = getIteratorTOperaPermi(); iter.hasNext();)
         {
            oldTOperaPermi = (TOperaPermi)iter.next();
            iter.remove();
            oldTOperaPermi.setTOperate((TOperate)null);
         }
      }
   }

}