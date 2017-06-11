package my.egs.threesixty;


public interface MessageTarget<I extends Initiator> {

    void receiveMessage(I source , String simpleMessage);

}
