package ru.kuznetsov.shop.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.notification.model.Notification;
import ru.kuznetsov.shop.notification.repository.NotificationRepository;
import ru.kuznetsov.shop.represent.contract.order.BucketItemContract;
import ru.kuznetsov.shop.represent.dto.order.BucketItemDto;
import ru.kuznetsov.shop.represent.dto.order.SellerNotificationDto;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final BucketItemContract bucketItemService;

    public Collection<SellerNotificationDto> findAllByOwnerId(String sellerId) {
        return notificationRepository.findAllByOwnerId(sellerId).stream()
                .map(entity -> {
                    SellerNotificationDto dto = new SellerNotificationDto();
                    dto.setId(entity.getId());
                    dto.setOwnerId(entity.getOwnerId());
                    dto.setOrderId(entity.getOrderId());
                    dto.setProducts(getBuckerItems(entity));
                    return dto;
                })
                .toList();
    }

    public void addNotification(SellerNotificationDto dto) {
        notificationRepository.save(new Notification(
                null,
                dto.getOwnerId(),
                dto.getOrderId(),
                "Order creation notification"
        ));
    }

    public boolean removeNotification(UUID id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
            return true;
        } else throw new RuntimeException("Notification with id " + id + " not found");
    }

    private Set<BucketItemDto> getBuckerItems(Notification entity) {
        return bucketItemService.getAllByOrderId(entity.getOrderId())
                .stream()
                .filter(bucket -> bucket.getOwnerId().equals(entity.getOwnerId()))
                .collect(Collectors.toSet());
    }
}
