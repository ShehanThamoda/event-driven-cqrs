package lk.dialog.eventdriven.orderservice.command.service;

import lk.dialog.eventdriven.orderservice.command.command.CreateOrderCommand;
import lk.dialog.eventdriven.orderservice.command.command.UpdateOrderCommand;
import lk.dialog.eventdriven.orderservice.command.dto.AuditDto;
import lk.dialog.eventdriven.orderservice.command.dto.OrderUpdateDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderCommandService {

    private final CommandGateway commandGateway;

    public OrderCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> createOrder(AuditDto auditDto){
        return commandGateway.send(new CreateOrderCommand(
                UUID.randomUUID().toString(),
                auditDto.getAuditEvent().getAction())
        );
    }

    public CompletableFuture<String> updateOrder(OrderUpdateDto orderDto){
        return commandGateway.send(new UpdateOrderCommand(
                orderDto.getOrderId(),
                orderDto.getName())
        );
    }

    public void sendAuditEvent(AuditDto auditDto){
        System.out.println("***************************Called the evenet*********");
    }
}
