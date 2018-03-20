package cn.jxufe.domain.ventity;

import cn.jxufe.domain.TDepart;
import cn.jxufe.domain.TEvaluate;
import cn.jxufe.domain.TExcTar;
import cn.jxufe.domain.TReaTar;
import cn.jxufe.domain.TUnit;

public class VTar {

	 /** 学院id
	    * 
	    * @pdOid 63358e93-077d-4fd9-b39d-1ac753fe5d3e */
	   public long departId;
	   /** 学院名
	    * 
	    * @pdOid 1a46856d-0b9a-4f73-b233-a80f8a2938a6 */
	   public java.lang.String departName;
	   
	   /** 学校id
	    * 
	    * @pdOid f5023587-d869-4937-ac9d-07644604402d */
	   public long schoolId;
	   /** 学校名
	    * 
	    * @pdOid b424a52b-fc59-45e2-9620-c5016c6dbe90 */
	   public java.lang.String schoolName;
	   
	   /** 单位id
	    * 
	    * @pdOid 1d6a1221-4817-408e-b423-27a8ac571cd1 */
	   public long unitId;
	   /** 单位名
	    * 
	    * @pdOid a4f2f0a6-9bc3-474a-97eb-052983612ee4 */
	   public java.lang.String unitName;
	   
	   /**
		 * 用户号
		 * 
		 * @pdOid ee1f5d76-d179-4258-b1cd-d8a9c6effaaf
		 */
		public java.lang.String userNum;
		/**
		 * 姓名
		 * 
		 * @pdOid dfed481e-0c5c-4161-9e07-3a8cbb608c02
		 */
	   public java.lang.String userName;
		
		   public long getTermNum() {
			return termNum;
		}
		public void setTermNum(long termNum) {
			this.termNum = termNum;
		}
		/** 评价人id
		    * 
		    * @pdOid 91a74bbb-4415-4ac6-bfb4-acb05a4b6075 */
	   public long eveluaterId;
		   /** 学期号1，2，3，4，5，6，7，8
		    * 
		    * @pdOid 2598d378-7a38-4faa-bbb5-383aee0d0acc */
	   public long termNum;
		
		 public long getEveluaterId() {
			return eveluaterId;
		}
		public void setEveluaterId(long eveluaterId) {
			this.eveluaterId = eveluaterId;
		}
		/** 专业学习
		    * 
		    * @pdOid 1f2e3d9c-6395-408d-9808-3bf3b1c2ce5c */
		   public long gProLea;
		   /** 非专业学习
		    * 
		    * @pdOid 26b04746-589d-4a8b-8d84-924726246f3e */
		   public long gNonProLea;
		   /** 课外学习
		    * 
		    * @pdOid 0adee881-72a8-4d0b-9b07-6bc3f799d69b */
		   public long gExtraLearn;
		   /** 身体健康
		    * 
		    * @pdOid 82741941-3242-47f7-9d5f-9ec85c01bc3e */
		   public long gPhyHealth;
		   /** 心理健康
		    * 
		    * @pdOid fd4d2449-11dc-4b59-9d8c-27a0188ffcf3 */
		   public long gMentalHealth;
		   /** 理财
		    * 
		    * @pdOid 553bfe26-2ccb-4a05-83e8-cb4363cea977 */
		   public long gManageMoney;
		   /** 人际沟通
		    * 
		    * @pdOid 72a541e1-a276-4260-aeeb-dd5fb983557b */
		   public long gInterpersonal;
		   /** 社团部门
		    * 
		    * @pdOid 5ca705c8-a880-4566-8409-0bdfae33ac9f */
		   public long gClubEvent;
		   /** 社会
		    * 
		    * @pdOid 182392b2-e651-4e35-8baa-be78f97a0111 */
		   public long gSocialEvent;
		   
		   
		   
