package my.egs.threesixty;


import java.util.logging.Level;
import java.util.logging.Logger;


public class Conversation<T extends LimitedMessagesInitiator, U extends MessageTarget> {

    private static Logger LOG = Logger.getLogger(Conversation.class.getSimpleName());

    private LimitedMessagesInitiator initiator;
    private MessageTarget receiver;

    public Conversation registerInitiator(T messageInitiator) {
        initiator = messageInitiator;
        return this;
    }

    public Conversation registerReceiver(U messageTarget) {
        receiver = messageTarget;
        return this;
    }

    public void startConversation() {
        try {
            while(true) {
                initiator.initiateMessageAndSend(receiver, "Hello!");
            }
        } catch (MessageInitiationException e) {
            LOG.log(Level.WARNING, e.getMessage());
        }
    }
}
