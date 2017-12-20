package game;
import java.util.Scanner;

	class Dice
	{
		int dice;
		int x=0, y=0,end; //플레이어 1 2 초기값 0
		//int Map[] = new  Map[];
		public void firstPrintrMap(int firstMap[])
		{
			for(int i = 0;i<firstMap.length;i++)
			{
				if(x==i)
				{
					System.out.println("★");
				}else if(firstMap[i]==0)
				{
					System.out.println("☆");
				}
			}
		}
		
		public void secondPrintMap(int secondMap[])
		{
			for(int i = 0;i<secondMap.length;i++)
			{
				if(y==i)
				{
					System.out.println("●");
				}else if(secondMap[i]==0)
				{
					System.out.println("○");
				}
			}
		}
		
		public void getDiceNum()
		{
			this.dice = (int) (Math.random()*6)+1;
		}
		public void firstPlayer()
		{
			//this.dice ++;
			x += this.dice;
		}
		
		public void secondPlayer()
		{
			//this.dice ++;
			y += this.dice;
		}
		public boolean endGame(int map[]) // 플레이어 1 2 승패 결정
		{
			if(x>map.length-1)// 이동한 값이 맵 전체의 크기-1보다 커지면 종료
			{
				System.out.println("firstPlayer Win!");
				return true;
			}else if(y>map.length-1)
			{
				System.out.println("secondPlayer Win!");
				return true;
			}else
			{
				return false;
			}
		}
		
		public void printMenu()
		{
			System.out.println("0 : 주사위 던지기 \t 5 : 강제종료");
			System.out.println(">>>>>>");
		}
		
	}
	public class ex_3 {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("앱의 크기를 입력하세요.");
		int mapSize = sc.nextInt();
		int number;
		int [] firstMap = new int[mapSize];
		int [] secondMap = new int[mapSize];
		boolean run = true;
		Dice game = new Dice();
		
		for(int i = 0;i<firstMap.length;i++)
		{
			firstMap[i]=0;
		}
		for(int j = 0;j<secondMap.length;j++)
		{
			secondMap[j] = 0;
		}
		do
		{
		System.out.println("Game Start!");
		for(int i = 0;i<2;i++)
		{
			if(i==0)
			{
				System.out.println("firstPlayerMap");
				game.firstPrintrMap(firstMap);
				System.out.println();
				System.out.println("secondPlayerMap");
				game.secondPrintMap(secondMap);
				System.out.println();
				System.out.println();
				System.out.println("firstPlayer Trun");
				game.printMenu();
				number = sc.nextInt();
				game.firstPlayer();
				if(number == 0)
				{
					game.getDiceNum();
					game.firstPlayer();
					if(game.endGame(firstMap))
					{
						System.out.println("게임 클리어");
						game.firstPrintrMap(firstMap);
						System.out.println();
						run = false;
					}
					System.out.println("주사위 : " + game.dice);
				}else if(number == 5)
				{
					System.out.println("게임을 포기합니다.");
					System.out.println("secondPlayer Win!");
					run = false;
					break;
				}
				
			}else if(i == 1)
			{
				System.out.println("firstPlayerMap");
				game.secondPrintMap(firstMap);
				System.out.println();
				System.out.println("secondPlayerMap");
				game.secondPrintMap(secondMap);
				System.out.println();
				System.out.println();
				System.out.println("secondPlayer Turn");
				game.printMenu();
				number = sc.nextInt();
				if(number == 0)
				{
					game.getDiceNum();
					game.secondPlayer();
					if(game.endGame(secondMap))
					{
						System.out.println("게임 클리어");
						game.secondPrintMap(secondMap);
						System.out.println();
						run = false;
					}
					System.out.println("주사위 : " + game.dice);
				}else if(number == 5)
				{
					System.out.println("게임을 포기합니다.");
					System.out.println("secondPlayer Win!");
					run = false;
				}
			}
		}
	}while(run);
		System.out.println("게임 종료");
	}
}
