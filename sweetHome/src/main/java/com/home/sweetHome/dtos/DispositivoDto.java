package com.home.sweetHome.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DispositivoDto(
        @NotBlank Long id,
        @NotBlank String descricao,
        boolean online,
        boolean ligado,
        String cor,
        @NotNull
        Long ambienteId) {
}
