package com.example.backend.monitoring.repository;

import com.example.backend.chargingstation.entity.ChargerLog;
import com.example.backend.chargingstation.entity.ChargerLogId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargerLogRepository extends JpaRepository<ChargerLog, ChargerLogId> {

    @Query("SELECT cl FROM ChargerLog cl WHERE cl.chgerTime = " +
           "(SELECT MAX(cl2.chgerTime) FROM ChargerLog cl2 " +
           "WHERE cl2.chgerId = cl.chgerId AND cl2.statId = cl.statId " +
           "AND cl2.zcode = cl.zcode AND cl2.zscode = cl.zscode AND cl2.busiId = cl.busiId)")
    List<ChargerLog> findLatestLogs();

    @Query("SELECT cl.stat, COUNT(cl) FROM ChargerLog cl WHERE cl.chgerTime = " +
           "(SELECT MAX(cl2.chgerTime) FROM ChargerLog cl2 " +
           "WHERE cl2.chgerId = cl.chgerId AND cl2.statId = cl.statId " +
           "AND cl2.zcode = cl.zcode AND cl2.zscode = cl.zscode AND cl2.busiId = cl.busiId) " +
           "GROUP BY cl.stat")
    List<Object[]> countByStatGrouped();
}
