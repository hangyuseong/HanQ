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
	      System.out.println("*                ���� ���� ���α׷�              *"); 
	      System.out.println("*                   version 1.0                  *"); 
	      System.out.println("*             excerpt from Java�� ����           *"); 
	      System.out.println("**************************************************"); 
	      System.out.println(); 
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

	            if(menu >= 1 && menu <= 4) { 
	               break; 
	            } else { 
	               throw new Exception(); 
	            } 
	         } catch(Exception e) { 
	            System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. �ٽ� �Է����ּ���."); 
	            System.out.print("���ϴ� �޴��� �����ϼ���.(1~4) : "); 
	         } 
	      } while(true); 

	      return menu; 
	   } 
	   
	   static void inputRecord() { 
	   System.out.println("1. �л����� �Է��ϱ�"); 
	   System.out.println("�̸�,�й�,�����,�����,���м���'�� ������ ������� �Է��ϼ���."); 
	   System.out.println("�Է��� ��ġ���� q�� �Է��ϼ���. ����ȭ������ ���ư��ϴ�."); 
	   
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
	                  
	                  System.out.println("���ԷµǾ����ϴ�. �Է��� ��ġ���� q�� �Է��ϼ���."); 
	                  break; 
	               } else { 
	                  return;                         
	               } 
	            } catch(Exception e) { 
	               System.out.println("�Է¿����Դϴ�. �̸�, �й�, �����, �����, ���м���'�� ������ �Է��ϼ���."); 
	               break; 
	            } 
	         } while(true); } } 
	   
	   
	   static void deleteRecord() { 
	      while(true) { 
	         displayRecord(); 
	         System.out.println("�����ϰ��� �ϴ� �������� �й��� �Է��ϼ���.(q:����ȭ��)"); 
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
	                     System.out.println("�����Ǿ����ϴ�."); 
	                  } else { 
	                     System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�."); 
	                  } 
	                  break; 
	               } else { 
	                  return;                         
	               } 
	            } catch(Exception e) { 
	               System.out.println("�Է¿����Դϴ�. �ٽ� �Է��� �ּ���."); 
	               break; 
	            } 
	         } while(true); 
	      } 
	   } 
	   
	   static void sortRecord() { 
	      while(true) { 
	         System.out.print(" ���ı����� ��Ź�ϼ���.(1:�̸��� 2:������ 3:���θ޴�) : "); 
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
	      System.out.println("�̸� ��ȣ ���� ���� ���� ���� "); 
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
	         System.out.println(" �����Ͱ� �����ϴ�."); 
	         System.out.println(); 
	      } 

	      System.out.println("======================================"); 
	      System.out.println("����: " 
	         + Student2.format(koreanTotal+"", 11, Student2.RIGHT) 
	         + Student2.format(englishTotal+"", 6, Student2.RIGHT) 
	         + Student2.format(mathTotal+"", 6, Student2.RIGHT) 
	         + Student2.format(total+"", 8, Student2.RIGHT) 
	      ); 
	      System.out.println(); 
	   } 
	} 
