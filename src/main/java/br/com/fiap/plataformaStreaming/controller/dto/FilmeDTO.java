package br.com.fiap.plataformaStreaming.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FilmeDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,

        @NotNull
        Integer anoLancamento,

        @NotBlank
        String diretor,

        @NotBlank
        String genero) {
}
