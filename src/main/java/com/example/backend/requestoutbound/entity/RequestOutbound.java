package com.example.backend.requestoutbound.entity;

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
@Table(name = "request_outbound")
public class RequestOutbound {
    @Id
    @Column(name = "proc_id", nullable = false)
    private Integer procId;

    @Column(name = "answer", columnDefinition = "TEXT", nullable = false)
    private String answer;

    @Column(name = "answer_dt", nullable = false)
    private LocalDateTime answerDt;

    @Column(name = "req_id", nullable = false)
    private Integer reqId;
}