package ascending;

import java.io.*;

public class Baekjoon_Ex10989 {
	
	int [] numbers;
	int [] countArr;
	
	int max = 0;
	int index = 0;
	
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	void inputNumber() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int size = Integer.parseInt(br.readLine().trim());
		 numbers = new int[size];
		 for(int i = 0;i<numbers.length;i++)
		 {
			 int num = Integer.parseInt(br.readLine().trim());
			 numbers[i] =  num;
			 
			 if(max<num)
			 {
				 max = num;
			 }
		 }
	}
	
	void sort() throws IOException
	{
		inputNumber();
		int maxNumber = max;
		countArr = new int[maxNumber + 1];
		for(int i = 0;i<numbers.length;i++)
		{
			countArr[numbers[i]]++;
		}
		for(int i = 0;i < countArr.length;i++)
		{
			for(int j = 0;j<countArr[i];j++)
			{
				bw.write(i+"\n");
			}
		}
		bw.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		new Baekjoon_Ex10989().sort();
	}
}
