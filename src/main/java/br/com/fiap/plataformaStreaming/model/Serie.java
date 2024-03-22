package br.com.fiap.plataformaStreaming.model;


import br.com.fiap.plataformaStreaming.controller.dto.EpisodioDTO;
import br.com.fiap.plataformaStreaming.controller.dto.SerieDTO;
import br.com.fiap.plataformaStreaming.controller.dto.SerieUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Serie {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private Integer anoLancamento;
    private String genero;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<Episodio> episodios = new ArrayList<>();;

    public Serie(SerieDTO serieDTO) {
        this.titulo = serieDTO.titulo();
        this.descricao = serieDTO.descricao();
        this.anoLancamento = serieDTO.anoLancamento();
        this.genero = serieDTO.genero();

        List<EpisodioDTO> episodiosDTO = serieDTO.episodios();

        for (EpisodioDTO episodioDTO : episodiosDTO) {
            Episodio episodio = new Episodio(episodioDTO);
            episodio.setSerie(this); // Define a série para o episódio
            episodios.add(episodio);
        }
    }

    public Serie(String titulo, String descricao, Integer anoLancamento, String genero, List<EpisodioDTO> episodios) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.episodios = new ArrayList<>();

        // Converter cada EpisodioDTO em Episodio e adicionar à lista de episodios
        for (EpisodioDTO episodioDTO : episodios) {
            Episodio episodio = new Episodio(episodioDTO.titulo(), episodioDTO.numeroEpisodio(), episodioDTO.temporada());
            episodio.setSerie(this); // Define a série para o episódio
            this.episodios.add(episodio);
        }
    }

//    public void atualizarInformacoes(SerieUpdateDTO serieUpdate){
//
//    }
}
