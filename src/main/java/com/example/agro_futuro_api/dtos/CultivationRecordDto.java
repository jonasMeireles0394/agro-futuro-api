package com.example.agro_futuro_api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CultivationRecordDto(@NotNull (message = "Id do usuário não pode ser nulo") int id_user,
                                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                                   LocalDate planting_date,
                                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                                   LocalDate harvest_date,
                                   @NotBlank (message = "Varieties não deve estar em branco")
                                   String varieties,
                                   @NotNull(message = "Área não pode ser nulo")
                                   Double area) {
}
