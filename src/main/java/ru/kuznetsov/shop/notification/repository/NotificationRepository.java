package ru.kuznetsov.shop.notification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.notification.model.Notification;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, UUID> {

    Collection<Notification> findAllByOwnerId(String ownerId);
}
