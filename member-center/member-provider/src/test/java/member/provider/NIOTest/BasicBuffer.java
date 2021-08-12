package member.provider.NIOTest;

import java.nio.IntBuffer;

public class BasicBuffer {


    public static void main(String[] args) {

        IntBuffer inBuffer = IntBuffer.allocate(5);
        inBuffer.put(1);
        inBuffer.put(2);
        inBuffer.put(3);
        inBuffer.put(4);
        inBuffer.put(5);
        inBuffer.flip(); // 读写转换


     while (inBuffer.hasRemaining()){
         System.out.println(inBuffer.get());
     }
    }
}
