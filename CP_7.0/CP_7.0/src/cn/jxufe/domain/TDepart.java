package cn.jxufe.domain;
/***********************************************************************
 * Module:  TDepart.java
 * Author:  Administrator
 * Purpose: Defines the Class TDepart
 ***********************************************************************/

import java.util.*;

/** 部门表，如学院，教务处
 * 
 * @pdOid fb4318a3-a088-4747-a277-6184abaec7a8 */
public class TDepart {
   /** 学院id
    * 
    * @pdOid 63358e93-077d-4fd9-b39d-1ac753fe5d3e */
   public long departId;
   /** 学院名
    * 
    * @pdOid 1a46856d-0b9a-4f73-b233-a80f8a2938a6 */
   public java.lang.String departName;
   /** 学院代码
    * 
    * @pdOid 72d4ae97-6b85-4480-8c14-7c3991a12971 */
   public java.lang.String departNum;
   
   public long getDepartId() {
	return departId;
}

public void setDepartId(long departId) {
	this.departId = departId;
}

public java.lang.String getDepartName() {
	return departName;
}

public void setDepartName(java.lang.String departName) {
	this.departName = departName;
}

public java.lang.String getDepartNum() {
	return departNum;
}

public void setDepartNum(java.lang.String departNum) {
	this.departNum = departNum;
}

public java.util.Collection<TUnit> gettUnit() {
	return tUnit;
}

public void settUnit(java.util.Collection<TUnit> tUnit) {
	this.tUnit = tUnit;
}

public TSchool gettSchool() {
	return tSchool;
}

public void settSchool(TSchool tSchool) {
	this.tSchool = tSchool;
}

/** @pdRoleInfo migr=no name=TUnit assc=reference29 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TUnit> tUnit;
   /** @pdRoleInfo migr=no name=TSchool assc=reference30 mult=0..1 side=A */
   public TSchool tSchool;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TUnit> getTUnit() {
      if (tUnit == null)
         tUnit = new java.util.HashSet<TUnit>();
      return tUnit;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTUnit() {
      if (tUnit == null)
         tUnit = new java.util.HashSet<TUnit>();
      return tUnit.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTUnit */
   public void setTUnit(java.util.Collection<TUnit> newTUnit) {
      removeAllTUnit();
      for (java.util.Iterator iter = newTUnit.iterator(); iter.hasNext();)
         addTUnit((TUnit)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTUnit */
   public void addTUnit(TUnit newTUnit) {
      if (newTUnit == null)
         return;
      if (this.tUnit == null)
         this.tUnit = new java.util.HashSet<TUnit>();
      if (!this.tUnit.contains(newTUnit))
      {
         this.tUnit.add(newTUnit);
         newTUnit.setTDepart(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTUnit */
   public void removeTUnit(TUnit oldTUnit) {
      if (oldTUnit == null)
         return;
      if (this.tUnit != null)
         if (this.tUnit.contains(oldTUnit))
         {
            this.tUnit.remove(oldTUnit);
            oldTUnit.setTDepart((TDepart)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTUnit() {
      if (tUnit != null)
      {
         TUnit oldTUnit;
         for (java.util.Iterator iter = getIteratorTUnit(); iter.hasNext();)
         {
            oldTUnit = (TUnit)iter.next();
            iter.remove();
            oldTUnit.setTDepart((TDepart)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TSchool getTSchool() {
      return tSchool;
   }
   
   /** @pdGenerated default parent setter
     * @param newTSchool */
   public void setTSchool(TSchool newTSchool) {
      if (this.tSchool == null || !this.tSchool.equals(newTSchool))
      {
         if (this.tSchool != null)
         {
            TSchool oldTSchool = this.tSchool;
            this.tSchool = null;
            oldTSchool.removeTDepart(this);
         }
         if (newTSchool != null)
         {
            this.tSchool = newTSchool;
            this.tSchool.addTDepart(this);
         }
      }
   }

}