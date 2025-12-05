package ru.kuznetsov.shop.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.notification.repository.NotificationRepository;
import ru.kuznetsov.shop.represent.dto.order.SellerNotificationDto;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public Collection<SellerNotificationDto> findAllByOwnerId(String sellerId) {
        return notificationRepository.findAllByOwnerId(sellerId);
    }

    public void addNotification(SellerNotificationDto sellerNotificationDto) {
        notificationRepository.save(sellerNotificationDto);
    }
}
