package lk.dialog.eventdriven.orderservice.command.command;


/**
 * @author shehan
 **/
public class CreateOrderCommand extends BaseCommand<String> {

    private final String name;

    public CreateOrderCommand(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
