package br.com.fiap.plataformaStreaming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Episodio {
    private Long id;
    private String titulo;
    private Integer numeroEpisodio;
    private Integer temporada;
    private Serie serie;
}
