package br.com.fiap.plataformaStreaming.controller.dto;

import jakarta.validation.constraints.NotNull;

public record SerieUpdateDTO(
        @NotNull
        Long id,

        String titulo,
        String descricao,
        Integer anoLancamento,
        String genero) {
}
