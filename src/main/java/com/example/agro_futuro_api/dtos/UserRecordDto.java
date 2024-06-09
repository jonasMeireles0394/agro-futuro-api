package com.example.agro_futuro_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(@NotBlank(message = "O nome de usuário não deve estar em branco") String username,
                            @NotBlank(message = "O nome do usuário não deve estar em branco") String name,
                            @NotBlank(message = "O nome da propriedade não deve estar em branco") String property,
                            @NotBlank(message = "A senha não deve estar em branco") String password) {

}
