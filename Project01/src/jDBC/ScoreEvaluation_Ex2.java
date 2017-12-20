package jDBC;

import java.io.*;
import java.sql.*;
import java.util.*;


public class ScoreEvaluation_Ex2 {
   Connection con = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   static Scanner s = new Scanner(System.in);
   public static void main(String[] args) {

      ScoreEvaluation_Ex2 se2 = new ScoreEvaluation_Ex2();
      ConnectionPool cp = ConnectionPool.getInstance("jdbc:oracle:thin:@192.168.219.139:1521:xe", "scott", "tiger", 5, 10);
      try
      {
         while(true)
         {
            switch (displayMenu()) {
            case 0 :
            	se2.studentMember(cp);
            	break;
            case 1 :
               se2.insertSung(cp);
               break;
            case 2 : 
               se2.deleteSung(cp);
               break;
            case 3 :
               se2.sortRecord(cp);
            case 4 :
               
               break;
            }
         }
      }catch (Exception e) {
         e.printStackTrace();
      }
   }
   static int displayMenu(){ 
      System.out.println("**************************************************"); 
      System.out.println("*                ���� ���� ���α׷�              *"); 
      System.out.println("*                   version 1.0                  *"); 
      System.out.println("*             excerpt from Java�� ����           *"); 
      System.out.println("**************************************************"); 
      System.out.println();
      System.out.println();
      System.out.println("0. �л� ���̺� �����ϱ�");
      System.out.println(); 
      System.out.println(" 1. �л����� �Է��ϱ� "); 
      System.out.println(); 
      System.out.println(" 2. �л����� �����ϱ� "); 
      System.out.println(); 
      System.out.println(" 3. �л����� �����Ͽ�����(�̸���, ������) "); 
      System.out.println(); 
      System.out.println(" 4. ���α׷� ���� "); 
      System.out.println(); 
      System.out.println(); 
      System.out.print("���ϴ� �޴��� �����ϼ���.(1~4) : "); 

      int menu = 0; 

      do { 
         try { 
            menu = Integer.parseInt(s.nextLine());

            if(menu >= 0 && menu <= 4) { 
               break; 
            } else { 
               throw new Exception(); 
            } 
         } catch(Exception e) { 
            //System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. �ٽ� �Է����ּ���."); 
            //System.out.print("���ϴ� �޴��� �����ϼ���.(1~4) : "); 
         } 
      } while(true); 

      return menu; 
   }
   //���� �Է�
   public void studentMember(ConnectionPool cp) throws SQLException
   {
      String sql = "create table sung_student(name varchar2(20), hakbun varchar2(20), kor number(4), eng number(4),"
            + "mat number(4), tot number(4))";

      con = cp.getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.executeUpdate();

      if(con != null)
      {
         cp.releaseConnection(con);
         //
      }
   }


   public void insertSung(ConnectionPool cp) throws IOException, SQLException
   {
      System.out.println("1. �л����� �Է��ϱ�"); 
      System.out.println("�̸�,�й�,�����,�����,���м���'�� ������ ������� �Է��ϼ���."); 
      System.out.println("�Է��� ��ġ���� q�� �Է��ϼ���. ����ȭ������ ���ư��ϴ�."); 
      //String input = s.nextLine().trim();
      do
      {
         try
         {
            String input = s.nextLine().trim();
            if(!input.equalsIgnoreCase("q"))
            {
               input = null;
               String name = s.next();
               String hakbun = s.next();
               int kor = s.nextInt();
               int eng = s.nextInt();
               int mat = s.nextInt();
               int tot = (kor+eng+mat);

               con = cp.getConnection();
               pstmt = con.prepareStatement("insert into sung_student values(?,?,?,?,?,?)");
               pstmt.setString(1, name);
               pstmt.setString(2, hakbun);
               pstmt.setInt(3, kor);
               pstmt.setInt(4, eng);
               pstmt.setInt(5, mat);
               pstmt.setInt(6, tot);

               int i = pstmt.executeUpdate();
               //String input = sc.nextLine().trim();

               if(i != 0)
               {
                  System.out.println("���ԷµǾ����ϴ�. �Է��� ��ġ���� q�� �Է��ϼ���.");
                  input = s.nextLine().trim();
                  
               }else
               {
                  System.out.println("�����Է� ���� ");
               }
            }else
            {
               System.out.println("����ȭ������ ���ư��ϴ�.");
               return;
            }
            //break;
         }catch (Exception e) {
            System.out.println("�Է� ����");
            return;
         }
         finally {
            if(con != null)
            {
               cp.releaseConnection(con);
               pstmtClose(pstmt);
            }
         }
      }while(true);
   }

   public void deleteSung(ConnectionPool cp) throws IOException, SQLException
   {
      System.out.println("�����ϰ��� �ϴ� �������� �й��� �Է��ϼ���.(q:����ȭ��)"); 
      // String name = s.next();
      String hakbun = s.next();
      boolean flag = true;
      do
      {
         try
         {
            con = cp.getConnection();
            pstmt = con.prepareStatement("delete from sung_student where hakbun = ?");
            //pstmt.setString(1, name);
            pstmt.setString(1, hakbun);

            int i = pstmt.executeUpdate();
            if(i != 0)
            {
               System.out.println("���� ���� ����");

            }else
            {
               System.out.println("���� ����");
            }
         }catch (Exception e) {

            e.printStackTrace();
         }
         finally {
            if(con != null)
            {
               cp.releaseConnection(con);
               pstmtClose(pstmt);
               break;
            }
         }

      }while(true);   
   }

   public void sortRecord(ConnectionPool cp) throws IOException, SQLException
   {
      while(true)
      {
         System.out.print(" ���ı����� ��Ź�ϼ���.(1:�̸��� 2:������ 3:���θ޴�) : ");
         try
         {
         int sort = 0;
         do { 
            try { 
               sort = Integer.parseInt(s.nextLine());

               if(sort >= 1 && sort <= 3) { 
                  break; 
               } else { 
                  throw new Exception(); 
               } 
            } catch(Exception e) { 
               System.out.println("��ȿ���� ���� �Է°��Դϴ�. �ٽ� �Է����ּ���."); 
               System.out.print(" ���ı����� ��Ź�ϼ���.(1:�̸��� 2:������ 3:���θ޴�) : "); 
            } 
         } while(true); 
         //System.out.println(sort); 1

         
            if(sort == 1)
            {
               String name = s.nextLine();
               //String hakbun = s.nextLine();
               //int tot = s.nextInt();

               con = cp.getConnection();
               pstmt = con.prepareStatement("select * from sung_student order by name desc");
//               pstmt.setString(1, name);
               rs = pstmt.executeQuery();

               if(rs.next())
               {
                  System.out.println("���ĿϷ�");
               }else
               {
                  System.out.println("���ڵ� �� ����");
               }
            }
         }finally {
            if(con != null)
            {
               cp.releaseConnection(con);
               rsClose(rs);
            }
         }
      }
   }


   /*public void endSung(ConnectionPool cp) throws IOException, SQLException
   {
      
   }*/
   
   public void pstmtClose(PreparedStatement stmt) 
   {
      if(stmt != null)
      {
         try
         {
            stmt.close();
         }catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   public void rsClose(ResultSet rs)
   {
      if(rs != null)
      {
         try
         {
            rs.close();
         }catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
}