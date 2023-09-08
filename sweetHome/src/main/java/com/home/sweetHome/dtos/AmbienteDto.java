package com.home.sweetHome.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AmbienteDto(
        @NotBlank
        Long id,
        @NotBlank
        String descricao,
        @NotNull
        Long localId) {
}
