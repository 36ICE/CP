package cn.jxufe.domain;
/***********************************************************************
 * Module:  TPage.java
 * Author:  Administrator
 * Purpose: Defines the Class TPage
 ***********************************************************************/

import java.util.*;

/** 页面表
 * 
 * @pdOid 46a1c7a8-bac3-4b4b-9e03-344f7a34f65a */
public class TPage {
   /** @pdOid 3c1d4e0b-e1a8-4e31-b5c0-b3063e203c85 */
   public long pageId;
   /** @pdOid 401efebd-2c77-4152-b569-152eced89787 */
   public java.lang.String pafeName;
   /** @pdOid 6ca01f4f-1da0-4682-9932-d866ce589294 */
   public java.lang.String pageUrl;
   /** 页面说明
    * 
    * @pdOid ddff7daa-d4ae-433d-9be2-d47a61b6f722 */
   public java.lang.String pageComment;
  
   public long getPageId() {
	return pageId;
}

public void setPageId(long pageId) {
	this.pageId = pageId;
}
   
   public java.lang.String getPafeName() {
	return pafeName;
}

public void setPafeName(java.lang.String pafeName) {
	this.pafeName = pafeName;
}

public java.lang.String getPageUrl() {
	return pageUrl;
}

public void setPageUrl(java.lang.String pageUrl) {
	this.pageUrl = pageUrl;
}

public java.lang.String getPageComment() {
	return pageComment;
}

public void setPageComment(java.lang.String pageComment) {
	this.pageComment = pageComment;
}

/** @pdRoleInfo migr=no name=TPagePermi assc=reference36 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TPagePermi> tPagePermi;
   
   
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
         newTPagePermi.setTPage(this);      
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
            oldTPagePermi.setTPage((TPage)null);
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
            oldTPagePermi.setTPage((TPage)null);
         }
      }
   }

}