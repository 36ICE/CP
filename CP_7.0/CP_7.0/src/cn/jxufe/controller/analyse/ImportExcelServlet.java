package cn.jxufe.controller.analyse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

//import org.apache.tomcat.util.http.fileupload.FileItemFactory;
//import org.apache.tomcat.util.http.fileupload.RequestContext;
//import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
//import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.controller.permission.ConstantValue.RoleStudent;
import cn.jxufe.dao.VStudentDao;
import cn.jxufe.daoImp.VStudentDaoImp;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.ventity.VStudent;
import cn.jxufe.service.user.VStudentService;
import cn.jxufe.serviceImp.user.VStudentServiceImp;
import cn.jxufe.util.Excel;

public class ImportExcelServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("请以POST方式上传文件");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session;
		session = req.getSession(true);

		DiskFileItemFactory factory = new DiskFileItemFactory();
		@SuppressWarnings("deprecation")
		String path = req.getRealPath("/upload");// 设置磁盘缓冲路径
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);// 设置创建缓冲大小

		// RequestContext ctx = new ServletRequestContext(req);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(-1);// 设置上传文件限制大小,-1无上限

		String filename = "";

		try {

			@SuppressWarnings("unchecked")
			List<FileItem> list = upload.parseRequest(req);
			String va = null;
			for (FileItem item : list) {
				if (item.isFormField()) {// 判断是否是文件流
					va = item.getString("UTF-8");
				} else {
					String value = item.getName();// 会将完整路径名传过来
					int start = value.lastIndexOf("\\");
					filename = value.substring(start + 1);

					InputStream in = item.getInputStream();
					// UploadDomain dao = new UploadDomain();
					// item.write(new File(realPath,fileName));
					int index = filename.lastIndexOf(".");
					String realFileName = filename.substring(0, index);

					String userNum = (String) session.getAttribute("userNum");
					VStudentService studentService = new VStudentServiceImp();
					Excel ex = new Excel();
					path = path + "\\" + filename;

					File file = new File(path);
					item.write(file);
					// upokFile.add(file);
					// state= true;

					List ls = ex.add(file);
					Iterator it = ls.iterator();
					while (it.hasNext()) {
						VStudent student = (VStudent) it.next();
						// 调用dao层方法，将数据插入到数据库中
						try {
							if (studentService.addStudent(student, userNum)) {
								System.out.println("成功");
							} else {
								System.out.println("失败");
							}
						} catch (Exception e) {

							e.printStackTrace();
						}
					}

					req.setAttribute("content", "success.jsp");
					req.getRequestDispatcher(
							RoleStudent.PAGE_TEMPLETE_INDEX_JSP
									+ "?content="
									+ ConstantValue.RoleStudent.PAGE_STUDENT_NOTOPEN_JSP)
							.forward(req, resp);
				}

			}
		} catch (Exception e) {
			//e.printStackTrace();
			req.getRequestDispatcher(ConstantValue.PAGE_ERROE).forward(req, resp);
		}

	}
}

// String path = req.getSession().getServletContext().getRealPath("/");//得到路径
// path+=new String
// (req.getParameter("filename").getBytes("ISO8859-1"),"gbk");//取得文件名
// String filename=req.getParameter("excel");
// System.out.println(filename);
// path+=new String (req.getParameter("excel"));//取得文件名
// String path=new String
// (request.getParameter("excel").getBytes("ISO8859-1"),"UTF-8");
// System.out.println("路径"+path);
