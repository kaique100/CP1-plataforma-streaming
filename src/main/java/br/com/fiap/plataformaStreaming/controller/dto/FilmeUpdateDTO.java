package br.com.fiap.plataformaStreaming.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FilmeUpdateDTO(
        @NotNull
        Long id,
        String titulo,
        String descricao,

        Integer anoLancamento,

        String diretor,

        String genero) {
}
