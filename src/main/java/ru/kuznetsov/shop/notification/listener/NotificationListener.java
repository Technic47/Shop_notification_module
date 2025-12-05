package ru.kuznetsov.shop.notification.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.kuznetsov.shop.notification.service.NotificationService;
import ru.kuznetsov.shop.represent.dto.order.SellerNotificationDto;

import static ru.kuznetsov.shop.represent.common.KafkaConst.SELLER_NOTIFICATION_TOPIC;

@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationService notificationService;

    @KafkaListener(topics = SELLER_NOTIFICATION_TOPIC, groupId = "${spring.kafka.consumer.group-id}")
    public void saveNotification(SellerNotificationDto notificationDto) {
        notificationService.addNotification(notificationDto);
    }
}
