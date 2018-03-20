package cn.jxufe.domain;
/***********************************************************************
 * Module:  TPermission.java
 * Author:  Administrator
 * Purpose: Defines the Class TPermission
 ***********************************************************************/

import java.util.*;

/** 权限表
 * 
 * @pdOid 48674121-e16c-4965-948a-b8043d0fa17f */
public class TPermission {
   /** 权限id
    * 
    * @pdOid 827273f5-abfe-4b57-9e28-f839467da7ae */
   public long permiId;
   /** 权限名
    * 
    * @pdOid 6624ae04-8db1-45fa-b700-6238846eca93 */
   public java.lang.String permiName;
   /** 权限描述
    * 
    * @pdOid c1d15070-b72e-438f-baef-a7fd89eff7ae */
   public java.lang.String permiCom;
   
   public long getPermiId() {
	return permiId;
}

public void setPermiId(long permiId) {
	this.permiId = permiId;
}
   public java.lang.String getPermiName() {
	return permiName;
}

public void setPermiName(java.lang.String permiName) {
	this.permiName = permiName;
}

public java.lang.String getPermiCom() {
	return permiCom;
}

public void setPermiCom(java.lang.String permiCom) {
	this.permiCom = permiCom;
}

/** @pdRoleInfo migr=no name=TFilePermi assc=reference32 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TFilePermi> tFilePermi;
   /** @pdRoleInfo migr=no name=TMenuPermi assc=reference33 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TMenuPermi> tMenuPermi;
   /** @pdRoleInfo migr=no name=TPagePermi assc=reference34 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TPagePermi> tPagePermi;
   /** @pdRoleInfo migr=no name=TOperaPermi assc=reference39 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TOperaPermi> tOperaPermi;
   /** @pdRoleInfo migr=no name=TRolePermi assc=reference40 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TRolePermi> tRolePermi;
   
   
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
         newTFilePermi.setTPermission(this);      
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
            oldTFilePermi.setTPermission((TPermission)null);
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
            oldTFilePermi.setTPermission((TPermission)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TMenuPermi> getTMenuPermi() {
      if (tMenuPermi == null)
         tMenuPermi = new java.util.HashSet<TMenuPermi>();
      return tMenuPermi;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTMenuPermi() {
      if (tMenuPermi == null)
         tMenuPermi = new java.util.HashSet<TMenuPermi>();
      return tMenuPermi.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTMenuPermi */
   public void setTMenuPermi(java.util.Collection<TMenuPermi> newTMenuPermi) {
      removeAllTMenuPermi();
      for (java.util.Iterator iter = newTMenuPermi.iterator(); iter.hasNext();)
         addTMenuPermi((TMenuPermi)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTMenuPermi */
   public void addTMenuPermi(TMenuPermi newTMenuPermi) {
      if (newTMenuPermi == null)
         return;
      if (this.tMenuPermi == null)
         this.tMenuPermi = new java.util.HashSet<TMenuPermi>();
      if (!this.tMenuPermi.contains(newTMenuPermi))
      {
         this.tMenuPermi.add(newTMenuPermi);
         newTMenuPermi.setTPermission(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTMenuPermi */
   public void removeTMenuPermi(TMenuPermi oldTMenuPermi) {
      if (oldTMenuPermi == null)
         return;
      if (this.tMenuPermi != null)
         if (this.tMenuPermi.contains(oldTMenuPermi))
         {
            this.tMenuPermi.remove(oldTMenuPermi);
            oldTMenuPermi.setTPermission((TPermission)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTMenuPermi() {
      if (tMenuPermi != null)
      {
         TMenuPermi oldTMenuPermi;
         for (java.util.Iterator iter = getIteratorTMenuPermi(); iter.hasNext();)
         {
            oldTMenuPermi = (TMenuPermi)iter.next();
            iter.remove();
            oldTMenuPermi.setTPermission((TPermission)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TPagePermi> getTPagePermi() {
      if (tPagePermi == null)
         tPagePermi = new java.util.HashSet<TPagePermi>();
      return tPagePermi;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTPagePermi() {
      if (tPagePermi == null)
         tPagePermi = new java.util.HashSet<TPagePermi>();
      return tPagePermi.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTPagePermi */
   public void setTPagePermi(java.util.Collection<TPagePermi> newTPagePermi) {
      removeAllTPagePermi();
      for (java.util.Iterator iter = newTPagePermi.iterator(); iter.hasNext();)
         addTPagePermi((TPagePermi)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTPagePermi */
   public void addTPagePermi(TPagePermi newTPagePermi) {
      if (newTPagePermi == null)
         return;
      if (this.tPagePermi == null)
         this.tPagePermi = new java.util.HashSet<TPagePermi>();
      if (!this.tPagePermi.contains(newTPagePermi))
      {
         this.tPagePermi.add(newTPagePermi);
         newTPagePermi.setTPermission(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTPagePermi */
   public void removeTPagePermi(TPagePermi oldTPagePermi) {
      if (oldTPagePermi == null)
         return;
      if (this.tPagePermi != null)
         if (this.tPagePermi.contains(oldTPagePermi))
         {
            this.tPagePermi.remove(oldTPagePermi);
            oldTPagePermi.setTPermission((TPermission)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTPagePermi() {
      if (tPagePermi != null)
      {
         TPagePermi oldTPagePermi;
         for (java.util.Iterator iter = getIteratorTPagePermi(); iter.hasNext();)
         {
            oldTPagePermi = (TPagePermi)iter.next();
            iter.remove();
            oldTPagePermi.setTPermission((TPermission)null);
         }
      }
   }
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
         newTOperaPermi.setTPermission(this);      
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
            oldTOperaPermi.setTPermission((TPermission)null);
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
            oldTOperaPermi.setTPermission((TPermission)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TRolePermi> getTRolePermi() {
      if (tRolePermi == null)
         tRolePermi = new java.util.HashSet<TRolePermi>();
      return tRolePermi;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTRolePermi() {
      if (tRolePermi == null)
         tRolePermi = new java.util.HashSet<TRolePermi>();
      return tRolePermi.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTRolePermi */
   public void setTRolePermi(java.util.Collection<TRolePermi> newTRolePermi) {
      removeAllTRolePermi();
      for (java.util.Iterator iter = newTRolePermi.iterator(); iter.hasNext();)
         addTRolePermi((TRolePermi)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTRolePermi */
   public void addTRolePermi(TRolePermi newTRolePermi) {
      if (newTRolePermi == null)
         return;
      if (this.tRolePermi == null)
         this.tRolePermi = new java.util.HashSet<TRolePermi>();
      if (!this.tRolePermi.contains(newTRolePermi))
      {
         this.tRolePermi.add(newTRolePermi);
         newTRolePermi.setTPermission(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTRolePermi */
   public void removeTRolePermi(TRolePermi oldTRolePermi) {
      if (oldTRolePermi == null)
         return;
      if (this.tRolePermi != null)
         if (this.tRolePermi.contains(oldTRolePermi))
         {
            this.tRolePermi.remove(oldTRolePermi);
            oldTRolePermi.setTPermission((TPermission)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTRolePermi() {
      if (tRolePermi != null)
      {
         TRolePermi oldTRolePermi;
         for (java.util.Iterator iter = getIteratorTRolePermi(); iter.hasNext();)
         {
            oldTRolePermi = (TRolePermi)iter.next();
            iter.remove();
            oldTRolePermi.setTPermission((TPermission)null);
         }
      }
   }

}