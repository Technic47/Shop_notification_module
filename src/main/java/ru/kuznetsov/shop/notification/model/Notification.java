package ru.kuznetsov.shop.notification.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "notification")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;
    @Column(name = "owner_id")
    private String ownerId;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "comment")
    private String comment;
}
