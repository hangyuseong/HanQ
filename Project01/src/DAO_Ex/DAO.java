package DAO_Ex;
import java.util.*;
import java.sql.*;


public class DAO {
   
   static//����̹� �ε� �ѹ��� ���� 
   {
      try
      {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      }catch (ClassNotFoundException cnfe) {
         cnfe.printStackTrace();
      }
   }
   private DAO()
   {
      
   }
   private static DAO obj;
   public static DAO getInstance() {
      if(obj == null)
      {
         obj = new DAO();
      }
      return obj;
   }
   
   private Connection conn;
   private Statement stmt;
   private ResultSet rs;
   //PreparedStatement
   
   
   private boolean connect()
   {
      boolean result = false;
      try
      {
         conn = DriverManager.getConnection("jdbc:oracle:thin:@172.30.1.53:1521:xe", "scott", "tiger");
         
         result = true;
      }catch (Exception e) {
           System.out.println("���� ���� : " + e.getMessage());
      }
      return result;
   }
   
   private void close()
   {
      try
      {
         if(rs != null)
         {
            rs.close();
         }
         if(stmt != null)
         {
            stmt.close();
         }
         if(conn != null)
         {
            conn.close();
         }
      }catch (Exception e) {
            System.out.println("���� ���� : " + e.getMessage());
      }
   }
   public List<Good> getList()
   {
      List<Good> list = null;
      
      String sql = "select * from goods";
      
      if(connect())
      {
         try
         {
            stmt = conn.createStatement();
            if(stmt != null)
            {
               rs = stmt.executeQuery(sql);
               
                list = new ArrayList<Good>();
                 

                 while(rs.next()){
                  Good goods = new Good();
                  
                  goods.setCode(rs.getString("code"));
                  goods.setName(rs.getString("name"));
                  goods.setManufacture(rs.getString("manufacture"));
                  goods.setPrice(rs.getInt("price"));
                  goods.setMakingdate(rs.getDate("makingdate"));

                  list.add(goods);
                 }
                }
               } catch (SQLException e) {
                e.printStackTrace();
               }
      }else
      {
         System.out.println("�����ͺ��̽��� ������ �����߽��ϴ�.");
         System.exit(0);
      }
      
      return list;
   }
   
   public boolean InsertGood(Good good)
   {
	   boolean result = false;
	   
	   if(this.connect())
	   {
		
		   try
		   {
			   String sql = "insert into goods values(?,?,?,?,?)";
			   
			   PreparedStatement pstmt = conn.prepareStatement(sql);
		   
			   pstmt.setString(1, good.getCode());
			   pstmt.setString(2, good.getName());
			   pstmt.setString(3, good.getManufacture());
			   pstmt.setInt(4, good.getPrice());
			   pstmt.setDate(5, good.getMakingdate());
			   
			   int rs = pstmt.executeUpdate();
			   
			   if(rs>0)
			   {
				   result = true;
			   }
			   pstmt.close();
			   this.close();
		   }catch (Exception e) {
			   e.printStackTrace();
		}
	   }else
	   {
		   System.out.println("�����ͺ��̽��� ���� ����");
		   System.exit(0);
	   }
	   return result;
   }
   
   
}