package chap01_sosu;

import java.util.Scanner;

class Ex_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int sum = 0;
		int sosucnt = 0, cnt = 0;
		
		while(M<N)
		{
			for(int i = M;i<=N;i++)
			{
				sum = 0;
				for(int j = 1;j<=N;j++)
				{
					if(i%j == 0)
					{
						sosucnt++;
					}
					if(sosucnt == 2)
						sum += M;
					System.out.println(sum);

				}
			}
		}
		/*if(M<N)
		{
			for(int i = M;i<=N;i++)
			{
				//sum = 0;
				for(int j = 1;j<=M;j++)
				{
					if(i%j == 0)
					{
						sosucnt++;
					}
					if(sosucnt == 2)
						sum = sum + i;

				}
				System.out.println(sum);

//				System.out.println(i);
			}
		}else if(M>N)
		{
			for(int i =N;i<=M;i++)
			{
				for(int j = 1;j<=N;j++)
				{
					if(N%j == 0)
					{
						sosucnt++;
					}
					if(sosucnt == 2)
					{
						sum += N;
					}
				}
			}
		}
		System.out.println(sum);*/
	}

}
