package cn.jxufe.domain;
/***********************************************************************
 * Module:  TMenu.java
 * Author:  Administrator
 * Purpose: Defines the Class TMenu
 ***********************************************************************/

import java.util.*;

/** 菜单表
 * 
 * @pdOid 5763ee3c-4eaa-4eb2-9795-b3e56e893c3a */
public class TMenu {
   /** 菜单id
    * 
    * @pdOid 00233abf-8014-49ac-8f8b-17cf7f89a522 */
   public long menuId;
   /** 菜单名
    * 
    * @pdOid 0d74ce29-5002-437f-9721-4956c5475c1b */
   public java.lang.String menuName;
   /** 菜单url
    * 
    * @pdOid 058b610b-73fb-405e-b034-ee0951642099 */
   public java.lang.String menuUrl;
   /** 父菜单id
    * 
    * @pdOid 7cd3a388-8146-4b20-a75a-060ed08928cf */
   public long parentId;
   /** 菜单说明
    * 
    * @pdOid 877adf86-466f-4f6a-aced-bb382eab3d2a */
   public java.lang.String menuComment;
   
   public long getMenuId() {
	return menuId;
}

public void setMenuId(long menuId) {
	this.menuId = menuId;
}

public java.lang.String getMenuName() {
	return menuName;
}

public void setMenuName(java.lang.String menuName) {
	this.menuName = menuName;
}

public java.lang.String getMenuUrl() {
	return menuUrl;
}

public void setMenuUrl(java.lang.String menuUrl) {
	this.menuUrl = menuUrl;
}

public long getParentId() {
	return parentId;
}

public void setParentId(long parentId) {
	this.parentId = parentId;
}

public java.lang.String getMenuComment() {
	return menuComment;
}

public void setMenuComment(java.lang.String menuComment) {
	this.menuComment = menuComment;
}

/** @pdRoleInfo migr=no name=TMenuPermi assc=reference35 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TMenuPermi> tMenuPermi;
   
   
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
         newTMenuPermi.setTMenu(this);      
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
            oldTMenuPermi.setTMenu((TMenu)null);
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
            oldTMenuPermi.setTMenu((TMenu)null);
         }
      }
   }

}