package chap01_sosu;

import java.util.Scanner;

class Ex_1 {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
 
        int num = sc.nextInt();
        int sosuCnt = 0, cnt = 0;
 
        for (int i = 1; i <= num; i++) {
            int num2 = sc.nextInt();
            sosuCnt = 0;
 
            for (int j = 1; j <= num2; j++) {
                if (num2 % j == 0)
                    sosuCnt++;
            }
 
            if (sosuCnt == 2)
                cnt++;
        }
        System.out.print(cnt);
    }
}
