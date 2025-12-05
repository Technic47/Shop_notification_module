package ru.kuznetsov.shop.notification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.represent.dto.order.SellerNotificationDto;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface NotificationRepository extends CrudRepository<SellerNotificationDto, UUID> {

    Collection<SellerNotificationDto> findAllByOwnerId(String ownerId);
}
