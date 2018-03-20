package cn.jxufe.filter;



import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/** 
 * 编码过滤器 
 *  
 * @author xy 
 *  
 */  
public class EncodingFilter implements Filter  
{  
    private String encoding;  
  
    public void init(FilterConfig fConfig) throws ServletException  
    {  
        encoding = fConfig.getInitParameter("encoding");  
    }  
  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException  
    {  
        HttpServletRequest httprequest = (HttpServletRequest) request;  
        if ("GET".equals(httprequest.getMethod()))  
        {  
            // 将httpRequest进行包装  
            EncodingHttpServletRequest wrapper = new EncodingHttpServletRequest(httprequest, encoding);   
            chain.doFilter(wrapper, response);  
        }  
        else  
        {  
            request.setCharacterEncoding(encoding);  
            response.setContentType("text/html;charset=" + encoding);  
            chain.doFilter(request, response);  
        }  
    }  
  
    public void destroy()  
    {  
  
    }  
  
}  
/*public class EncodingFilter implements Filter {
    private String encoding;  
    private Map<String, String> params = new HashMap<String, String>();  
    // 项目结束时就已经进行销毁  
    public void destroy() {  
        //System.out.println("end do the encoding filter!");  
        params=null;  
        encoding=null;  
    }  
    public void doFilter(ServletRequest req, ServletResponse resp,  
            FilterChain chain) throws IOException, ServletException {  
        
        req.setCharacterEncoding(encoding);  
       
         resp.setContentType("text/html;charset="+encoding);  
        chain.doFilter(req, resp);        
     
    }  
   
    // 项目启动时就已经进行读取  
    public void init(FilterConfig config) throws ServletException {  
        
        encoding = config.getInitParameter("encoding");  
        for (Enumeration e = config.getInitParameterNames(); e  
                .hasMoreElements();) {  
            String name = (String) e.nextElement();  
            String value = config.getInitParameter(name);  
            params.put(name, value);  
        }  
    } 
}*/
