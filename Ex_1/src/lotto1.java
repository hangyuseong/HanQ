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
		int d1=0,d2=0,d3=0,d4=0,d5=0;//��÷ ���� �ʱ�ȭ
		
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
		}//�ߺ����� �ʰ� �ζǹ�ȣ ����
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
		}//�ߺ����� �ʰ� ����ڰ� ������ �ζǹ�ȣ
		
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
				System.out.println("1�� ��÷�Դϴ�.");
				this.d1++;
			}else if(this.score  == 8 &&this.bonusscore==2)
			{
				System.out.println("2�� ��÷�Դϴ�.");
				this.d2++;
				
			}else if(this.score  == 10)
			{
				System.out.println("3�� ��÷�Դϴ�.");
				this.d3++;
			}else if(this.score  ==8)
			{
				System.out.println("4�� ��÷�Դϴ�.");
				this.d4++;
			}else if(this.score  == 6)
			{
				System.out.println("5�� ��÷�Դϴ�.");
				this.d5++;
			}else
			{
				System.out.println("��÷���� �ʾҽ��ϴ�.");
			}
		}
	
		public void resultPrint()
		{
			System.out.println("1��\t2��\t3��\t4��\t5��");
		    System.out.println(d1 + "\t" + d2 + "\t" + d3 + "\t" + d4 + "\t" + d5);
		    System.out.println("�� Ƚ�� : " + cnt);
		}
	}
	public class lotto1 {

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		lotto lotto = new lotto();//������
		
		lotto.lottoNum();
		while(lotto.d1!=1)
		{
			lotto.userNum();
		System.out.println("�ζ� ��ȣ�� : ");
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
