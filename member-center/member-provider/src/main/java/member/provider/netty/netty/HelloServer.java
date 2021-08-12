package member.provider.netty.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author Hello
 *
 * netty  服务端代码
 * EventLoop
 */
public class HelloServer {

    public static void main(String[] args) {

        //1.启动器,负责组装netty组件，启动服务器
        new ServerBootstrap()
                //2.EventLoop (selector类型) 分boss和worker boss只负责accept事件 连接  worker负责读写事件、
                //boss线程数不用设置 只能是1个 ，worker的工作线程数一般是cpu核数* 2
                .group(new NioEventLoopGroup(),new NioEventLoopGroup( 8))
                //3. 选择服务器的ServerSocketChannel实现
                .channel(NioServerSocketChannel.class)
                //4.boss 负责连接worker,读写请求,
                .childHandler(new ChannelInitializer<NioSocketChannel>() {

                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        //添加具体的handler,  并把字节转换为字符串
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                            //读事件
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) {
                                System.out.println(msg);
                            }
                        });
                    }
                }).bind(8080);
    }
}
