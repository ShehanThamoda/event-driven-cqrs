package lk.dialog.eventdriven.orderservice.common.event;


/**
 * @author shehan
 **/
public class NotificationSentEvent extends BaseEvent<String> {

    private final String message;

    public NotificationSentEvent(String id, String message) {
        super(id);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
