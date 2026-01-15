package ru.kuznetsov.shop.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import ru.kuznetsov.shop.business.access.config.DataAccessConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import(DataAccessConfig.class)
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

}
