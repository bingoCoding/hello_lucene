package test.com.lp.mianshi;

public class BaseTest {
	public static void main(String[] args) {
		B b=new B(0);
		b.getY();
	}
}

class A{
	public static int x=2;
	
	private int y=1;

	public A() {
		x=x+2;
		System.out.println("a.x="+x);
	}
	public int getY(){
		return y;
	}
}
class B extends A{
	
	public B(int x) {
		x=x+1;
		System.out.println("b.x="+x);
	}
	public int getY(){
		System.out.println("b.y="+(super.getY()+1));
		return (super.getY()+1);
	}
}