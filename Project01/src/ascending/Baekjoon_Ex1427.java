package ascending;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_Ex1427 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();//문자열을 받아오고
		//System.out.println(N);
		
		int size = N.length();//문자열의 길이로 사이즈의 크기를 준다.
		
		//System.out.println(size);
		char arr[] = new char[size];//char형의 배열을 size 크기를 정해준다.
		
		for(int i = 0;i<N.length();i++)//받은 크기만큼 for문을 돈다.
		{
			arr[i] = N.charAt(i);//문자열에서 1글자씩 꺼내와서 배열에 각각 저장해준다.
		}
		
		
		Arrays.sort(arr);
		
		for(int i = arr.length-1;i>=0;i--)//0~3번 배열에서 뒷부분부터 꺼내온다. 정렬은
										//오름차순으로 해두고 반대로꺼내서 내림차순을 완성.
		{
			System.out.print(arr[i]);
		}
	}
}
