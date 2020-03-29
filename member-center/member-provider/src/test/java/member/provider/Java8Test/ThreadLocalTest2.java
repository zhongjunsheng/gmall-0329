package member.provider.Java8Test;


public class ThreadLocalTest2 {
	
    public static Message msg;  //共享变量
    
    public static void main(String[] args) throws InterruptedException {
    	
    	   ThreadLocal<Message> td =  new ThreadLocal<>();
    	   ThreadLocal<Message> td2 =  new ThreadLocal<>();
    	  
        new Thread(() -> {
            Message msg = new Message();
            msg.setNote("你好啊");
            
            //MyUtil.set(msg);
            td.set(msg);
            
            //Test20.msg = msg;
            new MessageConsumer().print(td);
        }, "用户A").start();
        
        
        //Thread.sleep(2000);
        new Thread(() -> {
            Message msg = new Message();
            msg.setNote("Hello");
            
            //MyUtil.set(msg);
            td.set(msg);

            //Test20.msg = msg;
            new MessageConsumer().print(td);
        }, "用户B").start();
    }

}


class MyUtil{
    public static ThreadLocal<Message> threadlocal = new ThreadLocal<>();
    public static void set(Message msg){
        threadlocal.set(msg);
    }
    public static Message get(){
        return threadlocal.get();
    }
    
    public static void remove(){
         threadlocal.remove();
    }
}


class Message{
    private String note;
    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return note;
    }
}


class MessageConsumer{
    public void print(ThreadLocal<Message> td){
        System.out.println(Thread.currentThread().getName() + "..." + td.get().getNote());
    }
}


