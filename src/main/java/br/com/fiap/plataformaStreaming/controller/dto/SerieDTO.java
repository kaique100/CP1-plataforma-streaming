package br.com.fiap.plataformaStreaming.controller.dto;

import br.com.fiap.plataformaStreaming.model.Episodio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SerieDTO(
        @NotBlank
        String titulo,

        @NotBlank
        String descricao,

        @NotNull
        Integer anoLancamento,

        @NotBlank
        String genero,

        @NotNull
        List<EpisodioDTO> episodios
) {

}
