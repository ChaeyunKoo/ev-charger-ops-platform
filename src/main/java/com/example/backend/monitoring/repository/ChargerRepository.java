package com.example.backend.monitoring.repository;

import com.example.backend.chargingstation.entity.Charger;
import com.example.backend.chargingstation.entity.ChargerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargerRepository extends JpaRepository<Charger, ChargerId> {
}
