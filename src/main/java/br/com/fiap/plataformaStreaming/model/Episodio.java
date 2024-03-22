package br.com.fiap.plataformaStreaming.model;

import br.com.fiap.plataformaStreaming.controller.dto.EpisodioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Episodio {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private Integer numeroEpisodio;
    private Integer temporada;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    @JsonIgnore
    private Serie serie;

    public Episodio(EpisodioDTO episodioDTO) {
        this.titulo = episodioDTO.titulo();
        this.numeroEpisodio = episodioDTO.numeroEpisodio();
        this.temporada = episodioDTO.temporada();
        this.serie = new Serie(episodioDTO.serie());
    }

    public Episodio(String titulo, Integer numeroEpisodio, Integer temporada) {
        this.titulo = titulo;
        this.numeroEpisodio = numeroEpisodio;
        this.temporada = temporada;
    }
}
