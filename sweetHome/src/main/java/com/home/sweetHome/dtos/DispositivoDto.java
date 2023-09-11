package com.home.sweetHome.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DispositivoDto(
        String descricao,
        boolean online,
        boolean ligado,
        String cor,
        UUID ambienteId) {
}
