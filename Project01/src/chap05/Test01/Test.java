package chap05.Test01;


public class Test {
	public static void main(String[] argv) {
		int idx = 0;
		char[] charArray = new char[10];
		
		charArray[idx++] = '0';
		charArray[idx++] = 65;
		charArray[idx++] = 'A' + 1;
		
		System.out.println( charArray );
	}

}
