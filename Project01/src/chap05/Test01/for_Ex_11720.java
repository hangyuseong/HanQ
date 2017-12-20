package chap05.Test01;

import java.util.Scanner;

public class for_Ex_11720 {

	public static void main(String[] args) {

/*		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int s = 0;
		int sum[] = new int[N];
		String str1 = "";
		int num;
		for(int i = 0;i<N;i++)
		{
			i += sc.nextInt();
			s = i;
			//System.out.println(s);
			
		}
		//System.out.println(s);
		String str = String.valueOf(s);//숫자를 문자열로 변환
		for(int k = 0;k<str.length();k++)
		{
			sum[k] += str.charAt(k);
			//sum[k] = Integer.parseInt(str);
			System.out.println(sum[k] + "");
		}
		System.out.println(s);
		for(int i = 0;i<str.length();i++)
		{
			//System.out.print(str.charAt(i) + " ");
			str1 += str.charAt(i);
			num = Integer.parseInt(str1);
			sum += num;
			
		}
		System.out.println(sum);
		*/
		
		Scanner sc = new Scanner(System.in);
		int length = Integer.parseInt(sc.nextLine());//문자열로 받아온거 숫자로 변경
		String N = sc.nextLine();
		int sum = 0;
		
		for(int i = 0;i<length;i++)
		{
			sum += (N.charAt(i)-'0');
		}
		System.out.println(sum);
	}

}
