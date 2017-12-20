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
			cnt[text[i]-97]++;//a~z까지 cnt 배열에 0~25까지 해당 문자에 맞는 배열에 값을 1씩 증가시킨다.
		}					//a는 기준점 아스키코드로 97 = a

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
			}//Mississipi와 같이 문자에 s와 i가 같을때 flag를 true로 만들어줘서 true일때
			//"?"을 출력하게 한다.
		}

		if(flag)
		{
			System.out.println("?");
		}else
		{
			char ans = (char)(num + 97);//문자를 해당 문자로 지정된 num과 값 a 인 97을
										// 더해서 어느 숫자가 가장많이 나오는지 설정해준다.
							//숫자를 char형으로 형변환한다.
			System.out.println(ans);
		}
	}
}
