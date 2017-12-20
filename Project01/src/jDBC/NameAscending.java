package jDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;

class NameAscending {} 
	//DTO
	class Student2 implements Comparable { 
	   final static int LEFT = 0; 
	   final static int CENTER = 1; 
	   final static int RIGHT = 2; 

	   
	   int koreanScore = 0; 
	   int mathScore = 0; 
	   int englishScore = 0; 
	   int total = 0; 
	   String name = ""; 
	   String studentNo = ""; 
	   public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	   Student2(String name, String studentNo, int koreanScore, int mathScore, int englishScore) { 
	      this.name = name; 
	      this.studentNo = studentNo; 
	      this.koreanScore = koreanScore; 
	      this.mathScore = mathScore; 
	      this.englishScore = englishScore; 
	      total = koreanScore + mathScore + englishScore; 
	   } 

	   public String toString() { 
	      return format(name, 4, LEFT) 
	         + format(studentNo, 4, RIGHT) 
	         + format(""+koreanScore,6, RIGHT) 
	         + format(""+mathScore,6, RIGHT) 
	         + format(""+englishScore, 6, RIGHT) 
	         + format(""+total,8, RIGHT); 
	   } 

	   static String format(String str, int length, int alignment) { 
	      int diff = length - str.length(); 
	      if(diff < 0) return str.substring(0, length); 

	      char[] source = str.toCharArray(); 
	      char[] result = new char[length]; 

	      // 배열 result를 공백으로 채운다. 
	      for(int i=0; i < result.length; i++) 
	         result[i] = ' '; 

	      switch(alignment) { 
	         case CENTER : 
	            System.arraycopy(source, 0, result, diff/2, source.length); 
	            break; 
	         case RIGHT : 
	            System.arraycopy(source, 0, result, diff, source.length); 
	            break; 
	         case LEFT : 
	         default : 
	            System.arraycopy(source, 0, result, 0, source.length); 
	      } 
	      return new String(result); 
	   } // static String format(String str, int length, int alignment) { 

	   public int compareTo(Object obj) { 
	      int result = -1; 
	      if(obj instanceof Student2) { 
	         Student2 tmp = (Student2)obj; 
	         result = (this.name).compareTo(tmp.name); 
	      } 
	      return result; 
	   } 
	} // class Student2 implements Comparable { 

