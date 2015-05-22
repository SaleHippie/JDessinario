import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 20.05.2015.
 * Summary :  Initialize the client to the connection
 */
public class ClientInitializer extends ChannelInitializer<SocketChannel> {

    /************************************
     * Summary :    initialize the channel with parameters
     * Name :       initChannel()
     * Param :      SocketChannel
     * Return :     -
     **************************************/
    @Override
    public void initChannel(SocketChannel arg0) throws Exception {
        ChannelPipeline pipeline = arg0.pipeline();

        //pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipeline.addLast("decoder", new ObjectDecoder(ClassResolvers.cacheDisabled(getClass().getClassLoader())));//StringDecoder());
        pipeline.addLast("encoder", new ObjectEncoder());//StringEncoder());

        pipeline.addLast("handler", new ClientHandler());
       // pipeline.addLast("answerHandler", new AnswerHandler());
    }
}
