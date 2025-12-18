package ru.kuznetsov.shop.notification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kuznetsov.shop.notification.service.NotificationService;
import ru.kuznetsov.shop.represent.dto.order.SellerNotificationDto;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/{id}")
    public ResponseEntity<Collection<SellerNotificationDto>> findAllByOwnerId(@PathVariable String id) {
        return ResponseEntity.ok(notificationService.findAllByOwnerId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteByOwnerId(@PathVariable String id) {
        return ResponseEntity.ok(notificationService.removeNotification(UUID.fromString(id)));
    }
}
