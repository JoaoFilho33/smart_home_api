package com.home.sweetHome.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

public record AmbienteDto(
        String descricao,
        UUID localId) {
}
