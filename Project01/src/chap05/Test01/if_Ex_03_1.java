package chap05.Test01;

import java.util.Scanner;

class if_Ex_03_1 {
    public static void main(String args[]){
        double sum =0;//합계 변수
        double avg=0;//평균 변수
        double count = 0;//점수가 평균을 넘었는지 확인하는 count
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//몇번 실행할지
        int [][] score = new int[N][];
        for(int i = 0 ; i<N; i++){
            int K = scanner.nextInt();
            score[i] = new int[K];//score[i]번째 0번째에는 K개의 점수가 저장될 공간을 만들어주고 
            for(int j=0; j<K;j++){
                score[i][j]=scanner.nextInt();
                //그 안에 0번째에서 j가 0부터K까지 증가하는만큼 각각의 배열에 점수를 저장한다.
            }
        }
        for(int i = 0 ; i<N; i++){//i가 0부터 N까지  반복하고 그 안에서
            sum = 0;
            avg = 0;
            count = 0;
            for(int j=0; j<score[i].length;j++){//i가 0일때 그 길이의 크기만큼 j 값 
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