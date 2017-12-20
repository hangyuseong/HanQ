import java.util.Scanner;

	class lotto
	{
		Scanner sc = new Scanner(System.in);
		int lotto[] = new int[6];
		int user[] = new int[6];
		int bonus = (int) (Math.random()*45) +1;
		int score = 0;
		int bonusscore = 0;
		int cnt = 0;
		int d1=0,d2=0,d3=0,d4=0,d5=0;//당첨 순위 초기화
		
		public void lottoNum()
		{
			for(int i = 0;i<lotto.length;i++)
			{
				lotto[i] = (int) (Math.random()*45) +1;
				for(int j = 0;j<i;j++)
				{
					if(lotto[i]==lotto[j] || lotto[i]==bonus)
					{
						i--;
					}
				}
			}
		}//중복되지 않게 로또번호 생성
		public void userNum()
		{
			for(int i = 0;i<user.length;i++)
			{
				user[i] = (int)(Math.random()*45) +1;
				for(int j = 0;j<i;j++)
				{
					if(user[i]==user[j])
					{
						i--;
					}
				}
			}
		}//중복되지 않게 사용자가 선택한 로또번호
		
		public void lottoPrint() 
		{
			for(int i = 0;i<lotto.length;i++)
			{
				System.out.println(lotto[i] + "");
			}
		}
		public void userPrint()
		{
			for(int i = 0;i<user.length;i++)
			{
				System.out.println(user[i] + "");
			}
		}
		
		public void lottoResult()
		{
			for(int i =0;i<lotto.length;i++)
			{
				for(int j = i; j<i+1;j++)
				{
					if(user[i]==lotto[j])
					{
						score +=2;
					}else if(user[i]==bonus)
					{
						bonusscore +=2;
					}
				}
			}
		}
		public void lottoRank()
		{
			
			if(this.score == 12)
			{
				System.out.println("1등 당첨입니다.");
				this.d1++;
			}else if(this.score  == 8 &&this.bonusscore==2)
			{
				System.out.println("2등 당첨입니다.");
				this.d2++;
				
			}else if(this.score  == 10)
			{
				System.out.println("3등 당첨입니다.");
				this.d3++;
			}else if(this.score  ==8)
			{
				System.out.println("4등 당첨입니다.");
				this.d4++;
			}else if(this.score  == 6)
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
			System.out.println("1등\t2등\t3등\t4등\t5등");
		    System.out.println(d1 + "\t" + d2 + "\t" + d3 + "\t" + d4 + "\t" + d5);
		    System.out.println("총 횟수 : " + cnt);
		}
	}
	public class lotto1 {

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		lotto lotto = new lotto();//생성자
		
		lotto.lottoNum();
		while(lotto.d1!=1)
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
