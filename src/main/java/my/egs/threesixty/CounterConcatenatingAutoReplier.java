package my.egs.threesixty;


public interface CounterConcatenatingAutoReplier extends AutoReplier {

    //TODO
    @Override
    default String autoReplyMessage(String simpleMessage) {
        return null;
    }
}
