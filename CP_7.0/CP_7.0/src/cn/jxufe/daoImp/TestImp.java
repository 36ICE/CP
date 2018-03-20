package cn.jxufe.daoImp;

public class TestImp {

	public static void main(String[] args) {
		//测试TuserDaoImp
		testfindAllByUserNum();
		
		//测试其他
		//...........
	}
	
	private static void testfindAllByUserNum(){
		
		TUserDaoImp tUserDaoImp=new TUserDaoImp();
		try {
			System.out.println("测试TuserDaoImp：\ntestfindAllByUserNum start:");
			String tUserNum="6144206";
			System.out.println("输出："+tUserDaoImp.findAllByUserNum(tUserNum).toString());
			System.out.println("========= test end=======\n");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
