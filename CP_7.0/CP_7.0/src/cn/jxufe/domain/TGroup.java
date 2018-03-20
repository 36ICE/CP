package cn.jxufe.domain;
/***********************************************************************
 * Module:  TGroupId.java
 * Author:  Administrator
 * Purpose: Defines the Class TGroupId
 ***********************************************************************/

import java.util.*;

/** 组
 * 
 * @pdOid 404901d4-340d-46a7-b4a8-5835c88ff5ae */
public class TGroup {
   /** 用户组id
    * 
    * @pdOid 87af1138-7f4b-4272-8593-9e9c55ee7499 */
   public long groupId;
   /** 组名
    * 
    * @pdOid 7132b0c5-fb70-4d9e-8107-ec44967019c0 */
   public java.lang.String groupName;
   /** 描述
    * 
    * @pdOid fbd7512c-fc42-429c-92c0-9e2472ea72f2 */
   public java.lang.String groupCom;
   
   public long getGroupId() {
	return groupId;
}

public void setGroupId(long groupId) {
	this.groupId = groupId;
}

public java.lang.String getGroupName() {
	return groupName;
}

public void setGroupName(java.lang.String groupName) {
	this.groupName = groupName;
}

public java.lang.String getGroupCom() {
	return groupCom;
}

public void setGroupCom(java.lang.String groupCom) {
	this.groupCom = groupCom;
}

/** @pdRoleInfo migr=no name=TUserGroup assc=reference42 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TUserGroup> tUserGroup;
   /** @pdRoleInfo migr=no name=TRoleGroup assc=reference43 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TRoleGroup> tRoleGroup;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TUserGroup> getTUserGroup() {
      if (tUserGroup == null)
         tUserGroup = new java.util.HashSet<TUserGroup>();
      return tUserGroup;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<TUserGroup> getIteratorTUserGroup() {
      if (tUserGroup == null)
         tUserGroup = new java.util.HashSet<TUserGroup>();
      return tUserGroup.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTUserGroup */
   public void setTUserGroup(java.util.Collection<TUserGroup> newTUserGroup) {
      removeAllTUserGroup();
      for (java.util.Iterator<TUserGroup> iter = newTUserGroup.iterator(); iter.hasNext();)
         addTUserGroup(iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTUserGroup */
   public void addTUserGroup(TUserGroup newTUserGroup) {
      if (newTUserGroup == null)
         return;
      if (this.tUserGroup == null)
         this.tUserGroup = new java.util.HashSet<TUserGroup>();
      if (!this.tUserGroup.contains(newTUserGroup))
      {
         this.tUserGroup.add(newTUserGroup);
         newTUserGroup.setTGroupId(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTUserGroup */
   public void removeTUserGroup(TUserGroup oldTUserGroup) {
      if (oldTUserGroup == null)
         return;
      if (this.tUserGroup != null)
         if (this.tUserGroup.contains(oldTUserGroup))
         {
            this.tUserGroup.remove(oldTUserGroup);
            oldTUserGroup.setTGroupId((TGroup)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTUserGroup() {
      if (tUserGroup != null)
      {
         TUserGroup oldTUserGroup;
         for (java.util.Iterator<TUserGroup> iter = getIteratorTUserGroup(); iter.hasNext();)
         {
            oldTUserGroup = iter.next();
            iter.remove();
            oldTUserGroup.setTGroupId((TGroup)null);
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
   public java.util.Iterator<TRoleGroup> getIteratorTRoleGroup() {
      if (tRoleGroup == null)
         tRoleGroup = new java.util.HashSet<TRoleGroup>();
      return tRoleGroup.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTRoleGroup */
   public void setTRoleGroup(java.util.Collection<TRoleGroup> newTRoleGroup) {
      removeAllTRoleGroup();
      for (java.util.Iterator<TRoleGroup> iter = newTRoleGroup.iterator(); iter.hasNext();)
         addTRoleGroup(iter.next());
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
         newTRoleGroup.setTGroupId(this);      
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
            oldTRoleGroup.setTGroupId((TGroup)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTRoleGroup() {
      if (tRoleGroup != null)
      {
         TRoleGroup oldTRoleGroup;
         for (java.util.Iterator<TRoleGroup> iter = getIteratorTRoleGroup(); iter.hasNext();)
         {
            oldTRoleGroup = iter.next();
            iter.remove();
            oldTRoleGroup.setTGroupId((TGroup)null);
         }
      }
   }

}