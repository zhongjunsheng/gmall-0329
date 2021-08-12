package member.provider.NIOTest;

import java.nio.ByteBuffer;

public class ByteBufferTest {


    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        byteBuffer.put(new byte[]{'1', '2', '3', '4'});
        byteBuffer.flip();
        System.out.println((char) byteBuffer.get());
        System.out.println((char) byteBuffer.get());
        byteBuffer.mark();  //回答上次标注的位置
        System.out.println((char) byteBuffer.get());
        byteBuffer.reset(); // 回到上次读取的位置
        System.out.println((char) byteBuffer.get());
        byteBuffer.rewind();  //下标回到初始的地方
        System.out.println((char) byteBuffer.get());
    }


}
