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
      System.out.println("*                성적 관리 프로그램              *"); 
      System.out.println("*                   version 1.0                  *"); 
      System.out.println("*             excerpt from Java의 정석           *"); 
      System.out.println("**************************************************"); 
      System.out.println();
      System.out.println();
      System.out.println("0. 학생 테이블 생성하기");
      System.out.println(); 
      System.out.println(" 1. 학생성적 입력하기 "); 
      System.out.println(); 
      System.out.println(" 2. 학생성적 삭제하기 "); 
      System.out.println(); 
      System.out.println(" 3. 학생성적 정렬하여보기(이름순, 성적순) "); 
      System.out.println(); 
      System.out.println(" 4. 프로그램 종료 "); 
      System.out.println(); 
      System.out.println(); 
      System.out.print("원하는 메뉴를 선택하세요.(1~4) : "); 

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
            //System.out.println("메뉴를 잘못 선택하셨습니다. 다시 입력해주세요."); 
            //System.out.print("원하는 메뉴를 선택하세요.(1~4) : "); 
         } 
      } while(true); 

      return menu; 
   }
   //성적 입력
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
      System.out.println("1. 학생성적 입력하기"); 
      System.out.println("이름,학번,국어성적,영어성적,수학성적'의 순서로 공백없이 입력하세요."); 
      System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다."); 
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
                  System.out.println("잘입력되었습니다. 입력을 마치려면 q를 입력하세요.");
                  input = s.nextLine().trim();
                  
               }else
               {
                  System.out.println("성적입력 실패 ");
               }
            }else
            {
               System.out.println("메인화면으로 돌아갑니다.");
               return;
            }
            //break;
         }catch (Exception e) {
            System.out.println("입력 오류");
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
      System.out.println("삭제하고자 하는 데이터의 학번을 입력하세요.(q:메인화면)"); 
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
               System.out.println("성적 삭제 성공");

            }else
            {
               System.out.println("삭제 실패");
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
         System.out.print(" 정렬기준을 선탁하세요.(1:이름순 2:총점순 3:메인메뉴) : ");
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
               System.out.println("유효하지 않은 입력값입니다. 다시 입력해주세요."); 
               System.out.print(" 정렬기준을 선탁하세요.(1:이름순 2:총점순 3:메인메뉴) : "); 
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
                  System.out.println("정렬완료");
               }else
               {
                  System.out.println("레코드 값 없음");
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