package ascending;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Baekjoon_Ex1181 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//���� �Է� �޴´�. br�� ����
		
		int i , j, n = Integer.parseInt(br.readLine()), len, tmp, size;//������ ����
		//���ʿ� �ߺ� ���� �������� �ʱ� ���� HashSet�� ����Ͽ� �ߺ��� �����Ѵ�.
		//�� �� ���ڿ��� ���̸� �������� �������ϰ� ���ڿ����� ���̴� ���� ���������� ����
		HashSet<String> hs = new HashSet<>();//�ߺ� ��Ҵ� �������� �ʴ´�.
		//�迭�� add�޼���� �о�� ���� hs�� ����
		for(i = 0;i<n;i++)
		{
			hs.add(br.readLine());
		}
		size = hs.size();//������ ������ size�� hs�� ũ�⸦ �����Ѵ�.
		String arr[] = new String[size];//String�迭�� hs�� ����� ���ڿ����ű��.
		hs.toArray(arr);//
		
		Arrays.sort(arr, new Comparator<String>() {//����Ʈ �޼���� Comparator�� �����Ͽ� ���ڿ��� ���̼����� ������ �ϵ��� ��.
			public int compare(String s1, String s2)
			{
				return Integer.compare(s1.length(), s2.length());
			}
		});
		//���� ���̿����� ���������� ������ �ϴ� �κ�
		for(i = 0;i<size;i++)
		{
			len = arr[i].length();
			for(j = i+1;j<size;j++)
			{
				tmp = arr[j].length();
				if(len != tmp) break;//���̰� ���� ������ ���� ���´�.
			}
			Arrays.sort(arr,i,j);
			//i = j - 1; //�����ش� ���̰� ���� �׷캰��
		}
		
		for(i = 0;i<size;i++)
		{
			System.out.println(arr[i]);
		}
		br.close();
		
	}
}
