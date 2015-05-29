package joly.tpi.jdessinario;

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
 * Summary :  Server class to push message
 */
public class ServerHandler extends SimpleChannelInboundHandler<Package> {

    private static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /*******************************************************
     * Summary :    Connect the client to the channel
     * Name :       handlerAdded()
     * param :
     *              ctx channel handler context get the channel source
     * return :     -
     ********************************************************/
    public void handlerAdded( ChannelHandlerContext ctx) throws Exception{

        channels.add(ctx.channel());
    }

    /*******************************************************
     * Summary :    Disconnect the client to the channel
     * Name :       handlerRemoved()
     * param :
     *              ctx channel handler context get the channel source
     * return :     -
     ********************************************************/
    public void handlerRemoved( ChannelHandlerContext ctx) throws  Exception{
        Channel incoming = ctx.channel();

        for (Channel channel : channels){
            channel.writeAndFlush("[SERVER]" + incoming.remoteAddress() + " has left !\n");
        }
        channels.remove(ctx.channel());
    }

    /*******************************************************
     * Summary :    Write and flush the message recive to the other clients
     * Name :       channelRead0()
     * param :
     *              ctx channel handler context get the channel source
     *              msg String the text message to sendMessage
     * return :     -
    ********************************************************/
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Package msg) throws Exception {
        Channel incoming = ctx.channel();

        for (Channel channel : channels){
            if( channel != incoming ){
                channel.writeAndFlush(msg);
                //TODO -> OBject + delete section
                // debug
                System.out.print(msg.categories);
            }
        }
    }
}