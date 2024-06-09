package com.example.agro_futuro_api.repositories;

import com.example.agro_futuro_api.models.CultivationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CultivationRepository extends JpaRepository<CultivationModel, Integer> {
}
