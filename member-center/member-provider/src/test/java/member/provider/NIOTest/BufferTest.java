package member.provider.NIOTest;

import java.nio.ByteBuffer;

public class BufferTest {

    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(32);
        allocate.put("Hello,world \n Im zhangsan \nHo".getBytes());
        split(allocate);
        allocate.put("w are you?\n".getBytes());
        split(allocate);
    }

    private static void split(ByteBuffer source) {
        source.flip();
        for (int i= 0;i <source.limit(); i++){
            if (source.get(1) == '\n'){
                int lenth = i + 1 - source.position();
                ByteBuffer allocate = ByteBuffer.allocate(lenth);

                for (int j = 0; j<lenth;j ++){
                    allocate.put(source.get());
                }
            }

            source.compact();

        }

    }
}
