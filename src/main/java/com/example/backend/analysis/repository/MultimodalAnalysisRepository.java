package com.example.backend.analysis.repository;

import com.example.backend.analysis.entity.MultimodalAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultimodalAnalysisRepository extends JpaRepository<MultimodalAnalysis, Long> {
}
