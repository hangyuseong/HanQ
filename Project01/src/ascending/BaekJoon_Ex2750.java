package ascending;

import java.util.Scanner;

public class BaekJoon_Ex2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k [] = new int[N];
		for(int i = 0;i<N;i++)
		{
			
			int m = sc.nextInt();
			k[i] = m;
		}
		
		for(int i = 0;i<k.length;i++)
		{
			System.out.println(k[i]);
		}
		for(int i = 0;i<k.length;i++)
		{
			for(int j = i+1;j<k.length;j++)
			{
				if(k[i]>k[j])
				{
					int temp = k[i];
					k[i] = k[j];
					k[j] = temp;
				}
			}
		}
		for(int i = 0;i<k.length;i++)
		{
			System.out.println(k[i]);
		}
	}
}
