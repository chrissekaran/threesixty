package my.egs.threesixty;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by chrissekaran on 11/06/17.
 */
public interface OneWayMessageDeliverer<T extends Initiator, U extends MessageTarget> {

    Logger LOG = Logger.getLogger(OneWayMessageDeliverer.class.getSimpleName());

    default void deliverMessage(T source, U target, String message) {
        LOG.log(Level.INFO, "Source: "+source+ " Target: "+target+" Message: "+message);
        target.receiveMessage(source, message);
    }

}
