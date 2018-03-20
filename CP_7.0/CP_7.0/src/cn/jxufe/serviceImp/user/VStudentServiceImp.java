package cn.jxufe.serviceImp.user;

import cn.jxufe.dao.TSchoolDao;
import cn.jxufe.dao.VStudentDao;
import cn.jxufe.dao.vdao.VInfoDao;
import cn.jxufe.daoImp.TSchoolDaoImp;
import cn.jxufe.daoImp.VStudentDaoImp;
import cn.jxufe.daoImp.vdaoImp.VInfoDaoImp;
import cn.jxufe.domain.TSchool;
import cn.jxufe.domain.ventity.VInfo;
import cn.jxufe.domain.ventity.VStudent;
import cn.jxufe.service.user.VStudentService;

public class VStudentServiceImp implements VStudentService {

	@Override
	public boolean addStudent(VStudent student, String userNum)
			throws Exception {
		
		
		//查找vinfo
		//查找school
		//查找depart
		//查找unitId
		
		//1.
		//TSchoolDao tSchoolDao=new TSchoolDaoImp();
	    VInfoDao vInfoDao=new 	VInfoDaoImp();
		VInfo vInfo=vInfoDao.findByUserNum(userNum);
		String schoolName=vInfo.getSchoolName();
		TSchoolDao schoolDao=new TSchoolDaoImp();
		
		int unitId=vInfo.getUnitId();
		student.setUnitId(unitId);
		student.setCreateRole(userNum);

		int Schoolid=schoolDao.findSchoolIdBySchoolName(schoolName);
		
		//检查学校是否存在
		//if(Schoolid==0){
		//	return false;
		//}
		//检查部门是否存在
		
		//检查单位是否存在
		
		//检查学生是否存在
		//if(vInfoDao.checkUserNum(student.getUserNum())){
		//	return false;
		//}
		//满足上述条件插入数据库
		VStudentDao vStudentDao=new VStudentDaoImp();
		return vStudentDao.add(student);
		
	}

}
