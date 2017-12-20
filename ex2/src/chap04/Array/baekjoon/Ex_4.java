package chap04.Array.baekjoon;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Ex_4 {

	public static void main(String[] args) {
		//Comparator cmp = Collections.reverseOrder();
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int arr [] = new int[a];
		Integer arr1 [] = new Integer [a];
		//int arr2 [] = new int [a];
		
		//boolean run = true;
		for(int i = 0;i<arr.length;i++)
		{
			int b  = sc.nextInt();
			arr[i] = b;	
			System.out.print(arr[i]);

				for(int k = 0;k<arr.length;k++)
				{
					arr1[k] = arr[k];
				}
				//Arrays.sort(arr1);
				for(int l = 0;l<arr.length;l++)
				{
					arr1[l] = arr[l];
				}
//				List<int[]> list = Arrays.asList(arr1);
				//Collections.sort(arr2,cmp);
				Arrays.sort(arr1, Collections.reverseOrder());
		}
		System.out.println();
		for(int j : arr1) System.out.print(j);
		System.out.println();
		for(int n = 0;n<arr.length;n++)
		{
			if(arr[n] == arr1[n])
			{
				System.out.println("오름차순");
			}
		}
		


		
	}

}