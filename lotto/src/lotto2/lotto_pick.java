package lotto2;

import java.util.Scanner;

class Lotto{
	Scanner sc = new Scanner(System.in);
	int number[] = new int[6];//정해진 로또번호
	int user[] = new int[6];//사용자가 고른 로또 번호
	//int total_number = (int) (Math.random()*45 +1);//전체 로또번호 생성
	int bonus = (int) (Math.random()*45) + 1;// 45까지 생성
	int d1 =0,d2 =0,d3 =0,d4 =0,d5 =0;
	int score = 0;
	int bonusscore = 0;
	int cnt = 0;


 	public void lottoNum()//로또 번호 생성 중복 비교
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
 			System.out.println("1등 당첨입니다.");
 			this.d1 ++;
 		}else if(this.score == 8 && bonusscore == 2)
 		{
 			System.out.println("2등 당첨입니다.");
 			this.d2 ++;
 		}else if(this.score == 10)
 		{
 			System.out.println("3등 당첨입니다.");
 			this.d3 ++;
 		}else if(this.score == 8)
 		{
 			System.out.println("4등 당첨입니다.");
 			this.d4 ++;
 		}else if(this.score == 6)
 		{
 			System.out.println("5등 당첨입니다.");
 			this.d5 ++;
 		}else
 		{
 			System.out.println("당첨되지 않았습니다.");
 		}
 	}
 	
 	public void resultPrint() 
 	{
 		System.out.println("1등 \t 2등 \t 3등 \t 4등 \t 5등");
 		System.out.println(d1+"\t"+ d2 +"\t" + d3+"\t"+ d4 +"\t" +d5);
 		System.out.println("총 횟수 : " + this.cnt);
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
 			System.out.print("로또번호는 : ");
 			lotto.userPrint();
 			System.out.println();
 			lotto.lottoRank();
 			System.out.println();
 			lotto.cnt++;
 			}
 			lotto.resultPrint();
	}
}
