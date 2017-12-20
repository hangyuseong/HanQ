package lotto;

import java.util.Scanner;

class Lotto
{
	Scanner sc = new Scanner(System.in);

	int lottoNum[] = new int[6];
	int userNum[] = new int[6];
	int bonus = (int) (Math.random()*45)+1;
	int score = 0;
	int bonusScore = 0;
	int cnt = 0;
	int d1=0,d2=0,d3=0,d4=0,d5=0;
	
	public void lottoNum()
	{
		for(int i = 0;i<lottoNum.length;i++)
		{
			lottoNum[i] = (int) (Math.random()*45)+1;
			for(int j = 0;j<i;j++)
			{
				if(lottoNum[i]==lottoNum[j]|| lottoNum[i]==bonus)
				{
					i--;
				}
			}
		}
	}
	
	
	public void userNum()
	{
		for(int i = 0; i<userNum.length;i++)
		{
			userNum[i] = (int) (Math.random()*45)+1;
			for(int j = 0;j<i;j++)
			{
				if(userNum[i]==userNum[j])
				{
					i--;
				}
			}
		}
	}
	
	public void lottoPrint()
	{
		for(int i = 0;i<lottoNum.length;i++)
		{
			System.out.println(lottoNum[i] + " ");
		}
	}
	
	public void userPrint()
	{
		for(int i = 0;i<userNum.length;i++)
		{
			System.out.println(userNum[i] + "");
		}
	}
	
	
	public void lottoResult()
	{
		for(int i = 0;i<lottoNum.length;i++)
		{
			for(int j=i;j<i+1;j++)
			{
				if(userNum[i]==lottoNum[j])
				{
					score +=2;
				}else if(userNum[i]==bonus)
				{
					bonusScore +=2;
				}
			}
		}
	}
	
	public void lottoRank()
	{
		//int score = 0;
		//int bonusScore = 0;
	
		
			if(this.score == 12)
			{
				System.out.println("1등 당첨입니다.");
				this.d1++;
			}else if(this.score == 8 && this.bonusScore == 2)
			{
				System.out.println("2등 당첨입니다.");
				this.d2++;
			}else if(this.score == 10)
			{
				System.out.println("3등 당첨입니다.");
				this.d3++;
			}else if(this.score == 8)
			{
				System.out.println("4등 당첨입니다.");
				this.d4++;
			}else if(this.score == 6)
			{
				System.out.println("5등 당첨입니다.");
				this.d5++;
			}else
			{
				System.out.println("당첨되지 않았습니다.");
			}
	
	}
	public void resultPrint()
	{
		System.out.println("1등 \t 2등 \t 3등 \t 4등 \t 5등");
		System.out.println(d1 + "\t" +d2 + "\t" + d3 + "\t" +d4 + "\t" +d5);
		System.out.println("총 횟수 : " + cnt);
	}
}
public class lotto_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Lotto lotto = new Lotto();
		lotto.lottoNum();
		
		while(lotto.d1 != 1)
		{
			lotto.userNum();
			System.out.println("로또 번호는 : ");
			lotto.userPrint();
			System.out.println();
			lotto.lottoResult();
			lotto.lottoRank();
			System.out.println();
			lotto.cnt++;
		}
		lotto.resultPrint();
	}

}



