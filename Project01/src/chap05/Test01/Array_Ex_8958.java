package chap05.Test01;

import java.util.Scanner;

public class Array_Ex_8958 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0;i<n;i++)
		{
			String input = sc.nextLine();
			int result = 0;
			int score = 0;
			
			for(int j = 0;j<input.length();j++)
			{
				if(input.charAt(j)=='O')
				{
					score++;
					result +=score;
					
				}else
				{
					score = 0;
				}
			}
			System.out.println(result);
		}
	}

}
