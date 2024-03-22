package br.com.fiap.plataformaStreaming.model;


import br.com.fiap.plataformaStreaming.controller.dto.FilmeDTO;
import br.com.fiap.plataformaStreaming.controller.dto.FilmeUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Filme {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private Integer anoLancamento;
    private String diretor;
    private String genero;

    public void atualizarInformacoes(FilmeUpdateDTO filmeUpdate) {
        if (filmeUpdate.titulo() != null){
            this.titulo = filmeUpdate.titulo();
        }

        if (filmeUpdate.descricao() != null){
            this.descricao = filmeUpdate.descricao();
        }

        if (filmeUpdate.anoLancamento() != null){
            this.anoLancamento = filmeUpdate.anoLancamento();
        }

        if (filmeUpdate.diretor() != null){
            this.diretor = filmeUpdate.diretor();
        }

        if (filmeUpdate.genero() != null){
            this.genero = filmeUpdate.genero();
        }

    }
}
