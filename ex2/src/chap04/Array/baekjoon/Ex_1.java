package chap04.Array.baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex_1 {

	public static void main(String[] args) {
		  System.out.println("** rand_vari");
		  Integer[] arry = new Integer[10];
		  for (int i = 0; i < arry.length; i++)
		  {
		   arry[i] = (int) (Math.random() * 100 + 1);
		  }
		  System.out.print(Arrays.toString(arry));
		  System.out.println(" ");
		  System.out.println("** 정렬 뒤의 rand_vari");
		  Arrays.sort(arry, Collections.reverseOrder());
		  System.out.println(Arrays.toString(arry));
		 }
}
