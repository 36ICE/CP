package AllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cn.jxufe.controller.user.LoginServletTest;
import cn.jxufe.daoImp.TUserDaoImpTest;
import cn.jxufe.serviceImp.user.TUserServiceImpTest;

@RunWith(Suite.class)
@SuiteClasses({
	LoginServletTest.class,
	TUserDaoImpTest.class,
	TUserServiceImpTest.class
	
})
public class LoginTest {

}
