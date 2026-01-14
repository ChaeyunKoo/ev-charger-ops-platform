package com.example.backend.monitoring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@IdClass(ImageLogId.class)
@Table(name = "image_log")
public class ImageLog {
    @Id
    @Column(name = "img_id", nullable = false)
    private Integer imgId;

    @Id
    @Column(name = "img_time", nullable = false)
    private LocalDateTime imgTime;

    @Column(name = "img_path", length = 255, nullable = false)
    private String imgPath;

    @Column(name = "stat_id", length = 8, nullable = false)
    private String statId;

}