package lk.dialog.eventdriven.orderservice.query.service;

import lk.dialog.eventdriven.orderservice.common.event.OrderCreatedEvent;
import lk.dialog.eventdriven.orderservice.common.event.OrderUpdatedEvent;
import lk.dialog.eventdriven.orderservice.query.entity.Orderr;
import lk.dialog.eventdriven.orderservice.query.query.FindOrderByIdQuery;
import lk.dialog.eventdriven.orderservice.query.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ManageOrderService {

    private final OrderRepository orderRepository;

    public ManageOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @EventHandler
    public void on(OrderCreatedEvent orderCreatedEvent){
        log.info("Handling OrderCreatedEvent...START");
        Orderr orderr = new Orderr();
        orderr.setId(orderCreatedEvent.getId());
        orderr.setName(orderCreatedEvent.getName());
        orderr.setStatus("CREATED");
        orderRepository.save(orderr);
        log.info("Handling OrderCreatedEvent...END");
    }

    @EventHandler
    public void on(OrderUpdatedEvent orderUpdatedEvent) {
        log.info("Handling OrderUpdatedEvent...");
        Orderr orderr = orderRepository.findById(orderUpdatedEvent.getId()).get();
        if (orderr != null) {
            orderr.setName(orderUpdatedEvent.getName());
            orderRepository.save(orderr);
        }
    }

    @QueryHandler
    public Orderr handle(FindOrderByIdQuery query){
        log.info("Handling FindOrderByIdQuery...");
        Orderr orderr = orderRepository.findById(query.getOrderId()).get();
        return orderr;
    }
}
