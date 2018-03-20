package cn.jxufe.controller.user;

/* Junit EasyMock的应用分为5步
 * 1. 使用 EasyMock 生成 Mock 对象;
 * 		  如果想对一个类（而非接口）生成mock对象，需要EasyMock Class Extension
 * 			SomeInterface mockObj = createMock(SomeInterface.class); 
 * 		  如果是一个相对复杂的测试用例，需要对多个接口生成mock对象，使用MockControl来管理
 * 			IMocksControl control = createControl();  
 * 			SomeInterface mockObj = control.createMock(SomeInterface.class);  
 * 			AnotherInterface mockAnotherObj = control.createMock(AnotherInterface.class);
 * 2. 设定 Mock 对象的预期行为和输出;
 *        expect(mockObj.someAction(1)).andReturn("one"); 
 *        如果是一个返回void的方法调用：
 *        mockObj.noReturnValueAction();  
 *        expectLastCall();   // 最新版本的EasyMock可以忽略此句  
 * 3. 将 Mock 对象切换到 Replay 状态；
 * 		 replay(mockObj);  
 * 		 对于使用control来管理的情况：control.replay();  
 * 4. 调用 Mock 对象方法进行单元测试
 *        fakeInvoke(mockObj); 
 * 5.对 Mock 对象的行为进行验证
 * 		verify(mockObj);  
 * 		   对于使用control来管理的情况：control.verify();  
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.easymock.*;

import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.controller.permission.ConstantValue.RoleAdmin;
import cn.jxufe.controller.permission.ConstantValue.RoleStudent;
import cn.jxufe.controller.permission.ConstantValue.RoleTeacher;
import cn.jxufe.domain.TUser;
import cn.jxufe.service.permission.RoleService;
import cn.jxufe.service.user.TUserService;
import cn.jxufe.serviceImp.permission.RoleServiceImp;
import cn.jxufe.serviceImp.user.TUserServiceImp;

@RunWith(Parameterized.class)
public class LoginServletTest1 {

	private LoginServlet servlet;
	private HttpServletRequest mockRequest;
	private HttpServletResponse mockResponse;
	private ServletContext mockServletContext;
	private RequestDispatcher mockDispathcher;
	private HttpSession mockSession; 
	private String userNum;
	private String code;
	private String userName;
	private String role;
	private String shouye;
	private String index;
	
	@Before
	public void setUp() throws Exception {
		//创建mockrequest和mockresponse等的Mock 
		mockRequest = EasyMock.createMock(HttpServletRequest.class);
		mockResponse = EasyMock.createMock(HttpServletResponse.class);
		mockServletContext = EasyMock.createMock(ServletContext.class);  
        mockDispathcher = EasyMock.createMock(RequestDispatcher.class);  
        mockSession = EasyMock.createStrictMock(HttpSession.class); 
        servlet = new LoginServlet(){
			private static final long serialVersionUID = 1L;  
            public ServletContext getServletContext() {  
                return mockServletContext;  
            }  
		};
		mockResponse.setCharacterEncoding("utf-8");
		mockResponse.setContentType("text/html;charset=utf-8");
	}
	public  LoginServletTest1(String userNum, String code,String userName,String role,String shouye,String index) {
		// 构造方法
		// JUnit会使用准备的测试数据传给构造函数
		this.userNum = userNum;
		this.code = code;
		this.userName=userName;
		this.role=role;
		this.shouye=shouye;
		this.index=index;
	}

	@Parameters(name = "{index}: ({0},{1},{2},{3})")
	public static Iterable<Object[]> prepareData() {
		// 测试数据
		Object[][] objects = {  
			{ "0144206", "123456","曾传东",ConstantValue.ROLE_STUDENT ,RoleStudent.PAGE_STUDENT_SHOUYE_JSP,RoleStudent.PAGE_TEMPLETE_INDEX_JSP}  ,
			{ "1144206", "123456","曾传东" ,ConstantValue.ROLE_TEACHER,RoleTeacher.PAGE_TEACHER_SHOUYE_JSP,RoleTeacher.PAGE_TEMPLETE_INDEX_JSP}, 
			{ "6144206", "123456" ,"曾传东" ,ConstantValue.ROLE_ADMIN,RoleAdmin.PAGE_ADMIN_SHOUYE_JSP,RoleAdmin.PAGE_TEMPLETE_INDEX_JSP},
		};
		return Arrays.asList(objects);// 将数组转换成集合返回
	}
	//情况1：登陆失败
	   @Test  
	    public void testDoGetHttpServletRequestHttpServletResponse() throws Exception {
		   //传入参数 ，设置期望值
		    EasyMock.expect(mockRequest.getParameter("userNum")).andReturn(userNum).times(1);
			EasyMock.expect(mockRequest.getParameter("code")).andReturn(code).times(1);
			EasyMock.expect(mockRequest.getSession(true)).andReturn(mockSession).times(1);
			
			mockSession.setAttribute("userNum", userNum);
			EasyMock.expectLastCall().times(1); 
			
			mockSession.setAttribute("userName" , userName);
			EasyMock.expectLastCall().times(1); 
			
			mockSession.setAttribute("roleName",role);
			EasyMock.expectLastCall().times(1); 
			
			mockRequest.setAttribute("content",shouye);
			EasyMock.expectLastCall().times(1); 
			
	        EasyMock.expect(mockRequest.getRequestDispatcher(index+"?content="+shouye)).andReturn(mockDispathcher).times(1);  
	        mockDispathcher.forward(mockRequest, mockResponse);  
	        //回放  
		    EasyMock.replay(mockRequest);
			EasyMock.replay(mockResponse);
			EasyMock.replay(mockSession);
			EasyMock.replay(mockDispathcher);
			//调用
	        servlet.doGet(mockRequest, mockResponse); 
	        //验证  
	        EasyMock.verify(mockDispathcher);  
	    } 
	 
	  //情况2：登陆失败
	@Test
	public void testDoGetFailed()throws ServletException,IOException{
		String userNum = "3144206";
		String code    = "123456";
		EasyMock.expect(mockRequest.getParameter("userNum")).andReturn(userNum).times(1);
		EasyMock.expect(mockRequest.getParameter("code")).andReturn(code).times(1);
		

        EasyMock.expect(mockRequest.getRequestDispatcher(ConstantValue.PAGE_LOGIN_ERROE)).andReturn(mockDispathcher).times(1);  
        mockDispathcher.forward(mockRequest, mockResponse);  
        
	    EasyMock.replay(mockRequest);
		EasyMock.replay(mockResponse);
		EasyMock.replay(mockDispathcher);
        servlet.doGet(mockRequest, mockResponse);  
        EasyMock.verify(mockDispathcher); 
	}

}
