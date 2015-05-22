import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 20.05.2015.
 * Summary :  Client channel reader,
 * read the channel and show messages
 */
public class ClientHandler extends SimpleChannelInboundHandler<Categories>{
    /************************************
     * Summary :    read the channel
     * Name :       channelRead0()
     * param :
     *              ctx channel handler context get the channel source
     *              msg String the text message to send
     * Return :     -
     **************************************/
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Categories msg) throws Exception {
        JDessinario main = new JDessinario();


        System.out.println( "Texte : " + msg.Type);

        switch (msg.Type){
            case "answer":
                main.showAnswerReceived(msg.getText());
                break;
            case "chat":
                main.showMessageReceived(msg.getText());
                break;

            default:
                break;
        }

    }


}