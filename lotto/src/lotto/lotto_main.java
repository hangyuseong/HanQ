package lotto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class lotto_main {
	
	private int command = 0;
	private BufferedReader in;
	private lotto_pro program = null;
	
	public final int RECOMMANDATION_NUMBER = 1;
	public final int PRINT_NUMBER = 2;
	public final int EXIT = 3;
	
	
	public lotto_main()
	{
		in = new BufferedReader(new InputStreamReader(System.in));
		
		program = new lotto_pro();
		
		start();
		
		
	}
	

	public static void main(String[] args) {
		new lotto_main();
		
	}
	
	public void start()
	{
		System.out.println("로또 프로그램이 시작 됩니다.");
		do {
			System.out.println("---------MENU---------");
			System.out.println("1. 추첨  2. 보기 3. 끝내기");
			System.out.println("----------------------");
			System.out.print(">> ");
			try
			{
				this.command = Integer.parseInt(in.readLine());
			}catch (Exception e) {
				System.out.println("Try again!");
				continue;
			}
			switch(this.command)
			{
			case RECOMMANDATION_NUMBER :
				program.start_recommandation();
				break;
			case PRINT_NUMBER :
				program.printNumber();
				break;
			case EXIT :
				System.out.println("프로그램 종료");
				return;
			}
		}while(true);
	}

}

