package cn.jxufe.domain;
/***********************************************************************
 * Module:  TSchool.java
 * Author:  Administrator
 * Purpose: Defines the Class TSchool
 ***********************************************************************/

import java.util.*;

/** 学校表
 * 
 * @pdOid b9ef3af3-cd4a-40f0-b88d-b37d609a826f */
public class TSchool {
   /** 学校id
    * 
    * @pdOid f5023587-d869-4937-ac9d-07644604402d */
   public long schoolId;
   /** 学校名
    * 
    * @pdOid b424a52b-fc59-45e2-9620-c5016c6dbe90 */
   public java.lang.String schoolName;
   /** 学校代码
    * 
    * @pdOid e8627729-931d-4cb9-a21c-abd4e2514858 */
   public java.lang.String schoolNumber;
   
   public long getSchoolId() {
	return schoolId;
}

public void setSchoolId(long schoolId) {
	this.schoolId = schoolId;
}

public java.lang.String getSchoolName() {
	return schoolName;
}

public void setSchoolName(java.lang.String schoolName) {
	this.schoolName = schoolName;
}

public java.lang.String getSchoolNumber() {
	return schoolNumber;
}

public void setSchoolNumber(java.lang.String schoolNumber) {
	this.schoolNumber = schoolNumber;
}

/** @pdRoleInfo migr=no name=TDepart assc=reference30 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TDepart> tDepart;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TDepart> getTDepart() {
      if (tDepart == null)
         tDepart = new java.util.HashSet<TDepart>();
      return tDepart;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTDepart() {
      if (tDepart == null)
         tDepart = new java.util.HashSet<TDepart>();
      return tDepart.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTDepart */
   public void setTDepart(java.util.Collection<TDepart> newTDepart) {
      removeAllTDepart();
      for (java.util.Iterator iter = newTDepart.iterator(); iter.hasNext();)
         addTDepart((TDepart)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTDepart */
   public void addTDepart(TDepart newTDepart) {
      if (newTDepart == null)
         return;
      if (this.tDepart == null)
         this.tDepart = new java.util.HashSet<TDepart>();
      if (!this.tDepart.contains(newTDepart))
      {
         this.tDepart.add(newTDepart);
         newTDepart.setTSchool(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTDepart */
   public void removeTDepart(TDepart oldTDepart) {
      if (oldTDepart == null)
         return;
      if (this.tDepart != null)
         if (this.tDepart.contains(oldTDepart))
         {
            this.tDepart.remove(oldTDepart);
            oldTDepart.setTSchool((TSchool)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTDepart() {
      if (tDepart != null)
      {
         TDepart oldTDepart;
         for (java.util.Iterator iter = getIteratorTDepart(); iter.hasNext();)
         {
            oldTDepart = (TDepart)iter.next();
            iter.remove();
            oldTDepart.setTSchool((TSchool)null);
         }
      }
   }

}