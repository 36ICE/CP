package cn.jxufe.controller.permission;

import cn.jxufe.controller.permission.ConstantValue.RoleStudent;
import cn.jxufe.service.permission.RoleService;
import cn.jxufe.serviceImp.permission.RoleServiceImp;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleService roleService=new RoleServiceImp();
		try {
			RoleStudent T=(RoleStudent)ConstantValue.getRole(roleService.getRoleName("0144206"));
			System.out.println(T.PAGE_ERROE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
