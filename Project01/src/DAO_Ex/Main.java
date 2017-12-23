package DAO_Ex;

import java.util.Scanner;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		
		DAO dao = DAO.getInstance();
		
		Good dto = new Good();
		dto.setCode("100");
		dto.setName("������");
		dto.setManufacture("����");
		dto.setPrice(900000);
		
		Calendar cal = new GregorianCalendar(2017,11,23);
		
		Date date = new Date(cal.getTimeInMillis());
		dto.setMakingdate(date);
		
		boolean r = dao.InsertGood(dto);
		
		if(r)
		{
			System.out.println("���Կ� �����Ͽ����ϴ�.");
		}else
		{
			System.out.println("���Կ� �����߽��ϴ�.");
		}
		
		List<Good> list = dao.getList();
		
		for(Good good : list)
		{
			System.out.println(good);
		}
	}

}
