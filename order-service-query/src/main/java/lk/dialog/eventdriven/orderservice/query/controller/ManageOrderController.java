package lk.dialog.eventdriven.orderservice.query.controller;

import lk.dialog.eventdriven.orderservice.query.entity.Orderr;
import lk.dialog.eventdriven.orderservice.query.query.FindOrderByIdQuery;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ManageOrderController {

    private final QueryGateway queryGateway;

    public ManageOrderController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(value = "/get-order")
    public ResponseEntity<Orderr> getOrder(@RequestParam String id){
        log.info("Called get Order.Order Id: {}",id);
        Orderr orderr = queryGateway.query(
                new FindOrderByIdQuery(id), Orderr.class
        ).join();
        if (orderr ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderr,HttpStatus.OK);
    }
}
