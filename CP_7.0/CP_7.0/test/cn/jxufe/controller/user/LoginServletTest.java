package cn.jxufe.controller.user;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.apache.tomcat.util.bcel.classfile.Constant;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.controller.permission.ConstantValue.RoleAdmin;
import cn.jxufe.controller.permission.ConstantValue.RoleStudent;
import cn.jxufe.controller.permission.ConstantValue.RoleTeacher;

@RunWith(Parameterized.class)
public class LoginServletTest {

	private LoginServlet servlet;
	private HttpServletRequest mockRequest;
	private HttpServletResponse mockResponse;
	private RequestDispatcher mockDispatcher;
	private HttpSession mockSession;
	private ServletContext mockServletContent;
	private String userNum;
	private String code;
	private String userName;
	private String role;
	private String shouye;
	private String index;
	
	@Before
	public void setUp() throws Exception {
		//创建mock
		mockRequest  = EasyMock.createMock(HttpServletRequest.class);
		mockResponse = EasyMock.createMock(HttpServletResponse.class);
		mockDispatcher = EasyMock.createMock(RequestDispatcher.class);
		mockSession   = EasyMock.createMock(HttpSession.class);
		servlet = new LoginServlet(){
			private static final long serialVersionUID=1L;
			public ServletContext getServletContent(){
				return mockServletContent;
			}
		};
		
		mockResponse.setCharacterEncoding("utf-8");
		mockResponse.setContentType("text/html;charset=utf-8");
	}

	//构造器
	public LoginServletTest(String userNum,String code,String userName,String role,String shouye,String index) {
		this.userNum=userNum;
		this.code=code;
		this.userName=userName;
		this.role=role;
		this.shouye=shouye;
		this.index=index;

	}
	
	@Parameters
	public static Iterable<Object[]> prepareData(){
		//测试数据
		Object[][] objects={
				{"0144206","123456","曾传东",ConstantValue.ROLE_STUDENT,RoleStudent.PAGE_STUDENT_SHOUYE_JSP,RoleStudent.PAGE_TEMPLETE_INDEX_JSP},
				{"1144206","123456","曾传东",ConstantValue.ROLE_TEACHER,RoleTeacher.PAGE_TEACHER_SHOUYE_JSP,RoleTeacher.PAGE_TEMPLETE_INDEX_JSP},
				{"6144206","123456","曾传东",ConstantValue.ROLE_ADMIN  ,RoleAdmin.PAGE_ADMIN_SHOUYE_JSP    ,RoleAdmin.PAGE_TEMPLETE_INDEX_JSP  }
		};
		return Arrays.asList(objects);
	}
	//情况1：登陆成功
	@Test
	public void testDoGetHTtpServletRequestHttpServletResponse() throws ServletException, IOException{
		//传入参数，设置期望值
		EasyMock.expect(mockRequest.getParameter("userNum")).andReturn(userNum).times(1);
		EasyMock.expect(mockRequest.getParameter("code")).andReturn(code).times(1);
		EasyMock.expect(mockRequest.getSession(true)).andReturn(mockSession);
		mockSession.setAttribute("userNum", userNum);
		mockSession.setAttribute("userName", userName);
		mockSession.setAttribute("roleName", role);
		mockRequest.setAttribute("content", shouye);
		
		EasyMock.expect(mockRequest.getRequestDispatcher(index+"?content="+shouye)).andReturn(mockDispatcher).times(1);
		mockDispatcher.forward(mockRequest, mockResponse);
		
		//回放
		EasyMock.replay(mockRequest);
		EasyMock.replay(mockResponse);
		EasyMock.replay(mockSession);
		EasyMock.replay(mockDispatcher);
		
		
		//调用
		servlet.doGet(mockRequest, mockResponse);
		
		//验证
		EasyMock.verify(mockDispatcher);
	}
	
	//情况2:登陆失败
	@Test
	public void testDoGetFailed() throws ServletException, IOException{
		String userNum="3144206";
		String code="123456";
		
		EasyMock.expect(mockRequest.getParameter("userNum")).andReturn(userNum).times(1);
		EasyMock.expect(mockRequest.getParameter("code")).andReturn(code).times(1);
		
		EasyMock.expect(mockRequest.getRequestDispatcher(ConstantValue.PAGE_LOGIN_ERROE)).andReturn(mockDispatcher).times(1);
		mockDispatcher.forward(mockRequest, mockResponse);
		
		
		EasyMock.replay(mockRequest);
		EasyMock.replay(mockResponse);
		EasyMock.replay(mockDispatcher);
		servlet.doGet(mockRequest,mockResponse);
		EasyMock.verify(mockDispatcher);
	}

}
