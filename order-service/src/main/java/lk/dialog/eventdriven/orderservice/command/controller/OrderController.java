package lk.dialog.eventdriven.orderservice.command.controller;

import lk.dialog.eventdriven.orderservice.command.dto.AuditDto;
import lk.dialog.eventdriven.orderservice.command.dto.OrderUpdateDto;
import lk.dialog.eventdriven.orderservice.command.service.OrderCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    @Autowired
    private OrderCommandService orderCommandService;

    @PostMapping(value = "/orders")
    public ResponseEntity<String> placeOrder(@RequestBody AuditDto auditDto) {
           log.info("Called create order controller.OrderDto:{}", auditDto.toString());
           try{
               orderCommandService.createOrder(auditDto);
               return new ResponseEntity<>("Success", org.springframework.http.HttpStatus.CREATED);
           }catch (Exception e){
               return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
           }
    }

    @PutMapping(value = "/orders")
    public String updateOrder(@RequestBody OrderUpdateDto orderDto) {
        log.info("Called update order controller:{}"+ orderDto.toString());
        orderCommandService.updateOrder(orderDto);
        return "Order Update Successfully";
    }

    private Boolean handleErrorCase() {
        return false;
    }
}
