package chap05.Test01;

import java.util.Scanner;

class if_Ex_03_1 {
    public static void main(String args[]){
        double sum =0;//�հ� ����
        double avg=0;//��� ����
        double count = 0;//������ ����� �Ѿ����� Ȯ���ϴ� count
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//��� ��������
        int [][] score = new int[N][];
        for(int i = 0 ; i<N; i++){
            int K = scanner.nextInt();
            score[i] = new int[K];//score[i]��° 0��°���� K���� ������ ����� ������ ������ְ� 
            for(int j=0; j<K;j++){
                score[i][j]=scanner.nextInt();
                //�� �ȿ� 0��°���� j�� 0����K���� �����ϴ¸�ŭ ������ �迭�� ������ �����Ѵ�.
            }
        }
        for(int i = 0 ; i<N; i++){//i�� 0���� N����  �ݺ��ϰ� �� �ȿ���
            sum = 0;
            avg = 0;
            count = 0;
            for(int j=0; j<score[i].length;j++){//i�� 0�϶� �� ������ ũ�⸸ŭ j �� 
                avg = (sum+=score[i][j])/score[i].length;
            }
            for(int j=0; j<score[i].length;j++){
                if(avg<score[i][j]){
                    count++;
                }
            }
            System.out.printf("%.3f%%\n",(double)((count*100)/(score[i].length)));
        }
    }
}