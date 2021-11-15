package lk.dialog.eventdriven.orderservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@RequiredArgsConstructor
//@ComponentScan("lk.dialog.eventdriven.orderservice.*")
//@EnableMongoRepositories(basePackages = "lk.dialog.eventdriven.orderservice.query.repository")
public class OrderServiceApplication {

    private final BeanFactory beanFactory;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
