package lk.dialog.eventdriven.orderservice.query.entity;


import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;

@RedisHash("Orderr")
public class Orderr implements Serializable {

    //@Id
    private String id;

//    private String orderId;

    private String name;

    private String status;
   // private int quantity;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
}
