package br.com.fiap.plataformaStreaming.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EpisodioDTO(

        @NotBlank
        String titulo,

        @NotNull
        Integer numeroEpisodio,

        @NotNull
        Integer temporada,

        @NotNull
        SerieDTO serie
) {
}
