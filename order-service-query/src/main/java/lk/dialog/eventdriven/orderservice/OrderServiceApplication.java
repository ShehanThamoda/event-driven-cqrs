package lk.dialog.eventdriven.orderservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class OrderServiceApplication {

    private final BeanFactory beanFactory;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
