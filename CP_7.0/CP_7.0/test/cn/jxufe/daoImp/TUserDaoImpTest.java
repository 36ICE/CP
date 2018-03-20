package cn.jxufe.daoImp;

import static org.junit.Assert.*;
import cn.jxufe.domain.TUser;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;




@RunWith(Parameterized.class)
public class TUserDaoImpTest {

	private TUserDaoImp tUserDaoImp;
	private static TUser tUser;
	private String userNum;
	private String code;
	private Boolean expected;


	@Before
	public void setUp() throws Exception {

		tUserDaoImp = new TUserDaoImp();
		tUser = new TUser();
	}
	
	public  TUserDaoImpTest(Boolean expected,String userNum, String code) {
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
	public void checkUserNumAndCodeTest() throws Exception {
		System.out.println(expected+userNum+code);
		Assert.assertEquals(expected,tUserDaoImp.checkUserNumAndCode(userNum, code, tUser));
		
	}

}
