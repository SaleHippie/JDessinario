package joly.tpi.jdessinario;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.BindException;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 18.05.2015.
 * Summary :  main class for server.
 */
public class Server {
    private final int port;
    public Server(int port) {
        this.port = port;
    }

    /************************************
     * Summary :    run the server with parameter
     *              and start the listen's thread
     * Name :       run()
     * Param :      -
     * Return :     -
     **************************************/
    public void run() throws InterruptedException, BindException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer());

            bootstrap.bind(port).sync().channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
