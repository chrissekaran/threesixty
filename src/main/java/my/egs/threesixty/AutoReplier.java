package my.egs.threesixty;


public interface AutoReplier extends LimitedMessagesInitiator, MessageTarget {

    default String autoReplyMessage(String simpleMessage) {
        if(!hasReachedLimitForSendingMessages() && isAutoReplier()) {
            return simpleMessage +" "+count();
        } else {
            return null;
        }
    }

    boolean isAutoReplier();

    boolean hasReachedLimitForSendingMessages();

    @Override
    default void receiveMessage(Initiator source, String simpleMessage) {
        String autoReplyMessage = autoReplyMessage(simpleMessage);
        if(null != autoReplyMessage) {
            MessageTarget replyTo = (MessageTarget) source;
            OneWayMessageDelivererService.getInstance().deliverMessage(this, replyTo, autoReplyMessage(simpleMessage));
        }
    }

}
