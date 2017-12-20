package jDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



class ScoreEvaluation { 
	   static ArrayList record = Service.save(); 
	   static Scanner s = new Scanner(System.in);

	   static int displayMenu(){ 
	      System.out.println("**************************************************"); 
	      System.out.println("*                성적 관리 프로그램              *"); 
	      System.out.println("*                   version 1.0                  *"); 
	      System.out.println("*             excerpt from Java의 정석           *"); 
	      System.out.println("**************************************************"); 
	      System.out.println(); 
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

	            if(menu >= 1 && menu <= 4) { 
	               break; 
	            } else { 
	               throw new Exception(); 
	            } 
	         } catch(Exception e) { 
	            System.out.println("메뉴를 잘못 선택하셨습니다. 다시 입력해주세요."); 
	            System.out.print("원하는 메뉴를 선택하세요.(1~4) : "); 
	         } 
	      } while(true); 

	      return menu; 
	   } 
	   
	   static void inputRecord() { 
	   System.out.println("1. 학생성적 입력하기"); 
	   System.out.println("이름,학번,국어성적,영어성적,수학성적'의 순서로 공백없이 입력하세요."); 
	   System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다."); 
	   
	      while(true) { 
	         System.out.print(">>"); 
	         do { 
	            try { 
	               String input = s.nextLine().trim(); 
	               if(!input.equalsIgnoreCase("q")) { 
	                  Scanner s2 = new Scanner(input).useDelimiter(","); 
	                  Student2 st =new Student2(s2.next(), s2.next(), s2.nextInt() , s2.nextInt(), s2.nextInt());
	                  record.add(st);
	                  Service.insert(st);
	                  
	                  System.out.println("잘입력되었습니다. 입력을 마치려면 q를 입력하세요."); 
	                  break; 
	               } else { 
	                  return;                         
	               } 
	            } catch(Exception e) { 
	               System.out.println("입력오류입니다. 이름, 학번, 국어성적, 영어성적, 수학성적'의 순서로 입력하세요."); 
	               break; 
	            } 
	         } while(true); } } 
	   
	   
	   static void deleteRecord() { 
	      while(true) { 
	         displayRecord(); 
	         System.out.println("삭제하고자 하는 데이터의 학번을 입력하세요.(q:메인화면)"); 
	         System.out.print(">>"); 

	         do { 
	            try { 
	               String input = s.nextLine().trim(); 

	               if(!input.equalsIgnoreCase("q")) { 
	                  int length = record.size(); 
	                  boolean found = false; 

	                  for(int i=0; i < length; i++) { 
	                     Student2 student = (Student2)record.get(i); 
	                     if(input.equals(student.studentNo)) { 
	                        found = true; 
	                        Service.delete(input);
	                        record.remove(i); 
	                        break; 
	                     } 
	                  } 

	                  if(found) { 
	                     System.out.println("삭제되었습니다."); 
	                  } else { 
	                     System.out.println("일치하는 데이터가 없습니다."); 
	                  } 
	                  break; 
	               } else { 
	                  return;                         
	               } 
	            } catch(Exception e) { 
	               System.out.println("입력오류입니다. 다시 입력해 주세요."); 
	               break; 
	            } 
	         } while(true); 
	      } 
	   } 
	   
	   static void sortRecord() { 
	      while(true) { 
	         System.out.print(" 정렬기준을 선탁하세요.(1:이름순 2:총점순 3:메인메뉴) : "); 
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

	         if(sort==1) { 
	            Service.orderName(record);             
	            displayRecord(); 
	         } else if(sort==2) { 
	            Service.orderTotal(record);
	            displayRecord(); 
	         } else { 
	            return;             
	         } 
	      } 
	   } 

	  
	   static void displayRecord() { 
	      int koreanTotal = 0; 
	      int englishTotal = 0; 
	      int mathTotal = 0; 
	      int total = 0; 

	      System.out.println(); 
	      System.out.println("이름 번호 국어 영어 수학 총점 "); 
	      System.out.println("======================================"); 

	      int length = record.size(); 

	      if(length > 0) { 
	         for (int i = 0; i < length ; i++) { 
	            Student2 student = (Student2)record.get(i); 
	            System.out.println(student); 
	            koreanTotal += student.koreanScore; 
	            mathTotal += student.mathScore; 
	            englishTotal += student.englishScore; 
	            total += student.total; 
	         } 
	      } else { 
	         System.out.println(); 
	         System.out.println(" 데이터가 없습니다."); 
	         System.out.println(); 
	      } 

	      System.out.println("======================================"); 
	      System.out.println("총점: " 
	         + Student2.format(koreanTotal+"", 11, Student2.RIGHT) 
	         + Student2.format(englishTotal+"", 6, Student2.RIGHT) 
	         + Student2.format(mathTotal+"", 6, Student2.RIGHT) 
	         + Student2.format(total+"", 8, Student2.RIGHT) 
	      ); 
	      System.out.println(); 
	   } 
	} 
