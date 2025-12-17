package ru.kuznetsov.shop.notification.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.kuznetsov.shop.notification.service.NotificationService;
import ru.kuznetsov.shop.represent.dto.order.SellerNotificationDto;

import static ru.kuznetsov.shop.represent.common.KafkaConst.SELLER_NOTIFICATION_TOPIC;

@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationService notificationService;
    private final ObjectMapper objectMapper;

    Logger logger = LoggerFactory.getLogger(NotificationListener.class);

    @KafkaListener(topics = SELLER_NOTIFICATION_TOPIC, groupId = "${spring.kafka.consumer.group-id}")
    public void saveNotification(String notificationDtoJson) {
        logger.info("Saving notification: {}", notificationDtoJson);

        try {
            notificationService.addNotification(
                    objectMapper.readValue(notificationDtoJson, SellerNotificationDto.class)
            );

            logger.info("Notification has been saved successfully");
        } catch (Exception e) {
            logger.error("Error while saving notification", e);
        }
    }
}
