package lk.dialog.eventdriven.orderservice.query.repository;

import lk.dialog.eventdriven.orderservice.query.entity.Orderr;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orderr,String> {

    //Orderr findByOrderId(String id);
}
