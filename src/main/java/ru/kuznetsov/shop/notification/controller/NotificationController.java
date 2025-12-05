package ru.kuznetsov.shop.notification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kuznetsov.shop.notification.service.NotificationService;
import ru.kuznetsov.shop.represent.dto.order.SellerNotificationDto;

import java.util.Collection;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/{id}")
    public ResponseEntity<Collection<SellerNotificationDto>> findAllByOwnerId(@PathVariable String id) {
        return ResponseEntity.ok(notificationService.findAllByOwnerId(id));
    }
}
