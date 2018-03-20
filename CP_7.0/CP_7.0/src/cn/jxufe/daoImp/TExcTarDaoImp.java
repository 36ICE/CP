package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.Statement;

import cn.jxufe.dao.TExcTarDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TExcTar;
//学期规划表
 public class TExcTarDaoImp implements TExcTarDao {	 
	private String sql;
	
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@Override
	public boolean cheackExcTarId(int excTarId) throws Exception {	
		sql="select * from texctar where excTarId='"+excTarId+"';";
		
	
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
	public boolean addTExcTar(TExcTar texcTar) throws Exception {
		// TODO Auto-generated method stub		
		sql = "INSERT INTO texctar(eProLea,eNonProLea,eExtraLearn,ePhyHealth,eMentalHealth,eManageMoney,eInterpersonal,eClubEvent,eSocialEvent) VALUES('" + 
				 texcTar.eProLea + "','" + texcTar.eNonProLea + "','" +texcTar.eExtraLearn + "','" +texcTar.ePhyHealth + "','" +
				texcTar.eMentalHealth + "','" + texcTar.eManageMoney + "','" + texcTar.eInterpersonal + "','" +texcTar.eClubEvent +"','"+texcTar.eSocialEvent+"');";
		System.out.println(sql);

		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			int count=pst.executeUpdate(sql);
			if(count>0)return true;
			else return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pst!=null) pst.close();
				if(conn!=null &&!conn.isClosed()) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			//System.out.print("zhixinhasjasjaosjadosaj");
		}		
		return false;
	}

	@Override
	public boolean addManyTExcTar(Collection<TExcTar> exctars) throws Exception {
		// TODO Auto-generated method stub	
		/*int i=0;
		for(; i<exctars.size(); i++)
		{
			TExcTar tExcTar = exctars.iterator().next();
			deleteTExcTarByExcTarId(tExcTar.getExcTarId());
		}
		if(i==0)return false;
		else return true;*/
		return false;
	}

	@Override
	public boolean deleteTExcTarByExcTarId(long excTarId) throws Exception {
		// TODO Auto-generated method stub
		sql = "DELETE FROM texctar WHERE texctar.excTarId = '" +  excTarId +"';";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate(sql);
			int count=pst.executeUpdate(sql);
			if(count>0)return true;
			else return false;
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
	public boolean deleteManyTExceTarByExcTarId(Collection<Integer> excTarId)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterTExcTarByExcTarId(TExcTar excTar) throws Exception {
		// TODO Auto-generated method stub
		 sql="update texcTar set eProLea='"+excTar.geteProLea()+"',eNonProLea='"+excTar.geteNonProLea()+"',eExtraLearn='"+
				 excTar.geteExtraLearn()+"',ePhyHealth='"+excTar.getePhyHealth()+"',eMentalHealth='"+excTar.geteMentalHealth()+"',eManageMoney='"+
				 excTar.geteManageMoney()+"',eInterpersonal='"+excTar.geteInterpersonal()+"',eClubEvent='"+
				 excTar.geteClubEvent()+"',eSocialEvent='"+excTar.geteSocialEvent()+"'where excTarId='"+excTar.getExcTarId()+"';";	
		System.out.print(sql);
		 pst = null ;  
		conn = null ;
       try{  
    	   conn=DbcpConnection.getConnection();
           pst = DbcpConnection.getConnection().prepareStatement(sql);
           System.out.println("jasja"+sql);
			pst.executeUpdate(sql);              

	        } catch (Exception e){  
	            throw new Exception("操作出现异常"+e.toString()) ;  
	        }  
	        finally{  
	        	//pst.close();
	            // 关闭数据库连接  
	            conn.close() ;  
	        } 		
		return false;
	}

	@Override
	public TExcTar findTExcTarByExcTarId(long excTarId) throws Exception {
		// TODO Auto-generated method stub
		TExcTar texcTar;
		texcTar = new TExcTar();
		sql = "SELECT * FROM texctar WHERE texcTar.excTarId = '" +  excTarId +"';";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				texcTar.seteProLea(rs.getString("eProLea"));
				texcTar.seteNonProLea ( rs.getString("eNonProLea"));
				texcTar.seteExtraLearn ( rs.getString("eExtraLearn"));
				texcTar.setePhyHealth (rs.getString("ePhyHealth"));
				texcTar.seteMentalHealth( rs.getString("eMentalHealth"));
				texcTar.seteManageMoney ( rs.getString("eManageMoney"));
				texcTar.seteInterpersonal( rs.getString("eInterpersonal"));
				texcTar.seteClubEvent (rs.getString("eClubEvent"));
				texcTar.seteSocialEvent( rs.getString("eSocialEvent"));
				texcTar.setSubmit(rs.getString("submit"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		return texcTar;	
	}

	@Override
	public Collection<TExcTar> findManyTExcTarByExcTarId(
			ArrayList<Integer> excTarIds) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TExcTar> findmanyTExcTarByExcTarId(
			Collection<Integer> excTarIds) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addExcTarByNameAndValue(int excTarId, String name,
			String value) throws Exception {
		sql="insert into texctar(excTarId,"+name+")values('"+excTarId+"','"+value+"');";
		

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
	public boolean updateByExcTarId(int excTarId, String name, String value)
			throws Exception {
		sql="update texctar set "+name+"='"+value+"' where excTarId='"+excTarId+"';";
		System.out.println(sql);
		 try{  
				conn=DbcpConnection.getConnection();
				pst = conn.prepareStatement(sql);
			
				pst.executeUpdate(sql);
				if(pst.executeUpdate(sql)>0) {
					return true;
				}
				else{
					return false;
				}
					
		        } catch (Exception e){  
		           e.printStackTrace();
		        }  
		        finally{  
		        	
		            conn.close() ;  
		        }
		 return false;
	}

	@Override
	public int getTExctarKey(){
		String sql_excTar=	"insert into texctar(submit)values('fail');";
		try {
			conn=DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql_excTar,Statement.RETURN_GENERATED_KEYS);
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			
			if (rs.next()) {
			     return rs.getInt(1);
			 }
			conn.close();
		} catch (SQLException e) {
			if(null != conn){
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