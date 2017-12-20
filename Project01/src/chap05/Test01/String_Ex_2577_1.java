package chap05.Test01;

import java.util.Scanner;

public class String_Ex_2577_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int arr1[] = new int[3];
		int arr[] = new int[10];//배열 10개 0~9까지
		int result = 1;
		int cnt = 0;
		for(int i = 0;i<arr1.length;i++)
		{
			result *= sc.nextInt();
		}
		
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
