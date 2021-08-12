package member.provider.NIOTest;

import java.nio.ByteBuffer;

public class Buffer2StringTest {

    public static void main(String[] args) {

        //字段串转buffer

        //1.str.getBytes()方法
        ByteBuffer buffer = ByteBuffer.allocate(10).put("hello".getBytes());
        buffer.flip();  //需要切换到读模式才能读
        System.out.println((char)buffer.get());
        buffer.compact(); //切换写模式
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
        //buffer.rewind();  //回到下标0的位置

//        //直接可读
//        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("allen");
//        System.out.println((char)buffer2.get());
//        System.out.println((char)buffer2.get());
//        System.out.println((char)buffer2.get());
//        System.out.println((char)buffer2.get());
//        System.out.println((char)buffer2.get());
//
//
//        //byte 切换字符串
//        System.out.println("###################");
//
//        String str = StandardCharsets.UTF_8.decode(buffer).toString();
//        System.out.println(str);
//
//        buffer2.flip();
//        String string = StandardCharsets.UTF_8.decode(buffer2).toString();
//        System.out.println(string);


    }
}

