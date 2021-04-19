package member.provider.Java8Test;

public class VolatileTest {
    /**
     * volatile:
     * 1.可见性
     * 2.不保证原子行
     * 3.禁止指令重排（有序性 ）
     * @param args
     */


    public static void main(String[] args) {

        Data data = new Data();
        new Thread(() ->{
            System.out.println(data.a);
            try {
                Thread.sleep(3000);
                data.toUpdate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        while (data.a ==100){

        }

        System.out.println(data.a + "==================");

    }
}


class   Data{
     volatile  int  a = 100;

    public  void toUpdate(){
        this.a = 200;
    }
}
