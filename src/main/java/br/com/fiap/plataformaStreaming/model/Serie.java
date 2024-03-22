package br.com.fiap.plataformaStreaming.model;


import br.com.fiap.plataformaStreaming.controller.dto.SerieDTO;
import br.com.fiap.plataformaStreaming.controller.dto.SerieUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private Episodio episodios;

    public Serie(SerieDTO serieDTO) {
        this.titulo = serieDTO.titulo();
        this.descricao = serieDTO.descricao();
        this.anoLancamento = serieDTO.anoLancamento();
        this.genero = serieDTO.genero();
    }

    public void atualizarInformacoes(SerieUpdateDTO serieUpdate){

    }
}
