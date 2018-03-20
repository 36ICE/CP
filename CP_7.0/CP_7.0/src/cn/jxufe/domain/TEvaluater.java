package cn.jxufe.domain;
/***********************************************************************
 * Module:  TEvaluater.java
 * Author:  Administrator
 * Purpose: Defines the Class TEvaluater
 ***********************************************************************/

import java.util.*;

/** 评价人表
 * 
 * @pdOid ad16c683-188f-4b54-8060-1498fde8abf0 */
public class TEvaluater {
   /** 评价人表
    * 
    * @pdOid ead0f9a3-88cc-44fd-af2d-40d89d917d69 */
   public long evaluaterId;
   /** 学期号
    * 
    * @pdOid 482a2789-2788-4ee9-baf0-ca31950c2c48 */
   public long termNum;
   
   public String submit;
   
   public String getSubmit() {
	return submit;
}

public void setSubmit(String submit) {
	this.submit = submit;
}

public long getUserId() {
	return userId;
}

public void setUserId(long userId) {
	this.userId = userId;
}

/**
 * 
 */
public long userId;
   
   /**
 * 
 */
public long evauserId;
   
   public long getEvauserId() {
	return evauserId;
}

public void setEvauserId(long evauserId) {
	this.evauserId = evauserId;
}

/** @pdRoleInfo migr=no name=TUser assc=reference48 mult=0..1 side=A */
   public TUser tUser;
   
   
   public long getEvaluaterId() {
	return evaluaterId;
}

public void setEvaluaterId(long evaluaterId) {
	this.evaluaterId = evaluaterId;
}

public long getTermNum() {
	return termNum;
}

public void setTermNum(long termNum) {
	this.termNum = termNum;
}



/** @pdGenerated default parent getter */
   public TUser getTUser() {
      return tUser;
   }
   
   /** @pdGenerated default parent setter
     * @param newTUser */
   public void setTUser(TUser newTUser) {
      if (this.tUser == null || !this.tUser.equals(newTUser))
      {
         if (this.tUser != null)
         {
            TUser oldTUser = this.tUser;
            this.tUser = null;
            oldTUser.removeTEvaluater(this);
         }
         if (newTUser != null)
         {
            this.tUser = newTUser;
            this.tUser.addTEvaluater(this);
         }
      }
   }

}