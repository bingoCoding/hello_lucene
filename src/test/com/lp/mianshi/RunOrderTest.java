package test.com.lp.mianshi;


public class RunOrderTest {
	public static void main(String[] args) {
		Test t = null;// JVM����Test�࣬��̬�����ִ��
        System.out.println("����newһ��Testʵ����");
        t = new Test();
    }
    
}
class Test{
	public static int a = 0;

    static {
        a = 10;
        System.out.println("��̬�������ִ��a=" + a);
    }

    {
        a = 8;
        System.out.println("�Ǿ�̬����飨�������飩��ִ��a=" + a);
    }

    public Test() {
        this("���ô��ι��췽��1��a=" + a); 
        System.out.println("�޲ι��췽����ִ��a=" + a);
    }

    public Test(String n) {
        this(n, "���ô��ι��췽��2��a=" + a); 
        System.out.println("���ι��췽��1��ִ��a=" + a); 
    }

    public Test(String s1, String s2) {
        System.out.println(s1 + "��" + s2);
    }

}