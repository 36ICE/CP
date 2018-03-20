package cn.jxufe.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jxufe.domain.TUser;
import cn.jxufe.exception.ErrNameException;
import cn.jxufe.exception.ErrPwdException;



public class testdbcp {

	DbcpConnection dbcpcon = new DbcpConnection();  
    static Connection conn = null;  
    static PreparedStatement pst = null;  
    static ResultSet rs = null;  
    static String ZLJGBM="" ;  
      
      
    //通过A机构编码获得B机构代码  
    public static void getZLJGBMFromDRJGBM(){  
        String sql = "select * from tuser";  
        try {  
            conn = DbcpConnection.getConnection();  
            pst = conn.prepareStatement(sql);  
            rs = pst.executeQuery();  
            while(rs.next()){  
            	//第个一输出null，如果写ZLJGBM = null相加的时候
            	//if(ZLJGBM==null){
            	//	ZLJGBM = rs.getString(1);
            	//}else{
            		ZLJGBM =ZLJGBM+ rs.getString(1);
            	//}
                ZLJGBM =ZLJGBM+ rs.getString(2);
                ZLJGBM =ZLJGBM+ rs.getString(3);
                ZLJGBM =ZLJGBM+ rs.getString(4);
                ZLJGBM =ZLJGBM+ rs.getString(5);
                ZLJGBM=ZLJGBM+"\n";
            }  
            System.out.println(ZLJGBM);  
              
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
	
	public static void main(String[] args) {
		//getZLJGBMFromDRJGBM();
		login();
	}
	@SuppressWarnings("null")
	public static void login(){
		
		TUser user = new TUser();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//DbUtil dbUtil = null;
		String sql ="select * from tuser where userNum=?";
	
			//dbUtil = new DbUtil();
			String code="123";
			try {
				pstmt=DbcpConnection.getConnection().prepareStatement(sql);
				pstmt.setString(1, "6144206");
				rs = pstmt.executeQuery();
				System.out.println(sql);
				
				if(rs.next()) {
					if(!code.equals(rs.getString("code"))) {
						throw new ErrPwdException("密码不正确！！");
					}else {
						//登录成功
						user.setEmail(rs.getString("email"));
						
					System.out.println("登录成功"+"6144206");
					}
				}else {
					throw new ErrNameException("用户名不存在！！");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	


}
