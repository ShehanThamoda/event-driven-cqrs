package lk.dialog.eventdriven.orderservice.command.aggregrate;


import lk.dialog.eventdriven.orderservice.command.command.CreateOrderCommand;
import lk.dialog.eventdriven.orderservice.command.command.UpdateOrderCommand;
import lk.dialog.eventdriven.orderservice.common.event.NotificationSentEvent;
import lk.dialog.eventdriven.orderservice.common.event.OrderCreatedEvent;
import lk.dialog.eventdriven.orderservice.common.event.OrderUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private String name;
    private String status;
    private String message;

    public OrderAggregate() {
    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand) {
        log.info("CreateOrderCommand received...");
        AggregateLifecycle.apply(new OrderCreatedEvent(
                createOrderCommand.getId(),
                createOrderCommand.getName()));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent orderCreatedEvent) {
        log.info("An OrderCreatedEvent occurred...");
        this.orderId = orderCreatedEvent.getId();
        this.name = orderCreatedEvent.getName();
        this.status = "CREATED";
        AggregateLifecycle.apply(new NotificationSentEvent(this.orderId, "ORDER_COMPLETED"));
    }

    @EventSourcingHandler
    public void on(NotificationSentEvent notificationSentEvent) {
        log.info("An NotificationSentEvent occurred...");
        this.message = notificationSentEvent.getMessage();
        log.info("Message Sent to the customer."+message);
    }

    @CommandHandler
    public void on(UpdateOrderCommand updateOrderCommand) {
        log.info("UpdateOrderCommand received.");
        AggregateLifecycle.apply(new OrderUpdatedEvent(
                updateOrderCommand.getId(),
                updateOrderCommand.getName()));
    }

    @EventSourcingHandler
    public void on(OrderUpdatedEvent orderUpdatedEvent) {
        log.info("An OrderUpdatedEvent occurred.");
        this.name = orderUpdatedEvent.getName();
        this.status = "UPDATED";
    }
}
