package chap05.Test01;

class Car
{
	protected String name;
	protected int speed;
	public Car()
	{
		speed = 0;
		name = null;
	}
	public Car(String name, int speed)
	{
		this.name = name;
		this.speed = speed;
	}
	
	public void speedUp()
	{
		speed++;
	}
	public void speedDown()
	{
		speed--;
	}
	public void stop()
	{
		speed = 0;
	}
	public void display()
	{
		System.out.println("자동차의 이름 : " + name + ", 속도 : " + speed);
	}
}

class Taxi extends Car
{
	private int charge;
	private boolean fare;
	private String company;
	public Taxi(String company)
	{
		this.company = company;
	}
	public Taxi(int charge,boolean fare,String company)
	{
		this.charge = charge;
		this.fare = fare;
		this.company = company;
	}
	
	public void accounts()
	{
		if(fare == true)
		{
			charge = speed*12;
		}else
		{
			charge = speed*10;
		}
	}
	public void setFare(boolean fare)
	{
		this.fare = true;
	}
	public void display()
	{
		System.out.println("택시 회사 명 : " + company + ", 요금  : " + charge + ", 할증 여부 " + fare);
	}
	
}
class Test01 {

	public static void main(String[] args) {
		Car c = new Car("벤틀리",300);
		c.display();
		Taxi t = new Taxi("서울 택시");
		t.speed = 130;
		t.speedUp();
		t.speedUp();
		t.setFare(true);
		t.accounts();
		t.display();
	}
}
