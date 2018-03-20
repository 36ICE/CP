package cn.jxufe.domain;
/***********************************************************************
 * Module:  TRole.java
 * Author:  Administrator
 * Purpose: Defines the Class TRole
 ***********************************************************************/

import java.util.*;

/** 角色
 * 
 * @pdOid f7bd75ef-a69d-4bb8-8cd8-dda501cb9e0a */
public class TRole {
   /** 自动增长
    * 
    * @pdOid c05bd3cf-ef20-4d3c-9f6a-f55009ad021f */
   public long roleId;
   /** 角色名,学生，毕业生，班主任，班助，系统管理员，研究院
    * 
    * @pdOid eba0c20f-24a9-4c70-9ca6-c67288e091e8 */
   public java.lang.String roleName;
   /** 角色描述
    * 
    * @pdOid 656912e6-a421-4ca0-869c-563414b4c273 */
   public java.lang.String roleCom;
   
   public long getRoleId() {
	return roleId;
}

public void setRoleId(long roleId) {
	this.roleId = roleId;
}

public java.lang.String getRoleName() {
	return roleName;
}

public void setRoleName(java.lang.String roleName) {
	this.roleName = roleName;
}

public java.lang.String getRoleCom() {
	return roleCom;
}

public void setRoleCom(java.lang.String roleCom) {
	this.roleCom = roleCom;
}

/** @pdRoleInfo migr=no name=TUserRole assc=reference31 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TUserRole> tUserRole;
   /** @pdRoleInfo migr=no name=TRolePermi assc=reference41 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TRolePermi> tRolePermi;
   /** @pdRoleInfo migr=no name=TRoleGroup assc=reference44 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TRoleGroup> tRoleGroup;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TUserRole> getTUserRole() {
      if (tUserRole == null)
         tUserRole = new java.util.HashSet<TUserRole>();
      return tUserRole;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTUserRole() {
      if (tUserRole == null)
         tUserRole = new java.util.HashSet<TUserRole>();
      return tUserRole.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTUserRole */
   public void setTUserRole(java.util.Collection<TUserRole> newTUserRole) {
      removeAllTUserRole();
      for (java.util.Iterator iter = newTUserRole.iterator(); iter.hasNext();)
         addTUserRole((TUserRole)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTUserRole */
   public void addTUserRole(TUserRole newTUserRole) {
      if (newTUserRole == null)
         return;
      if (this.tUserRole == null)
         this.tUserRole = new java.util.HashSet<TUserRole>();
      if (!this.tUserRole.contains(newTUserRole))
      {
         this.tUserRole.add(newTUserRole);
         newTUserRole.setTRole(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTUserRole */
   public void removeTUserRole(TUserRole oldTUserRole) {
      if (oldTUserRole == null)
         return;
      if (this.tUserRole != null)
         if (this.tUserRole.contains(oldTUserRole))
         {
            this.tUserRole.remove(oldTUserRole);
            oldTUserRole.setTRole((TRole)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTUserRole() {
      if (tUserRole != null)
      {
         TUserRole oldTUserRole;
         for (java.util.Iterator iter = getIteratorTUserRole(); iter.hasNext();)
         {
            oldTUserRole = (TUserRole)iter.next();
            iter.remove();
            oldTUserRole.setTRole((TRole)null);
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
         newTRolePermi.setTRole(this);      
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
            oldTRolePermi.setTRole((TRole)null);
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
            oldTRolePermi.setTRole((TRole)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TRoleGroup> getTRoleGroup() {
      if (tRoleGroup == null)
         tRoleGroup = new java.util.HashSet<TRoleGroup>();
      return tRoleGroup;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTRoleGroup() {
      if (tRoleGroup == null)
         tRoleGroup = new java.util.HashSet<TRoleGroup>();
      return tRoleGroup.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTRoleGroup */
   public void setTRoleGroup(java.util.Collection<TRoleGroup> newTRoleGroup) {
      removeAllTRoleGroup();
      for (java.util.Iterator iter = newTRoleGroup.iterator(); iter.hasNext();)
         addTRoleGroup((TRoleGroup)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTRoleGroup */
   public void addTRoleGroup(TRoleGroup newTRoleGroup) {
      if (newTRoleGroup == null)
         return;
      if (this.tRoleGroup == null)
         this.tRoleGroup = new java.util.HashSet<TRoleGroup>();
      if (!this.tRoleGroup.contains(newTRoleGroup))
      {
         this.tRoleGroup.add(newTRoleGroup);
         newTRoleGroup.setTRole(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTRoleGroup */
   public void removeTRoleGroup(TRoleGroup oldTRoleGroup) {
      if (oldTRoleGroup == null)
         return;
      if (this.tRoleGroup != null)
         if (this.tRoleGroup.contains(oldTRoleGroup))
         {
            this.tRoleGroup.remove(oldTRoleGroup);
            oldTRoleGroup.setTRole((TRole)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTRoleGroup() {
      if (tRoleGroup != null)
      {
         TRoleGroup oldTRoleGroup;
         for (java.util.Iterator iter = getIteratorTRoleGroup(); iter.hasNext();)
         {
            oldTRoleGroup = (TRoleGroup)iter.next();
            iter.remove();
            oldTRoleGroup.setTRole((TRole)null);
         }
      }
   }

}