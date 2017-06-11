package my.egs.threesixty;


public interface Initiator<T extends MessageTarget> {

    default void initiateMessageAndSend(T target, String simpleMessage) throws MessageInitiationException {
        OneWayMessageDelivererService.getInstance().deliverMessage(this, target, simpleMessage);
    }

}
