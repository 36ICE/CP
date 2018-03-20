package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.Statement;

import cn.jxufe.dao.TReaTarDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TExcTar;
import cn.jxufe.domain.TReaTar;
public class TReaTarDaoImp implements TReaTarDao {
	private String sql;	
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@Override
	public boolean cheackReaTarId(int reaTarId) throws Exception {
		sql="select * from treatar where reaTarId='"+reaTarId+"';";
		
		
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

	@Override
	public boolean addTReaTar(TReaTar treatar) throws Exception {		
		sql = "INSERT INTO treatar(rProLea,rNonProLea,rExtraLearn,rPhyHealth,rMentalHealth,rManageMoney,eInterpersonal,eClubEvent,eSocialEvent) VALUES('" + 
				treatar.rProLea + "','" + treatar.rNonProLea + "','" +treatar.rExtraLearn + "','" +treatar.rPhyHealth + "','" +
				treatar.rMentalHealth + "','" + treatar.rManageMoney + "','" + treatar.rInterpersonal + "','" +treatar.rClubEvent +"','"+treatar.rSocialEvent+"');";
		System.out.println(sql);

		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			int count=pst.executeUpdate(sql);
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
			//System.out.print("zhixinhasjasjaosjadosaj");
		}		
	}

	@Override
	public boolean addManyTReaTar(Collection<TReaTar> reaTars) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTReaTarByReaTarId(int reaTarId) throws Exception {
		// TODO Auto-generated method stub
		sql = "DELETE FROM treatar WHERE treatar.reaTarId = '" +  reaTarId +"';";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate(sql);
			int count=pst.executeUpdate(sql);
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
	public boolean deleteManyTReaTarByReaTarId(Collection<Integer> reaTarId)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterTReaTarByReaTarId(TReaTar tReaTar) throws Exception {
		// TODO Auto-generated method stub
		 sql="update treatar set eProLea='"+tReaTar.getrProLea()+"',eNonProLea='"+tReaTar.getrNonProLea()+"',eExtraLearn='"+
				 tReaTar.getrExtraLearn()+"',ePhyHealth='"+tReaTar.getrPhyHealth()+"',eMentalHealth='"+tReaTar.getrMentalHealth()+"',eManageMoney='"+
				 tReaTar.getrManageMoney()+"',eInterpersonal='"+tReaTar.getrInterpersonal()+"',eClubEvent='"+
				 tReaTar.getrClubEvent()+"',eSocialEvent='"+tReaTar.getrSocialEvent()+"'where tReaTarId='"+tReaTar.getReaTarId()+"';";	
		System.out.print(sql);
		 pst = null ;  
		conn = null ;
     try{  
  	   conn=DbcpConnection.getConnection();
         pst = DbcpConnection.getConnection().prepareStatement(sql);
         System.out.println("jasja"+sql);
			pst.executeUpdate(sql); 
			return true;
	        } catch (Exception e){  
	            throw new Exception("操作出现异常"+e.toString());
	           // return false;
	        }  
	        finally{  
	        	//pst.close();
	            // 关闭数据库连接  
	            conn.close() ;  
	        } 		
	}

	@SuppressWarnings("null")
	@Override
	public TReaTar findTReaTarByReaTarId(long reaTarId) throws Exception {

		// TODO Auto-generated method stub
		TReaTar treatar=new TReaTar();
		//treatar = new TReaTar();
		sql = "SELECT * FROM treatar WHERE reaTarId = '" +  reaTarId +"';";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();			
			if(rs.next()){
				treatar.reaTarId=rs.getLong("reaTarId");
				treatar.rProLea = rs.getString("rProLea");
				treatar.rNonProLea = rs.getString("rNonProLea");
				treatar.rExtraLearn = rs.getString("rExtraLearn");
				treatar.rPhyHealth = rs.getString("rPhyHealth");
				treatar.rMentalHealth = rs.getString("rMentalHealth");
				treatar.rManageMoney = rs.getString("rManageMoney");
				treatar.rInterpersonal = rs.getString("rInterpersonal");
				treatar.rClubEvent = rs.getString("rClubEvent");
				treatar.rSocialEvent = rs.getString("rSocialEvent");
				treatar.setSubmit(rs.getString("submit"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		return treatar;		
	}

	@Override
	public Collection<TReaTar> findManyTReaTarByReaTarId(
			ArrayList<Integer> reaTarIds) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TReaTar> findmanyTReaTarByReaTarId(
			Collection<Integer> reaTarIds) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addReaTarByNameAndValue(int reaTarId, String name,
			String value) throws Exception {
		sql="insert into reatar(reaTarId,"+name+")values('"+reaTarId+"','"+value+"');";
		

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

	@Override
	public boolean updateByReaTarId(int reaTarId, String name, String value)
			throws Exception {
		sql="update treatar set "+name+"='"+value+"' where reaTarId='"+reaTarId+"';";
		
		
		 try{  
				conn=DbcpConnection.getConnection();
				pst = DbcpConnection.getConnection().prepareStatement(sql);
		
				pst.executeUpdate(sql);
				if(pst.executeUpdate(sql)>0) {
					return true;
				}
				else{
					return false;
				}
					
		        } catch (Exception e){  
		            throw new Exception("操作出现异常"+e.toString()) ;  
		        }  
		        finally{  
		        	//pst.close();
		            // 关闭数据库连接  
		            conn.close() ;  
		        }
	}
	@Override
	public int getTReatarKey(){
		String sql_reaTar=	"insert into treatar(submit)values('fail');";
		try {
			conn=DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql_reaTar,Statement.RETURN_GENERATED_KEYS);
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			
			if (rs.next()) {
			     return rs.getInt(1);
			 }
			conn.close();
		} catch (SQLException e) {
			if(null!=conn){
				try {
					conn.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return -1;
	}
}