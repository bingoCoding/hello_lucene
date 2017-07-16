package test.com.lp.mianshi;

public class ExtendTest {
	public static void main(String[] args) {
		new HelloB();
	}
}
class HelloA {
	public HelloA(){
		System.out.println("helloA");
	}
	{System.out.println("I'm A class");}
	static{
		System.out.println("static helloA");
	}
}
class HelloB extends HelloA{
	public HelloB(){
		System.out.println("helloB");
	}
	{System.out.println("I'm B class");}
	static{
		System.out.println("static helloB");
	}
	
}
