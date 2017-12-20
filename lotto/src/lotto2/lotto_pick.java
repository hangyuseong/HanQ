package lotto2;

import java.util.Scanner;

class Lotto{
	Scanner sc = new Scanner(System.in);
	int number[] = new int[6];//������ �ζǹ�ȣ
	int user[] = new int[6];//����ڰ� �� �ζ� ��ȣ
	//int total_number = (int) (Math.random()*45 +1);//��ü �ζǹ�ȣ ����
	int bonus = (int) (Math.random()*45) + 1;// 45���� ����
	int d1 =0,d2 =0,d3 =0,d4 =0,d5 =0;
	int score = 0;
	int bonusscore = 0;
	int cnt = 0;


 	public void lottoNum()//�ζ� ��ȣ ���� �ߺ� ��
 	{
 		for(int i = 0;i<number.length;i++)
 		{
 			number[i] =(int) Math.random()*45+1;
 			for(int j = 0;j<i;j++)
 			{
 				if(number[i]==number[j] || number[i] == bonus)
 				{
 					i--;
 				}
 			}
 		}
 	}
 	
 	public void userNum()
 	{
 		for(int i = 0;i<user.length;i++)
 		{
 			user[i] = (int) Math.random()*45+1;
 			for(int j = 0;j<i;j++)
 			{
 				if(number[i]==user[j])
 				{
 					i--;
 				}
 			}
 		}
 	}
 	public void lottoPrint()
 	{
 		for(int i = 0;i<number.length;i++)
 		{
 			System.out.println(number[i]+ "");
 		}
 	}
 	public void userPrint()
 	{
 		for(int i = 0;i<user.length;i++)
 		{
 			System.out.println(user[i] +"");
 		}
 	}
 	
 	public void lottoResult()
 	{
 		for(int i = 0;i<number.length;i++)
 		{
 			for(int j = i;j<i+1;j++)
 			{
 				if(user[i]==number[j])
 				{
 					score += 2;
 				}else if(user[i]==bonus)
 				{
 					bonusscore += 2;
 				}
 			}
 		}
 	}
 	
 	public void lottoRank()
 	{
 		if(this.score ==12)
 		{
 			System.out.println("1�� ��÷�Դϴ�.");
 			this.d1 ++;
 		}else if(this.score == 8 && bonusscore == 2)
 		{
 			System.out.println("2�� ��÷�Դϴ�.");
 			this.d2 ++;
 		}else if(this.score == 10)
 		{
 			System.out.println("3�� ��÷�Դϴ�.");
 			this.d3 ++;
 		}else if(this.score == 8)
 		{
 			System.out.println("4�� ��÷�Դϴ�.");
 			this.d4 ++;
 		}else if(this.score == 6)
 		{
 			System.out.println("5�� ��÷�Դϴ�.");
 			this.d5 ++;
 		}else
 		{
 			System.out.println("��÷���� �ʾҽ��ϴ�.");
 		}
 	}
 	
 	public void resultPrint() 
 	{
 		System.out.println("1�� \t 2�� \t 3�� \t 4�� \t 5��");
 		System.out.println(d1+"\t"+ d2 +"\t" + d3+"\t"+ d4 +"\t" +d5);
 		System.out.println("�� Ƚ�� : " + this.cnt);
 	}
}
 	public class lotto_pick {
 		
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
 			Scanner sc = new Scanner(System.in);
 			Lotto lotto = new Lotto();
 			
 			lotto.lottoNum();
 			while(lotto.d1 != 1)
 			{
 			lotto.userNum();
 			System.out.print("�ζǹ�ȣ�� : ");
 			lotto.userPrint();
 			System.out.println();
 			lotto.lottoRank();
 			System.out.println();
 			lotto.cnt++;
 			}
 			lotto.resultPrint();
	}
}
