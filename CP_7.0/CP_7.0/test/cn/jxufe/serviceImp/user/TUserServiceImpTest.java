package cn.jxufe.serviceImp.user;



import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cn.jxufe.domain.TUser;
@RunWith(Parameterized.class)
public class TUserServiceImpTest {

	private String userNum;
	private String code;
	private Boolean expected;
	private TUserServiceImp tUserServiceImp;
	private static TUser tUser;
	@Before
	public void setUp() throws Exception {
		tUserServiceImp=new TUserServiceImp();
		tUser = new TUser();
	}

	public  TUserServiceImpTest(Boolean expected,String userNum, String code) {
		// 构造方法
		// JUnit会使用准备的测试数据传给构造函数
		this.expected=expected;
		this.userNum = userNum;
		this.code = code;
		
	}

	@Parameters(name = "{index}: ({1},{2},{0})")
	public static Iterable<Object[]> prepareData() {
		// 测试数据
		Object[][] objects = {  { true,"0144206", "123456" }  ,
				{ true,"1144206", "123456" }, 
				{ false,"2144206", "123456" }};
		return Arrays.asList(objects);// 将数组转换成集合返回

	}
	@Test
	public void loginTest() throws Exception{
		Assert.assertEquals(expected,tUserServiceImp.Login(userNum, code, tUser));
	}
}
