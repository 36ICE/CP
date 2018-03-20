package cn.jxufe.db;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbcpConnection {
	private static DataSource dataSource;
	//private static Connection connection;
	
	public static void initDataSource(){
		FileInputStream is = null;
		Properties properties = new Properties();
		
		String driverClassName = null;
		String url = null;
		String username = null;
		String password = null;
		
		int initialSize = 0;
		int minIdle = 0;
		int maxIdle = 0;
		int maxWait = 0;
		int maxActive = 0;
		
		try {
			String path = "";
			path = System.getProperty("user.dir")+"\\";
			//path =Class.class.getClass().getResource("/").getPath();
			//String path=DbcpConnection.class.getResource("/").getFile().toString();
			//System.out.println("System.getPropertyuser.dir"+System.getProperty("user.dir"));
			//System.out.println("Class.class.getClass().getResource+"+Class.class.getClass().getResource("/").getPath());
			//path="G:\\two\\比赛\\计算机作品\\参考文档\\源码\\备份吧\\CP_ALL\\CP_7.0\\CP_7.0\\WebRoot\\";
			System.out.print(path);
			is = new FileInputStream( "C:\\dbcp.properties");
			properties.load(is);
			
			driverClassName = properties.getProperty("dbcp.driverClassName");
			url = properties.getProperty("dbcp.url");
			username = properties.getProperty("dbcp.username");
			password = properties.getProperty("dbcp.password");
			initialSize = Integer.parseInt((properties.getProperty("dbcp.initialSize").trim()));
			minIdle = Integer.parseInt((properties.getProperty("dbcp.minIdle")).trim());
			maxIdle = Integer.parseInt((properties.getProperty("dbcp.maxIdle")).trim());
			maxWait = Integer.parseInt((properties.getProperty("dbcp.maxWait")).trim());
			maxActive = Integer.parseInt((properties.getProperty("dbcp.maxActive")).trim());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe){
			ioe.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		BasicDataSource bds = new BasicDataSource();
		
		bds.setUrl(url);
		bds.setDriverClassName(driverClassName);
		bds.setUsername(username);
		bds.setPassword(password);
		bds.setInitialSize(initialSize);
		//老版本使用下面
		//bds.setMaxActive(maxActive);
		bds.setMaxTotal(maxActive);
		bds.setMinIdle(minIdle);
		bds.setMaxIdle(maxIdle);
		//老版本
		//bds.setMaxWait(maxWait);
		bds.setMaxWaitMillis(maxWait);
		
		dataSource = bds;
	}
	
	public static Connection  getConnection() throws  SQLException {
        if (dataSource == null) {   
        	initDataSource();   
        }   
        Connection conn = null;   
        if (dataSource != null) {   
            conn = dataSource.getConnection();   
        }   
        return conn;   
	}
	/**
	 * 释放资源（重载的方式）
	 */
	public static void release(Connection conn,Statement stmt){
		if(conn != null){
			try {
				// 归还的方法
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
	}

	/**
	 * 释放资源
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void release(Connection conn,Statement stmt,ResultSet rs){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
}
