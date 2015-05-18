import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 18.05.2015.
 * Summary :  main class for all run.
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {

    private static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    /*public void handlerAdded( ChannelHandlerContext ctx) throws Exception{
        Channel incoming = ctx.channel();

        for (Channel channel : channels){
            //channel.metadata();
            channel.writeAndFlush("[SERVER]" + channel.metadata());
        }
        channels.add(ctx.channel());
    }*/


    /*public void handlerRemoved( ChannelHandlerContext ctx) throws  Exception{
        Channel incoming = ctx.channel();

        for (Channel channel : channels){
            channel.writeAndFlush("[SERVER]" + incoming.remoteAddress() + " has left !\n");
        }
        channels.remove(ctx.channel());
    }
*/
    /*******************************************************
     * Write and flush the message recive to the other clients
     * Name :    channelRead0()
     * param :
     *          ctx channel handler context get the channel source
     *          msg String the text message to send
     * return : -
    ********************************************************/
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel incoming = ctx.channel();
        for (Channel channel : channels){
            if( channel != incoming ){
                channel.writeAndFlush( msg + "\n");
            }
        }
    }
}