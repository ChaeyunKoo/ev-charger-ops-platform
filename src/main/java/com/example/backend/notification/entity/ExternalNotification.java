package com.example.backend.notification.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "external_notification")
public class ExternalNotification {
    @Id
    @Column(name = "ext_notif_id", nullable = false)
    private Integer extNotifId;

    @Column(name = "message", columnDefinition = "TEXT", nullable = false)
    private String message;

    @Column(name = "test_mail", columnDefinition = "TEXT")
    private String testMail;

    @Column(name = "chger_time", nullable = false)
    private LocalDateTime chgerTime;
    
    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "chgerId")
    private ChargerLog chargerlog;

    @Column(name = "stat_id", length = 8, nullable = false)
    private ChargerLog chargerlog;

}