package member.provider.netty.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

/**
 * @author Hello
 *
 * netty 客户端代码
 */
public class HelloClient {

    public static void main(String[] args) throws InterruptedException {

          //1.启动类
        Channel channel = new Bootstrap()
                //2.添加EventLoop
                .group(new NioEventLoopGroup())
                //3.选择客户端channel
                .channel(NioSocketChannel.class)
                //4.添加处理器
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        //把字符串转成字节
                        ch.pipeline().addLast(new StringEncoder());

                    }
                }).connect(new InetSocketAddress("localhost", 8080))
                .sync()  //阻塞直到连接建立
                .channel();
                //向服务端发送数据
              //.writeAndFlush("hello,world");

        for (int i = 0; i <20 ; i++) {
            channel.writeAndFlush("hello,world");
        }

    }
}
