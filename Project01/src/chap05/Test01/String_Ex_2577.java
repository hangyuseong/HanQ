package chap05.Test01;

import java.util.Scanner;

public class String_Ex_2577 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		/*int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();*/
		
		int result = 1;
		//System.out.println(num);
		
		int arr[] = new int[10];//0부터 9까지 10개 배열을 만듬
		
		for(int i = 0;i<3;i++)
		{
			result *= sc.nextInt();
		}
		//System.out.println(result);
		for(int i = 0;result>0;i++)
		{
			int chk = result%10;
			result = result/10;
			arr[chk] += 1;
		}
		for(int i = 0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

}
