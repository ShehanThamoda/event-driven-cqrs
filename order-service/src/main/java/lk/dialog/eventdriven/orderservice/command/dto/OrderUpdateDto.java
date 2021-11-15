package lk.dialog.eventdriven.orderservice.command.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderUpdateDto {
    private String orderId;
    private String name;
    private int quantity;
}
