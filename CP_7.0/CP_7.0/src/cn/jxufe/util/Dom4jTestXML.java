package cn.jxufe.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
public class Dom4jTestXML {
	/**
	 * 
	 * 方法描述：读取XML文件示例 备 注: </br> 创 建 人: bo.gaobo</br> 修改日期: @2013-8-20</br>
	 */
	public static void readXML() {
		SAXReader sr = new SAXReader();// 获取读取xml的对象。

		Document doc;
	
			try {
				doc = sr.read("Webroot/page/xml/Row.xml");
				// 得到xml所在位置。然后开始读取。并将数据放入doc中
				Element el_root = doc.getRootElement();// 向外取数据，获取xml的根节点。
				// System.out.println("根节点：" + el_root.getName());
				Iterator it = el_root.elementIterator();// 从根节点下依次遍历，获取根节点下所有子节点
				while (it.hasNext()) {// 遍历子节点
					Object o = it.next();
					Element el_row = (Element) o;
					String str = el_row.getText();
					Iterator it_row = el_row.elementIterator();
					while (it_row.hasNext()) {
						Element el_ename = (Element) it_row.next();
						System.out.println(el_ename.getName() + "="+ el_ename.getData());
					}
				}
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	/**
	  * 
	  * 方法描述：写入XML文件并存储 备 注: </br> 
	  * 创 建 人: bo.gaobo</br> 
	  * 修改日期: @2013-8-20</br>
	  */

	 public static  void writeToXML() {
	  Row row1 =new Row();
	  row1.setCo("co_1");
	  row1.setComm("comm_1");
	  row1.setDepno("depno_1");
	  row1.setEmpno("empno_1");
	  row1.setEname("ename_1");
	  row1.setMgr("mgr_1");
	  row1.setHiredate("2012-03-29");
	  row1.setJob("job_1");
	  row1.setSal("sal_1");

	  Document document = DocumentHelper.createDocument();
	  Element root = document.addElement("ROWDATA");
	  Element row = root.addElement("ROW");
	  row.addElement("CO").addText(row1.getCo());
	  row.addElement("EMPNO").addText(row1.getEmpno());
	  row.addElement("ENAME").addText(row1.getEname());
	  row.addElement("JOB").addText(row1.getJob());
	  row.addElement("MGR").addText(row1.getMgr());
	  row.addElement("HIREDATE").addText(row1.getHiredate());
	  row.addElement("SAL").addText(row1.getSal());
	  row.addElement("COMM").addText(row1.getComm());
	  row.addElement("DEPTNO").addText(row1.getDepno());

	  String filePath = "D:/xmlTest/" + getNowDay() + "/";
	  String fileName = "row1.xml";
	  
	  String xmlStr = "";
	  xmlStr = document.asXML();
	  try {
	   Document dcmt = DocumentHelper.parseText(xmlStr);
	   saveDocumentToFile(dcmt, filePath, fileName, true, "UTF-8");
	  } catch (DocumentException e) {
	   e.printStackTrace();
	  }
	  
	  

	 }

	 public static String getNowDay() {
	  SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	  return format.format(new Date());
	 }

	 /**
	  * 方法描述：<b>存储完整XML文件.</b></br> 
	  * 备 注: </br> 
	  * 创 建 人: zyl</br> 
	  * 创建日期:2013-3-18</br>
	  * 
	  * @param document
	  * @param xmlFilePath
	  * @param xmlFileName
	  * @param isTrimText
	  * @param xmlEncoding
	  */
	 public static void saveDocumentToFile(Document document,
	   String xmlFilePath, String xmlFileName, boolean isTrimText,
	   String xmlEncoding) {
	  if (document == null || xmlFilePath == null || "".equals(xmlFileName)) {
	   return;
	  }

	  File file = new File(xmlFilePath);
	  // 判断路径是否存在，不存在创建
	  if (!file.exists()) {
	   file.mkdirs();
	  }
	  // 保存文件
	  OutputFormat format = null;

	  if (isTrimText) {
	   format = OutputFormat.createPrettyPrint();
	  } else {
	   format = DomXmlOutputFormat.createPrettyPrint();// 保留xml属性值中的回车换行
	  }

	  if (xmlEncoding != null) {
	   format.setEncoding(xmlEncoding);// GBK
	  } else {
	   format.setEncoding("UTF-8");// UTF-8
	  }

	  try {
	   org.dom4j.io.XMLWriter xmlWriter = new org.dom4j.io.XMLWriter(
	     new FileOutputStream(xmlFilePath + xmlFileName), format);// FileOutputStream可以使UTF-8生效
	   xmlWriter.write(document);
	   xmlWriter.close();
	  } catch (IOException e) {
	   System.out.println("保存XML异常：" + e.getMessage());
	   System.out.println("正在保存的文件名是：" + xmlFileName);
	  }
	  // 存到文件中结束
	 }

	 public static void main(String args[]) {
	  readXML();
	 // writeToXML();
	 }

	 }
class Row {

	 private String co;
	 private String empno;
	 private String ename;
	 private String job;
	 private String mgr;
	 private String hiredate;
	 private String sal;
	 private String comm;
	 private String depno;

	 public String getCo() {
	  return co;
	 }

	 public void setCo(String co) {
	  this.co = co;
	 }

	 public String getEmpno() {
	  return empno;
	 }

	 public void setEmpno(String empno) {
	  this.empno = empno;
	 }

	 public String getEname() {
	  return ename;
	 }

	 public void setEname(String ename) {
	  this.ename = ename;
	 }

	 public String getJob() {
	  return job;
	 }

	 public void setJob(String job) {
	  this.job = job;
	 }

	 public String getHiredate() {
	  return hiredate;
	 }

	 public void setHiredate(String hiredate) {
	  this.hiredate = hiredate;
	 }

	 public String getSal() {
	  return sal;
	 }

	 public void setSal(String sal) {
	  this.sal = sal;
	 }

	 public String getComm() {
	  return comm;
	 }

	 public void setComm(String comm) {
	  this.comm = comm;
	 }

	 public String getDepno() {
	  return depno;
	 }

	 public void setDepno(String depno) {
	  this.depno = depno;
	 }

	 public String getMgr() {
	  return mgr;
	 }

	 public void setMgr(String mgr) {
	  this.mgr = mgr;
	 }
	}
