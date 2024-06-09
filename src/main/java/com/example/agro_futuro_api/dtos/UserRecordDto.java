package com.example.agro_futuro_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecordDto(@NotBlank String user_name, @NotNull int user_password) {
}
