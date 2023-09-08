package com.home.sweetHome.dtos;

import jakarta.validation.constraints.NotBlank;

public record LocalDto(
        @NotBlank
        Long id,
        @NotBlank
        String descricao
) {
}
