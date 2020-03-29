package member.provider.Java8Test;

public class ThreadLocalTest {
	
    public static void main(String[] args) {
    	  final ThreadLocal<String> threadLocal = new ThreadLocal<String>();
          threadLocal.set("123");
          System.out.println("ss1==" + threadLocal.get());

          new Thread(new Runnable() {
              @Override
              public void run() {
                  String s = threadLocal.get();
                  System.out.println("ss2=" + s);
              }
          }).start();

          new Thread(new Runnable() {
              @Override
              public void run() {
                  threadLocal.set("234");
                  String s = threadLocal.get();
                  System.out.println("ss3==" + s);
              }
          }).start();
	}
}
