package chap05.Test01;

import java.util.Scanner;

class if_Ex_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int avg = 0;
		int cnt = 0;
		int a = sc.nextInt(); // 몇개를 비율로 만들것인지 초기 숫자

		int b = sc.nextInt();
		int arr[] = new int[b];
		for(int i = 0;i<arr.length;i++)
		{
			int c = sc.nextInt();
			arr[i] = c;
			//System.out.print(arr[i] + " ");

		}
		for(int j = 0;j<arr.length;j++)
		{
			sum += arr[j];

		}
		avg = sum/arr.length;
		for(int k = 0;k<arr.length;k++)
		{
			if(avg <=arr[k])
			{
				cnt++;
			}

		}
		//System.out.println(cnt);
		//System.out.format("%2f%n", (double)cnt / (double)arr.length);
		System.out.println(((double)cnt / (double)arr.length)*100 + "%");
		//System.out.println(sum);
		//System.out.println(avg);
	}

}
