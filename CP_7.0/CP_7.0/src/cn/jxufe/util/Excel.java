package cn.jxufe.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cn.jxufe.domain.ventity.VStudent;
import jxl.Sheet;
import jxl.Workbook;

public class Excel {
	 public List add(File file){
	  List ls=new ArrayList();
	  Workbook rwb=null;
	  try {
	   InputStream is=new FileInputStream(file);//读取文件
	   rwb=Workbook.getWorkbook(is);
	   Sheet rs=rwb.getSheet(0);
	   
	   int rsRows=rs.getRows();
	   int rsClos=rs.getColumns();
	   System.out.println("总行："+rsRows);
	   System.out.println("总列："+rsClos);
	//因为excel的第一行一般都是实体类的属性。所以从i从1开始取，这样就直接能读取数据了
	   for(int i=1;i<rsRows;i++){
		    String cell2=rs.getCell(1, i).getContents()+"";//取得第一列，第二行数据
		    String cell3=rs.getCell(2, i).getContents()+"";//取得第二列，第二行数据。以此类推
		    String cell4=rs.getCell(3, i).getContents()+"";
		    String cell5=rs.getCell(4, i).getContents()+"";
		    String cell6=rs.getCell(5, i).getContents()+"";
		    System.out.println(cell2+cell3+cell3+cell4+cell5+cell6);
		    
		  //接下来就是把从excel读取到的内容逐个set到Student对象中。然后将对象添加到集合。
		    if(cell2!=null&&!cell2.equals("")){
		     VStudent student =new VStudent();
		     try {
		      student.setUserNum(rs.getCell(1, i).getContents());
		      student.setUserName(rs.getCell(2, i).getContents());
		      student.setUnitName(rs.getCell(3, i).getContents());
		      student.setDepartName(rs.getCell(4,i).getContents());
		      student.setSchoolName(rs.getCell(5,i).getContents());
		      ls.add(student);
		     } catch (Exception e) {
		      e.printStackTrace();
		      System.out.println("数字转换异常");
		     }
		    }
	   }
	  } catch (Exception e) {
	   e.printStackTrace();
	  }finally{
	   rwb.close();
	  }
	  return ls;
	 }
	}