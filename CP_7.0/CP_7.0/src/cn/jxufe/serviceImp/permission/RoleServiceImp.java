package cn.jxufe.serviceImp.permission;

import cn.jxufe.dao.vdao.VRoleDao;
import cn.jxufe.daoImp.vdaoImp.VRoleDaoImp;
import cn.jxufe.service.permission.RoleService;

public class RoleServiceImp implements RoleService {

	@Override
	public boolean isRole(String userNum,String roleName) throws Exception {
		
		VRoleDao vRoleDao=new VRoleDaoImp();
		if(vRoleDao.findByUserNum(userNum).getRoleName().equals(roleName)){
			return true;
			
		}else{
			return false;
		}
		/*if(vRoleDao.findRoleNameByUserNum(userNum).equals(roleName)){
			System.out.println(vRoleDao.findRoleNameByUserNum(userNum)+"=="+roleName);
			return true;
		}else{
			return false;
		}*/
		
	}
	@Override
	public String getRoleName(String userNum) throws Exception{
		
		return (new VRoleDaoImp()).findRoleNameByUserNum(userNum);
	}

}
