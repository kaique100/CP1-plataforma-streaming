package br.com.fiap.plataformaStreaming.controller.dto;

import br.com.fiap.plataformaStreaming.model.Serie;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodioDTO {
    @NotBlank
    private String titulo;

    @NotNull
    private Integer numeroEpisodio;

    @NotNull
    private Integer temporada;

    @NotNull @Valid
    private Serie serie;
}
