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
		System.out.println("�ڵ����� �̸� : " + name + ", �ӵ� : " + speed);
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
		System.out.println("�ý� ȸ�� �� : " + company + ", ���  : " + charge + ", ���� ���� " + fare);
	}
	
}
class Test01 {

	public static void main(String[] args) {
		Car c = new Car("��Ʋ��",300);
		c.display();
		Taxi t = new Taxi("���� �ý�");
		t.speed = 130;
		t.speedUp();
		t.speedUp();
		t.setFare(true);
		t.accounts();
		t.display();
	}
}
