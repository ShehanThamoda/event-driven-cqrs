package lk.dialog.eventdriven.orderservice.common.event;


/**
 * @author Shehan
 **/
public class OrderUpdatedEvent extends BaseEvent<String> {

    private final String name;

    public OrderUpdatedEvent(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
