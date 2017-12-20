package chap05.Test01;

public class OperatorTest {

	public static void main(String[] args) {
		int a = 10;
		boolean b = false;
		double d = 10.555555;
		float f = (float)d;
		if((b == true) || (a++ ==10))
		{
			System.out.println("Equal " + a);
		}else
		{
			System.out.println("Not Equal!" + a);
		}
		
		
	}
	long add(int a, int b)
	{
		return a+b;
	}

	long add(long a, long b)
	{
		return a + b;
	}
	int add(byte a, byte b)
	{
		return a + b;
	}
	int add(long a, int b)
	{
		return (int)a+b;
	}

}
