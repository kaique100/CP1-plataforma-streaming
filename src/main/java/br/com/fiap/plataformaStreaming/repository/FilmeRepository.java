package br.com.fiap.plataformaStreaming.repository;

import br.com.fiap.plataformaStreaming.model.Filme;
import br.com.fiap.plataformaStreaming.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByTituloContainingOrGeneroContainingOrAnoLancamento(String titulo, String genero, Integer anoLancamento);

}
