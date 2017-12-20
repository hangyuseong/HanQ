package chap05.Test01;

class Derived extends Poliymorphism
{
	public void f()
	{
		System.out.println("sub class");
	}
}
class Poliymorphism {

	private void f()
	{
		System.out.println("base class");
	}
	public static void main(String[] args) {
		Poliymorphism po = new Derived();
		po.f();
	}

}
