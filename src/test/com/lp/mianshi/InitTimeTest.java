package test.com.lp.mianshi;

public class InitTimeTest {
	public static int a=10;
	{
		a=8;
		System.out.println("a="+8);
	}
	public InitTimeTest(){
		System.out.println("init a="+a);
	}
	public static void main(String[] args) {
		System.out.println("main a=" + a);
		InitTimeTest init=new InitTimeTest();
		System.out.println("main a=" + a);
	}
}
