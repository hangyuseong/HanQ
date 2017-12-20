package chap04.Array.baekjoon;

import java.util.Scanner;

class Ex_6 {
	public static void main(String[] args) {
		int sum;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr [] = new int[N];
		for(int i = 0;i<arr.length;i++)
		{
			int a = sc.nextInt();
			arr[i] = a;
			System.out.println(a);
			if(arr[i]>=40)
			{
				arr[i] = a;
			}else if(a<40)
			{
				arr[i] = 40;
			}
			for(int k = 0;k<arr.length;k++)
			{
				sum = arr[k];
				System.out.println(sum);
			}
			
			int avg = arr[i]/N;
			System.out.println(avg);
		}
	}
}
