package member.provider.NIOTest;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * 使用buffer操作数据读写
 */
public class NIOFileChannel {

    public static void main(String[] args)  throws  Exception{
//        //写文件
//        String  str = "Hello ,allen";
//        FileOutputStream fileOutputStream = new FileOutputStream("d://file01.txt");
//        FileChannel channel = fileOutputStream.getChannel();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        //数据放入buffer
//        byteBuffer.put(str.getBytes());
//        byteBuffer.flip();
//
//        //buffet数据写入channel
//        channel.write(byteBuffer);
//        fileOutputStream.close();


         //读文件
        File file = new File("d://file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        channel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}
