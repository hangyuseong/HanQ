package ascending;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Baekjoon_Ex1181 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//값을 입력 받는다. br에 저장
		
		int i , j, n = Integer.parseInt(br.readLine()), len, tmp, size;//변수를 선언
		//애초에 중복 값을 저장하지 않기 위해 HashSet을 사용하여 중복을 배제한다.
		//그 후 문자열의 길이를 기준으로 정렬을하고 문자열들을 길이대 별로 사전순으로 정렬
		HashSet<String> hs = new HashSet<>();//중복 요소는 저장하지 않는다.
		//배열에 add메서드로 읽어온 값을 hs에 저장
		for(i = 0;i<n;i++)
		{
			hs.add(br.readLine());
		}
		size = hs.size();//변수로 선언한 size에 hs의 크기를 저장한다.
		String arr[] = new String[size];//String배열에 hs에 저장된 문자열을옮긴다.
		hs.toArray(arr);//
		
		Arrays.sort(arr, new Comparator<String>() {//퀵소트 메서드로 Comparator를 구현하여 문자열의 길이순으로 정렬을 하도록 함.
			public int compare(String s1, String s2)
			{
				return Integer.compare(s1.length(), s2.length());
			}
		});
		//같은 길이에서는 사전순으로 정렬을 하는 부분
		for(i = 0;i<size;i++)
		{
			len = arr[i].length();
			for(j = i+1;j<size;j++)
			{
				tmp = arr[j].length();
				if(len != tmp) break;//길이가 같지 않으면 빠져 나온다.
			}
			Arrays.sort(arr,i,j);
			//i = j - 1; //묶어준다 길이가 같은 그룹별로
		}
		
		for(i = 0;i<size;i++)
		{
			System.out.println(arr[i]);
		}
		br.close();
		
	}
}
