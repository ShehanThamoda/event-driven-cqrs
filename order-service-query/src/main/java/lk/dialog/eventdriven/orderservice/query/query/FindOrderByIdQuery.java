package lk.dialog.eventdriven.orderservice.query.query;

import lombok.Data;

@Data
public class FindOrderByIdQuery {
    private String orderId;

    public FindOrderByIdQuery(String orderId) {
        this.orderId = orderId;
    }
}
