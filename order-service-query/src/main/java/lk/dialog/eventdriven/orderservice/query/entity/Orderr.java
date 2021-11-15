package lk.dialog.eventdriven.orderservice.query.entity;


import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;

@RedisHash("Orderr")
public class Orderr implements Serializable {

    //@Id
    private String id;

    private String name;

    private String status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

}
