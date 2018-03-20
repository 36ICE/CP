package cn.jxufe.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;


public class FilterTestServlet extends HttpServlet{  
	   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 
     * 查看httpservlet实现的service一看便知，起到了一个controll控制器的作用(转向的) 
     * 之后便是跳转至我们熟悉的doget,dopost等方法中  
     */  
    @Override  
    protected void service(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        System.out.println("doservice..."+this.getInitParameter("encoding"));  
          
        super.service(req, resp);  
    }  
   
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        System.out.println("doget...");  
        doPost(req, resp);  
    }  
   
    @Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        System.out.println("dopost...");  
    }  
      
      
   
 }  