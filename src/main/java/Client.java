import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 20.05.2015.
 * Summary :  Client main class to run it
 */
public class Client {

    private final String host;
    private final int port;
    public Channel channel = null;
    public boolean exitChannel = false;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }
    /************************************
     * Summary :    run the client with parameter
     *              and start the listen thread
     * Name :       run()
     * Param :      -
     * Return :     -
     **************************************/
    public void run() throws IOException, InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();



        try{
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientInitializer());


            channel = bootstrap.connect(host, port).sync().channel();

            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            while (exitChannel == false){

            }
        }
        finally {
            group.shutdownGracefully();
        }
    }

}