		   /** 专业学习
		    * 
		    * @pdOid 19067110-8f7e-4945-9393-5182cd14ad1d */
		   public java.lang.String eProLea;
		   /** 非专业学习
		    * 
		    * @pdOid 4ffaef02-f69d-4a88-8710-a80f5df333c3 */
		   public java.lang.String eNonProLea;
		   /** 课外学习
		    * 
		    * @pdOid c2883e22-09fe-48df-b9a1-3225b1b216f7 */
		   public java.lang.String eExtraLearn;
		   /** 身体健康
		    * 
		    * @pdOid e6baa0ab-1819-492a-ac99-acf7698f8d76 */
		   public java.lang.String ePhyHealth;
		   /** 心理健康
		    * 
		    * @pdOid 3d271a47-f38b-428b-a61c-a1a44335c49e */
		   public java.lang.String eMentalHealth;
		   /** 理财
		    * 
		    * @pdOid 76befc00-97ae-45aa-8620-ba820711d019 */
		   public java.lang.String eManageMoney;
		   /** 人际沟通
		    * 
		    * @pdOid 4a26e1f3-e3a1-45de-b0a1-cde4f0083a49 */
		   public java.lang.String eInterpersonal;
		   /** 社团部门
		    * 
		    * @pdOid a8fe2b27-4be0-4617-ba2f-43775d6aa35a */
		   public java.lang.String eClubEvent;
		   /** 社会
		    * 
		    * @pdOid eac26178-fa7d-4c4c-ac08-e9d890cba6f0 */
		   public java.lang.String eSocialEvent;
		   
		   
		   /** 专业学习
		    * 
		    * @pdOid 3e33cc4f-a2c5-42d0-b9ec-b28ee949a867 */
		   public java.lang.String rProLea;
		   /** 非专业学习
		    * 
		    * @pdOid 390e1fcd-1ca9-4201-bdd0-c42bcda719b7 */
		   public java.lang.String rNonProLea;
		   /** 课外学习
		    * 
		    * @pdOid 9f9a4a79-8b35-4588-9a41-20b62dfa5407 */
		   public java.lang.String rExtraLearn;
		   /** 身体健康
		    * 
		    * @pdOid c206da8c-234d-40a8-87c6-fb8c3fa5f9aa */
		   public java.lang.String rPhyHealth;
		   /** 心理健康
		    * 
		    * @pdOid bf7b10be-38a7-4a85-9d05-6c7e05e7d708 */
		   public java.lang.String rMentalHealth;
		   /** 理财
		    * 
		    * @pdOid be256f13-6806-400d-a759-bc774b2968a1 */
		   public java.lang.String rManageMoney;
		   /** 人际沟通
		    * 
		    * @pdOid b4b0da83-b338-4130-a443-6c42af01d9b9 */
		   public java.lang.String rInterpersonal;
		   /** 社团部门
		    * 
		    * @pdOid ae041793-93ec-4c95-9870-268c036e5d9a */
		   public java.lang.String rClubEvent;
		   /** 社会
		    * 
		    * @pdOid ebe13702-c688-4235-8d01-91925d7f3ef1 */
		   public java.lang.String rSocialEvent;
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
		public java.lang.String getUserNum() {
			return userNum;
		}
		public void setUserNum(java.lang.String userNum) {
			this.userNum = userNum;
		}
		public java.lang.String getUserName() {
			return userName;
		}
		public void setUserName(java.lang.String userName) {
			this.userName = userName;
		}
		public long getgProLea() {
			return gProLea;
		}
		public void setgProLea(long gProLea) {
			this.gProLea = gProLea;
		}
		public long getgNonProLea() {
			return gNonProLea;
		}
		public void setgNonProLea(long gNonProLea) {
			this.gNonProLea = gNonProLea;
		}
		public long getgExtraLearn() {
			return gExtraLearn;
		}
		public void setgExtraLearn(long gExtraLearn) {
			this.gExtraLearn = gExtraLearn;
		}
		public long getgPhyHealth() {
			return gPhyHealth;
		}
		public void setgPhyHealth(long gPhyHealth) {
			this.gPhyHealth = gPhyHealth;
		}
		public long getgMentalHealth() {
			return gMentalHealth;
		}
		public void setgMentalHealth(long gMentalHealth) {
			this.gMentalHealth = gMentalHealth;
		}
		public long getgManageMoney() {
			return gManageMoney;
		}
		public void setgManageMoney(long gManageMoney) {
			this.gManageMoney = gManageMoney;
		}
		public long getgInterpersonal() {
			return gInterpersonal;
		}
		public void setgInterpersonal(long gInterpersonal) {
			this.gInterpersonal = gInterpersonal;
		}
		public long getgClubEvent() {
			return gClubEvent;
		}
		public void setgClubEvent(long gClubEvent) {
			this.gClubEvent = gClubEvent;
		}
		public long getgSocialEvent() {
			return gSocialEvent;
		}
		public void setgSocialEvent(long gSocialEvent) {
			this.gSocialEvent = gSocialEvent;
		}
		public java.lang.String geteProLea() {
			return eProLea;
		}
		public void seteProLea(java.lang.String eProLea) {
			this.eProLea = eProLea;
		}
		public java.lang.String geteNonProLea() {
			return eNonProLea;
		}
		public void seteNonProLea(java.lang.String eNonProLea) {
			this.eNonProLea = eNonProLea;
		}
		public java.lang.String geteExtraLearn() {
			return eExtraLearn;
		}
		public void seteExtraLearn(java.lang.String eExtraLearn) {
			this.eExtraLearn = eExtraLearn;
		}
		public java.lang.String getePhyHealth() {
			return ePhyHealth;
		}
		public void setePhyHealth(java.lang.String ePhyHealth) {
			this.ePhyHealth = ePhyHealth;
		}
		public java.lang.String geteMentalHealth() {
			return eMentalHealth;
		}
		public void seteMentalHealth(java.lang.String eMentalHealth) {
			this.eMentalHealth = eMentalHealth;
		}
		public java.lang.String geteManageMoney() {
			return eManageMoney;
		}
		public void seteManageMoney(java.lang.String eManageMoney) {
			this.eManageMoney = eManageMoney;
		}
		public java.lang.String geteInterpersonal() {
			return eInterpersonal;
		}
		public void seteInterpersonal(java.lang.String eInterpersonal) {
			this.eInterpersonal = eInterpersonal;
		}
		public java.lang.String geteClubEvent() {
			return eClubEvent;
		}
		public void seteClubEvent(java.lang.String eClubEvent) {
			this.eClubEvent = eClubEvent;
		}
		public java.lang.String geteSocialEvent() {
			return eSocialEvent;
		}
		public void seteSocialEvent(java.lang.String eSocialEvent) {
			this.eSocialEvent = eSocialEvent;
		}
		public java.lang.String getrProLea() {
			return rProLea;
		}
		public void setrProLea(java.lang.String rProLea) {
			this.rProLea = rProLea;
		}
		public java.lang.String getrNonProLea() {
			return rNonProLea;
		}
		public void setrNonProLea(java.lang.String rNonProLea) {
			this.rNonProLea = rNonProLea;
		}
		public java.lang.String getrExtraLearn() {
			return rExtraLearn;
		}
		public void setrExtraLearn(java.lang.String rExtraLearn) {
			this.rExtraLearn = rExtraLearn;
		}
		public java.lang.String getrPhyHealth() {
			return rPhyHealth;
		}
		public void setrPhyHealth(java.lang.String rPhyHealth) {
			this.rPhyHealth = rPhyHealth;
		}
		public java.lang.String getrMentalHealth() {
			return rMentalHealth;
		}
		public void setrMentalHealth(java.lang.String rMentalHealth) {
			this.rMentalHealth = rMentalHealth;
		}
		public java.lang.String getrManageMoney() {
			return rManageMoney;
		}
		public void setrManageMoney(java.lang.String rManageMoney) {
			this.rManageMoney = rManageMoney;
		}
		public java.lang.String getrInterpersonal() {
			return rInterpersonal;
		}
		public void setrInterpersonal(java.lang.String rInterpersonal) {
			this.rInterpersonal = rInterpersonal;
		}
		public java.lang.String getrClubEvent() {
			return rClubEvent;
		}
		public void setrClubEvent(java.lang.String rClubEvent) {
			this.rClubEvent = rClubEvent;
		}
		public java.lang.String getrSocialEvent() {
			return rSocialEvent;
		}
		public void setrSocialEvent(java.lang.String rSocialEvent) {
			this.rSocialEvent = rSocialEvent;
		}

	
	/*TExcTar texcTar;
	

	TReaTar tReatar;

	TEvaluate tEvaluate;

	TUnit tUnit;
	

	TDepart tDepart;
	
	public TExcTar getTexcTar() {
		return texcTar=new TExcTar();
	}



	public TReaTar gettReatar() {
		return tReatar= new TReaTar();
	}



	public TEvaluate gettEvaluate() {
		
		return tEvaluate= new TEvaluate();
	}
	public TUnit getTUnit(){
		return tUnit= new TUnit();
	}
	public TDepart getTDepart(){
		
		return tDepart= new TDepart();
	}
	*/
}
