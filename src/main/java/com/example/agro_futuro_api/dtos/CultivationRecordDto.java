package com.example.agro_futuro_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.time.LocalDate;

public record CultivationRecordDto(@NotNull LocalDate planting_date,
                                   @NotNull LocalDate harvest_date,
                                   @NotBlank String varieties,
                                   @NotNull Double area) {
}
