package ascending;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_Ex2751 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		
		
		for(int i = 0;i<arr.length;i++)
		{
			int input = sc.nextInt();
			arr[i] = input;
		}
		Arrays.sort(arr);
		for(int i = 0;i<arr.length;i++)
		{
			
			System.out.println(arr[i]);
		}
		
	}
}
