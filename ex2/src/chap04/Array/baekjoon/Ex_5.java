package chap04.Array.baekjoon;

import java.util.Scanner;

class Ex_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String asc = "1 2 3 4 5 6 7 8";
		String des = "8 7 6 5 4 3 2 1";
		
		String in = sc.nextLine();
		
		if(in.equals(asc))
		{
			System.out.println("ascending");
		}else if(in.equals(des))
		{
			System.out.println("descending");
		}else
		{
			System.out.println("Mixed");
		}
	}
}
