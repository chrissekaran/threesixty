package my.egs.threesixty;

import java.util.concurrent.atomic.AtomicInteger;


public final class Player implements LimitedMessagesInitiator, MessageTarget, AutoReplier {

    private final String playerName;
    private final boolean autoReplier;
    private final AtomicInteger messageCountLimit;

    public Player(final String playerName,
                  int messageCountLimit,
                  boolean isAutoReplier) {
        this.playerName = playerName;
        this.messageCountLimit = new AtomicInteger(messageCountLimit);
        this.autoReplier = isAutoReplier;
    }


    @Override
    public boolean isAutoReplier() {
        return autoReplier;
    }

    @Override
    public boolean hasReachedLimitForSendingMessages() {
        return (messageCountLimit.decrementAndGet() > 0)? false : true;
    }

    @Override
    public int count() {
        return messageCountLimit.get();
    }
}
