package cn.jxufe.util;

import java.io.*;
import java.util.*;

import cn.jxufe.dao.TSchoolDao;

/*import org.apache.log4j.Logger;*/

/**
 * @author Administrator
 *
 */
public class FileName {

/*	String filename= "xxxx.tmp";
	File file = new File(filename);
	String getFilename = file.getFileName();
	String name = getFilename .substring(0,getFilename .lastIndexOf("."));//获取除后缀1位的名称
	//getFilename .substring(getFilename .lastIndexOf("."));//这个是获取后缀名
*/	static String path1 ="D:/Dao";
	static String path2="D:/DaoImp";
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<String> names = getListFiles("src/cn/jxufe/domain", "java", false);
		//创建文件
		for (int i = 0; i < names.size(); i++) {
			String getFilename=new File(names.get(i).trim()).getName();	
			String name1=getFilename.substring(0, getFilename .lastIndexOf("."))+"Dao"+getFilename .substring(getFilename .lastIndexOf("."));
			createFile(path1,name1);
			String templet1;
			
			try {
				templet1="package cn.jxufe.dao;\n"+
			"public interface "+ getFilename.substring(0, getFilename .lastIndexOf("."))+
						"Dao"+" {\n\n}";
				new FileOutputStream(new File(path1+"/" +name1)).write(templet1.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};

			System.out.println(name1);
			String name2=getFilename.substring(0, getFilename .lastIndexOf("."))+
						"DaoImp"+getFilename .substring(getFilename .lastIndexOf("."));
			createFile(path2,name2);
			try {
				//public class TSchoolDaoImp implements TSchoolDao {
				 templet1="package cn.jxufe.daoImp;\n import cn.jxufe.dao."+
				getFilename.substring(0, getFilename .lastIndexOf("."))+"Dao;\n"+
				"import cn.jxufe.domain."+getFilename.substring(0, getFilename .lastIndexOf("."))+";\n"+ 
				
				 "public class "+getFilename.substring(0, getFilename .lastIndexOf("."))+
				"DaoImp"+" implements "+getFilename.substring(0, getFilename .lastIndexOf("."))+
				"Dao"+" {\n\n}";
				new FileOutputStream(new File(path2+"/" +name2)).write(templet1.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
			System.out.println(name2);
		}

	}
	
	// fileName表示你创建的文件名+后缀

	public static void createFile(String path,String fileName){

		//path表示你所创建文件的路径
		File f = new File(path);
		if(!f.exists()){
		f.mkdirs();
		} 
	
		File file = new File(f,fileName);
		if(!file.exists()){
		try {
		file.createNewFile();
		} catch (IOException e) {
		
		e.printStackTrace();
		}
		}

		}
	/**
	 * 读取目录及子目录下指定文件名的路径, 返回一个List
	 */

	/* private static Logger logger = Logger.getLogger(this.class); */

	/**
	 * @param path
	 *            文件路径
	 * @param suffix
	 *            后缀名, 为空则表示所有文件
	 * @param isdepth
	 *            是否遍历子目录
	 * @return list
	 */
	public static List<String> getListFiles(String path, String suffix,
			boolean isdepth) {
		List<String> lstFileNames = new ArrayList<String>();
		File file = new File(path);
		return listFile(lstFileNames, file, suffix, isdepth);
	}

	private static List<String> listFile(List<String> lstFileNames, File f,
			String suffix, boolean isdepth) {
		// 若是目录, 采用递归的方法遍历子目录
		if (f.isDirectory()) {
			File[] t = f.listFiles();

			for (int i = 0; i < t.length; i++) {
				if (isdepth || t[i].isFile()) {
					listFile(lstFileNames, t[i], suffix, isdepth);
				}
			}
		} else {
			String filePath = f.getAbsolutePath();
			if (!suffix.equals("")) {
				int begIndex = filePath.lastIndexOf("."); // 最后一个.(即后缀名前面的.)的索引
				String tempsuffix = "";
				if (begIndex != -1) {
					tempsuffix = filePath.substring(begIndex + 1,
							filePath.length());
					if (tempsuffix.equals(suffix)) {
						lstFileNames.add(filePath);
					}
				}
			} else {
				lstFileNames.add(filePath);
			}
		}
		return lstFileNames;
	}

}
/*
 * 路径中取文件名 // 举例： String fName
 * =" G:\\Java_Source\\navigation_tigra_menu\\demo1\\img\\lev1_arrow.gif ";
 * 
 * // 方法一：
 * 
 * File tempFile =new File( fName.trim());
 * 
 * String fileName = tempFile.getName();
 * 
 * System.out.println("fileName = " + fileName);
 * 
 * // 方法二：
 * 
 * String fName = fName.trim();
 * 
 * String fileName = fName.substring(fName.lastIndexOf("/")+1); //或者 String
 * fileName = fName.substring(fName.lastIndexOf("\\")+1);
 * 
 * System.out.println("fileName = " + fileName);
 * 
 * // 方法三：
 * 
 * String fName = fName.trim();
 * 
 * String temp[] = fName.split("\\\\");
 *//** split里面必须是正则表达式，"\\"的作用是对字符串转义 */
/*
 * 
 * String fileName = temp[temp.length-1];
 * 
 * System.out.println("fileName = " + fileName);
 * 
 * }
 */
