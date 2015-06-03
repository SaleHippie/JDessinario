package joly.tpi.jdessinario;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 20.05.2015.
 * Summary :  Client channel reader,
 * read the channel and show messages
 */
public class ClientHandler extends SimpleChannelInboundHandler<Package>{
    /************************************
     * Summary :    read the channel
     * Name :       channelRead0()
     * param :
     *              ctx channel handler context get the channel source
     *              msg String the text message to sendMessage
     * Return :     -
     **************************************/
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Package msg) throws Exception {
        JDessinario main = new JDessinario();

        switch (msg.getCategories()){
            case ANSWER:
                main.showAnswerReceived(msg.getText());
                break;
            case CHAT:
                main.showMessageReceived(msg.getText());
                break;
            case DRAW:
                main.showDrawReceived(msg.getX(), msg.getY(), msg.getMode());
                break;

            default:
                //TODO implement incomplete packet received
                break;
        }

    }


}