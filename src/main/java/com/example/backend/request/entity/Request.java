package com.example.backend.request.entity;

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
@Table(name = "request")
public class Request {
    @Id
    @Column(name = "req_id", nullable = false)
    private Integer reqId;

    @Column(name = "chger_id", length = 2, nullable = false)
    private String chgerId;

    @Column(name = "stat_id", length = 8, nullable = false)
    private String statId;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "req_type", length = 20, nullable = false)
    private String reqType;

    @Column(name = "req_dt", nullable = false)
    private LocalDateTime reqDt;

    @Column(name = "status", length = 20, nullable = false)
    private String status;
}