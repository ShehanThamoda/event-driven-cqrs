package lk.dialog.eventdriven.orderservice.common.event;


/**
 * @author shehan
 **/
public class OrderCreatedEvent extends BaseEvent<String> {

    private final String name;

    public OrderCreatedEvent(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
