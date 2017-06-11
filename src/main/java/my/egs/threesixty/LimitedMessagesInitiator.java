package my.egs.threesixty;


public interface LimitedMessagesInitiator extends Initiator {

    boolean hasReachedLimitForSendingMessages();

    int count();

    @Override
    default void initiateMessageAndSend(MessageTarget target, String simpleMessage) throws MessageInitiationException {
        if(hasReachedLimitForSendingMessages()) {
            throw new MessageInitiationException("Limit reached for sending messages");
        } else {
            Initiator.super.initiateMessageAndSend(target, simpleMessage);
        }
    }
}
