package jDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAO_Ex.ConnectionPool;

public class Service {
	 static  ConnectionPool cp =null;
	 
	  public static Connection conn() {
		   try {
			   
			   cp =cp.getInstance("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger", 5, 10);
			   con = cp.getConnection();
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   return con;
	   }
	  static Connection con = conn(); // 싱글턴
	  
	   public static void start() { 
	      while(true) { 
	         switch(ScoreEvaluation.displayMenu()) { 
	            case 1 : 
	            	ScoreEvaluation.inputRecord(); 
	               break; 
	            case 2 : 
	            	ScoreEvaluation.deleteRecord(); 
	               break; 
	            case 3 : 
	            	ScoreEvaluation.sortRecord(); 
	               break; 
	            case 4 : 
	               System.out.println("프로그램을 종료합니다.");
	               cp.closeAll();
	               System.exit(0);
	         } 
	      }
	   }
	   
	   //추가
	   public static void insert(Student2 st) {
		   PreparedStatement pstmt =null;
		   try {
			   int total = st.getEnglishScore()+st.getKoreanScore()+st.getMathScore();
			   pstmt = con.prepareStatement("insert into studentgrade values (?,?,?,?,?,?)");
			   pstmt.setString(1, st.getName());
			   pstmt.setString(2, st.getStudentNo());
			   pstmt.setInt(3, st.getKoreanScore());
			   pstmt.setInt(4, st.getEnglishScore());
			   pstmt.setInt(5, st.getMathScore());
			   pstmt.setInt(6, total);
			   pstmt.executeUpdate();
			   
		   }catch(Exception e) {
			   System.out.println("이미있는 학번");
		   }
		   
	   }
	   //삭제
	   public static void delete(String st) {
		   PreparedStatement pstmt =null;
		   try {
			   pstmt = con.prepareStatement("delete from studentgrade where studentno=? ");
			   pstmt.setString(1, st);
			   pstmt.executeUpdate();
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   
	   }
	   // 데이터베이스 에서 가져오기
	   public static ArrayList save() {
		   PreparedStatement pstmt =null;
		   ResultSet rs = null;
		   Student2 stu= null;
		   ArrayList list = new ArrayList();
		   try {
			   pstmt = con.prepareStatement("select * from studentgrade");
			   rs = pstmt.executeQuery();
			   while(rs.next()) {
				   stu = new Student2(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
				   stu.setName(rs.getString(1));
				   stu.setStudentNo(rs.getString(2));
				   stu.setKoreanScore(rs.getInt(3));
				   stu.setEnglishScore(rs.getInt(4));
				   stu.setMathScore(rs.getInt(5));
				   stu.setTotal(rs.getInt(6));
				   list.add(stu);
			   }
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   return list;
	   }

	   //이름순정렬
	   public static void orderName(ArrayList record) {
		   PreparedStatement pstmt =null;
		   ResultSet rs = null;
		   Student2 stu= null;
		   try {
			   pstmt = con.prepareStatement("select *from studentgrade order by name");
			   rs =pstmt.executeQuery();
			   record.clear();
			   while(rs.next()) {
				   stu = new Student2(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
				   stu.setName(rs.getString(1));
				   stu.setStudentNo(rs.getString(2));
				   stu.setKoreanScore(rs.getInt(3));
				   stu.setEnglishScore(rs.getInt(4));
				   stu.setMathScore(rs.getInt(5));
				   stu.setTotal(rs.getInt(6));
				   record.add(stu);
				   
			   }
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   
	   }
	   
	   //토탈순정렬
	   public static void orderTotal(ArrayList record) {
		   PreparedStatement pstmt =null;
		   ResultSet rs = null;
		   Student2 stu= null;
		   try {
			   pstmt = con.prepareStatement("select *from studentgrade order by total desc");
			   rs =pstmt.executeQuery();
			   record.clear();
			   while(rs.next()) {
				   stu = new Student2(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
				   stu.setName(rs.getString(1));
				   stu.setStudentNo(rs.getString(2));
				   stu.setKoreanScore(rs.getInt(3));
				   stu.setEnglishScore(rs.getInt(4));
				   stu.setMathScore(rs.getInt(5));
				   stu.setTotal(rs.getInt(6));
				   record.add(stu);
				   
			   }
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
	   }
}
