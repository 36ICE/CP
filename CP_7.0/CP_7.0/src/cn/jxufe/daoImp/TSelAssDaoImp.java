package cn.jxufe.daoImp;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

//import com.mysql.jdbc.PreparedStatement;







import cn.jxufe.dao.TSelAssDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TJobAss;
import cn.jxufe.domain.TSelAss;
import cn.jxufe.domain.TUser;
public class TSelAssDaoImp implements TSelAssDao {

	private String sql;
	private TSelAss tSelAss;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	
	@Override
	public boolean checkUserId(int userId) throws Exception {
	sql="select * from tselass where userId='"+userId+"';";
		
	
		
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
	
		return false;
	}
	
//	public void setTUser(long userId){
//		sql = "SELECT * FROM tuser WHERE tuser.userId = '" + userId +"';";
//		
//		try {
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	@Override
	public boolean addSelAss(TSelAss tSelAss) throws Exception {
		
		sql = "INSERT INTO tselass(userId,chater,speciality,interest,emotionSituation,willPower,english,computer) VALUES('" + 
						tSelAss.tUser.userId + "','" + tSelAss.chater + "','" +tSelAss.speciality + "','" +tSelAss.interest + "','" +
						tSelAss.emotionSituation + "','" + tSelAss.willpower + "','" + tSelAss.english + "','" +tSelAss.computer +"');";
		System.out.println(sql);
		
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			try {
				if(pst!=null) pst.close();
				if(conn!=null &&!conn.isClosed()) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public boolean addJobAssByNameAndValue(int userId,String name,String value)throws Exception{
		
		sql="insert into tselass(userId,"+name+")values('"+userId+"','"+value+"');";
		
		System.out.println();
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			if(pst.executeUpdate(sql)>0);
				return true;			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally{
			try {
				if(pst!=null) pst.close();
				if(conn!=null &&!conn.isClosed()) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}
	
	/*public static void main(String args[]) throws Exception{
		
		TUser user = new TUser();
		user.setUserId(3);
		user.setUserNum("12345");
		TSelAssDao dao = new TSelAssDaoImp();
		TSelAss tSelAss = new TSelAss(user,"8","8","8","8","8","8","3");
		dao.updateSelAss(tSelAss);
		//dao.deleteSelAss("6144206");
		int count = dao.getCount();
		System.out.println(dao.getCount());
		
	}*/
	@Override
	public boolean deleteSelAss(TUser tUser) throws Exception {
		sql = "DELETE FROM tselass WHERE tselass.userId = '" +  tUser.getUserId() +"';";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			try {
				if(pst!=null) pst.close();
				if(conn!=null &&!conn.isClosed()) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean deleteSelAss(String userNum) throws Exception {
		sql = "DELETE FROM tselass WHERE tselass.userId IN" + "(SELECT userId FROM tuser WHERE tuser.userNum = '" + userNum +"');";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			try {
				if(pst!=null) pst.close();
				if(conn!=null &&!conn.isClosed()) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	@Override
	public boolean deleteManySelAss(Collection<TUser> tUsers) throws Exception {
		for(int i = 0; i<tUsers.size(); i++)
		{
			TUser user = tUsers.iterator().next();
			deleteSelAss(user);
		}
		return false;
	
	}

	@Override
	public void alterSelAss(TUser tUser, TSelAss tSelAss) throws Exception {
		//deleteSelAss(tUser);
		//addSelAss(tSelAss);
	}

	@Override
	public TSelAss findByUser(TUser tUser) throws Exception {
		tSelAss = null;
		sql = "SELECT * FROM tselass WHERE tselass.userId = '" +  tUser.getUserId() +"';";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				tSelAss.chater = rs.getString("chater");
				tSelAss.computer = rs.getString("computer");
				tSelAss.emotionSituation = rs.getString("emotionSituation");
				tSelAss.english = rs.getString("english");
				tSelAss.interest = rs.getString("interest");
				tSelAss.speciality = rs.getString("speciality");
				tSelAss.tUser = tUser;
				tSelAss.willpower = rs.getString("willpower");
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		return tSelAss;	
	}

	@Override
	public TSelAss findByUserNum(String userNum) throws Exception {
//		tSelAss = new TSelAss();
		TUser tuser =null;
		String sql2 = "SELECT * FROM tuser WHERE tuser.userNum = '" + userNum +"';";
//		sql = "SELECT * FROM tselass WHERE tselass.userId IN" + "(SELECT userId FROM tuser WHERE tuser.userNum = '" + userNum +"');";
		System.out.println(sql2);
//		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql2);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				tuser.setUserId(rs.getInt("userId"));
				tuser.setCode(rs.getString("code"));
				tuser.setUserName(rs.getString("userName"));
				tuser.setUserNum(rs.getString("userNum"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		
		return findByUser(tuser);
//		return tSelAss;	
	}
	@Override
	public TSelAss findByUserId(int userId) throws Exception {
		TSelAss tSelAss=new TSelAss();
		String sql = "SELECT * FROM tselass WHERE userId = '" + userId +"';";

		System.out.println(sql);

		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				tSelAss.setChater(rs.getString("chater"));
				tSelAss.setComputer(rs.getString("computer"));
				tSelAss.setEmotionSituation(rs.getString("emotionSituation"));
				tSelAss.setEnglish(rs.getString("english"));
				tSelAss.setInterest(rs.getString("interest"));
				tSelAss.setSelAssId(rs.getLong("selAssId"));
				tSelAss.setSpeciality(rs.getString("speciality"));
				tSelAss.setWillpower(rs.getString("willpower"));
				tSelAss.setSubmit(rs.getString("submit"));
				
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		
		return tSelAss;
	}
	@Override
	public int getCount() throws Exception {
		sql = "SELECT COUNT(*) FROM tselass";
		int count = 0;
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		return count;
	}
	
	 public boolean updateSelAss(TSelAss tSelAss) throws Exception { 
         /*sql = "UPDATE tSelAss set chater= ? ,speciality=?,interest=?,emotionSituation=?,willPower=?,"
        		 	+"english=?,computer=? WHERE userId=?";  	            
		*/
		 sql="update tselass set chater='"+tSelAss.getChater()+"',speciality='"+tSelAss.getSpeciality()+"',interest='"+
				tSelAss.getInterest()+"',emotionSituation='"+tSelAss.getEmotionSituation()+"',willPower='"+tSelAss.getWillpower()+"',english='"+
				 tSelAss.getEnglish()+"',computer='"+tSelAss.getComputer()+"' where userId='"+tSelAss.getTUser().getUserId()+"';";
         
	        pst = null ;  
	        conn = null ;
        try{  
           conn=DbcpConnection.getConnection();
            //String sql = "UPDATE tSelAss SET chater=?,speciality=?,interest=?,emotionSituation=?,willPower=?,english=?,computer=? where selAssId=?";  	            
            pst = DbcpConnection.getConnection().prepareStatement(sql);
            /*pst.setString(1,tSelAss.getChater());  
            pst.setString(2,tSelAss.getSpeciality()); 
            pst.setString(3,tSelAss.getInterest()); 
            pst.setString(4,tSelAss.getEmotionSituation()); 
            pst.setString(5,tSelAss.getWillpower()); 
            pst.setString(6,tSelAss.getEnglish()); 
            pst.setString(7,tSelAss.getComputer());  
            pst.setLong(8,tSelAss.getTUser().getUserId()); */
            System.out.println("jasja"+sql);
			pst.executeUpdate(sql); 
			return true; 
	        } catch (Exception e){  
	            throw new Exception("操作出现异常"+e.toString()) ;
	            //return false;
	        }  
	        finally{  
	        	//pst.close();
	            // 关闭数据库连接  
	            conn.close() ;  
	        } 
	 }

	@Override
	public boolean updateByUserIdAndValue(int userId, String name, String value)
			throws Exception {
		sql="update tselass set "+name+"='"+value+"' where userid='"+userId+"';";
		pst = null ;  
		conn = null ;
       try{  
			conn=DbcpConnection.getConnection();
			pst = DbcpConnection.getConnection().prepareStatement(sql);
			//System.out.println("jasja"+sql);
			
			pst.executeUpdate(sql);
			if(pst.executeUpdate(sql)>0) {
				return true;
			}
			else{
				return false;
			}
				
	        } catch (Exception e){  
	            throw new Exception("出现异常"+e.toString()) ;  
	        }  
	        finally{  
	        	//pst.close();
	            // 关闭数据库连接  
	            conn.close() ;  
	        }
		
	}

}