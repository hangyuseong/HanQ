package ascending;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_Ex1427 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();//���ڿ��� �޾ƿ���
		//System.out.println(N);
		
		int size = N.length();//���ڿ��� ���̷� �������� ũ�⸦ �ش�.
		
		//System.out.println(size);
		char arr[] = new char[size];//char���� �迭�� size ũ�⸦ �����ش�.
		
		for(int i = 0;i<N.length();i++)//���� ũ�⸸ŭ for���� ����.
		{
			arr[i] = N.charAt(i);//���ڿ����� 1���ھ� �����ͼ� �迭�� ���� �������ش�.
		}
		
		
		Arrays.sort(arr);
		
		for(int i = arr.length-1;i>=0;i--)//0~3�� �迭���� �޺κк��� �����´�. ������
										//������������ �صΰ� �ݴ�β����� ���������� �ϼ�.
		{
			System.out.print(arr[i]);
		}
	}
}
