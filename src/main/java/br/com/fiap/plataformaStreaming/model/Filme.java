package br.com.fiap.plataformaStreaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {
    private Long id;
    private String titulo;
    private String descricao;
    private Integer anoLancamento;
    private String diretor;
    private String genero;
}
