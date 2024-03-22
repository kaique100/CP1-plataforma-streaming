package br.com.fiap.plataformaStreaming.model;

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
    private Serie serie;

}
