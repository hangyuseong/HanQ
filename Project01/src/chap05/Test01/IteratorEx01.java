package chap05.Test01;

import java.util.*;
class Book
{
	String bookName;
//	String bookNumber;
	int bookPrice;
	public Book() {

	}
	public Book(String bookName, int bookPrice)
	{
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
}
public class IteratorEx01 {
	public static void main(String[] args) {
		Map<String, Book> map = new HashMap<String, Book>();
		Book b[] = {new Book("Onepice1",3500),
				new Book("Onepice2",2800),
				new Book("Onepice3",5000),
				new Book("Onepice4",3000),
				new Book("Onepice5",2700),
		};
		
		for(int i = 0;i<b.length;i++)
		{
			//System.out.println(b[i].bookName);
			map.put(b[i].bookName, b[i]);
			
		}
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext())
		{
			String key = keys.next();
			System.out.println(String.format("Å° : %s, °ª : %s", key,map.get(key).bookPrice));
		}
	}
}