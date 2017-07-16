package test.com.lp.mianshi;


public class RunOrderTest2 {
	public static void main(String[] args) {
		RunOrderTest2 t = null;// JVM加载Test类，静态代码块执行
        System.out.println("下面new一个Test实例：");
        t = new RunOrderTest2();
    }
    public static int a = 0;

    static {
        a = 10;
        System.out.println("静态代码块在执行a=" + a);
    }

    {
        a = 8;
        System.out.println("非静态代码块（构造代码块）在执行a=" + a);
    }

    public RunOrderTest2() {
        this("调用带参构造方法1，a=" + a); 
        System.out.println("无参构造方法在执行a=" + a);
    }

    public RunOrderTest2(String n) {
        this(n, "调用带参构造方法2，a=" + a); 
        System.out.println("带参构造方法1在执行a=" + a); 
    }

    public RunOrderTest2(String s1, String s2) {
        System.out.println(s1 + "；" + s2);
    }

}