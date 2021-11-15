package lk.dialog.eventdriven.orderservice.command.command;


/**
 * @author shehan
 **/
public class UpdateOrderCommand extends BaseCommand<String> {

    private final String name;

    public UpdateOrderCommand(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
