package chap05.Test01;

import java.util.Scanner;

public class String_Ex_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		String str = sc.nextLine();
		str = str.toLowerCase();

		char [] text = str.toCharArray();

		int cnt [] = new int[26];
		for(int i = 0;i<text.length;i++)
		{
			cnt[text[i]-97]++;//a~z���� cnt �迭�� 0~25���� �ش� ���ڿ� �´� �迭�� ���� 1�� ������Ų��.
		}					//a�� ������ �ƽ�Ű�ڵ�� 97 = a

		int max = 0;
		int num = 0;

		for(int i = 0;i<cnt.length;i++)
		{
			if(max <cnt[i])
			{
				max = cnt[i];
				num = i;
			}
		}
		for(int i = 0;i<cnt.length;i++)
		{
			for(int j = 0;j<cnt.length;j++)
			{
				if(cnt[i]==max && cnt[j]==max && i != j)
				{
					flag = true;
				}
			}//Mississipi�� ���� ���ڿ� s�� i�� ������ flag�� true�� ������༭ true�϶�
			//"?"�� ����ϰ� �Ѵ�.
		}

		if(flag)
		{
			System.out.println("?");
		}else
		{
			char ans = (char)(num + 97);//���ڸ� �ش� ���ڷ� ������ num�� �� a �� 97��
										// ���ؼ� ��� ���ڰ� ���帹�� �������� �������ش�.
							//���ڸ� char������ ����ȯ�Ѵ�.
			System.out.println(ans);
		}
	}
}
