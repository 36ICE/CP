package cn.jxufe.domain;
/***********************************************************************
 * Module:  TUnit.java
 * Author:  Administrator
 * Purpose: Defines the Class TUnit
 ***********************************************************************/

import java.util.*;

/** 单位，如软件工程145班
 * 
 * @pdOid 6cd16a3f-ee57-41f8-ad6d-dcdf60acc76d */
public class TUnit {
   /** 单位id
    * 
    * @pdOid 1d6a1221-4817-408e-b423-27a8ac571cd1 */
   public long unitId;
   /** 单位名
    * 
    * @pdOid a4f2f0a6-9bc3-474a-97eb-052983612ee4 */
   public java.lang.String unitName;
   /** 单位代码
    * 
    * @pdOid e6cf42f1-2f38-475e-bc01-262bc96819fb */
   public java.lang.String unitNumber;
   
   public long getUnitId() {
	return unitId;
}

public void setUnitId(long unitId) {
	this.unitId = unitId;
}

public java.lang.String getUnitName() {
	return unitName;
}

public void setUnitName(java.lang.String unitName) {
	this.unitName = unitName;
}

public java.lang.String getUnitNumber() {
	return unitNumber;
}

public void setUnitNumber(java.lang.String unitNumber) {
	this.unitNumber = unitNumber;
}

/** @pdRoleInfo migr=no name=TUser assc=reference27 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TUser> tUser;
   /** @pdRoleInfo migr=no name=TDepart assc=reference29 mult=0..1 side=A */
   public TDepart tDepart;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TUser> getTUser() {
      if (tUser == null)
         tUser = new java.util.HashSet<TUser>();
      return tUser;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTUser() {
      if (tUser == null)
         tUser = new java.util.HashSet<TUser>();
      return tUser.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTUser */
   public void setTUser(java.util.Collection<TUser> newTUser) {
      removeAllTUser();
      for (java.util.Iterator iter = newTUser.iterator(); iter.hasNext();)
         addTUser((TUser)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTUser */
   public void addTUser(TUser newTUser) {
      if (newTUser == null)
         return;
      if (this.tUser == null)
         this.tUser = new java.util.HashSet<TUser>();
      if (!this.tUser.contains(newTUser))
      {
         this.tUser.add(newTUser);
         newTUser.setTUnit(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTUser */
   public void removeTUser(TUser oldTUser) {
      if (oldTUser == null)
         return;
      if (this.tUser != null)
         if (this.tUser.contains(oldTUser))
         {
            this.tUser.remove(oldTUser);
            oldTUser.setTUnit((TUnit)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTUser() {
      if (tUser != null)
      {
         TUser oldTUser;
         for (java.util.Iterator iter = getIteratorTUser(); iter.hasNext();)
         {
            oldTUser = (TUser)iter.next();
            iter.remove();
            oldTUser.setTUnit((TUnit)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TDepart getTDepart() {
      return tDepart;
   }
   
   /** @pdGenerated default parent setter
     * @param newTDepart */
   public void setTDepart(TDepart newTDepart) {
      if (this.tDepart == null || !this.tDepart.equals(newTDepart))
      {
         if (this.tDepart != null)
         {
            TDepart oldTDepart = this.tDepart;
            this.tDepart = null;
            oldTDepart.removeTUnit(this);
         }
         if (newTDepart != null)
         {
            this.tDepart = newTDepart;
            this.tDepart.addTUnit(this);
         }
      }
   }

}