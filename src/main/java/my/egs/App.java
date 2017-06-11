package my.egs;

import my.egs.threesixty.Conversation;
import my.egs.threesixty.Player;

import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getSimpleName());

    public static void main(String[] args ) {
        Player messageInitiator= new Player("messageInitiator", 10, false);
        Player messageReplier = new Player("messagePlayer", 0, true);
        LOG.info("Starting conversation...");
        new Conversation().registerInitiator(messageInitiator)
                 .registerReceiver(messageReplier)
                 .startConversation();
        LOG.info("...End of conversation");
    }

}
