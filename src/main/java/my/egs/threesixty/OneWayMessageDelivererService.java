package my.egs.threesixty;


public class OneWayMessageDelivererService implements OneWayMessageDeliverer {

    private static OneWayMessageDelivererService instance;

    private OneWayMessageDelivererService() {

    }

    public static OneWayMessageDeliverer getInstance() {
        if(instance == null) {
            instance = new OneWayMessageDelivererService();
        }
        return instance;
    }
}
