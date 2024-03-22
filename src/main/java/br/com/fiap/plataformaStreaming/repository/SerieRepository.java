package br.com.fiap.plataformaStreaming.repository;

import br.com.fiap.plataformaStreaming.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    List<Serie> findByTituloContainingOrGeneroContainingOrAnoLancamentoOrEpisodios_Temporada(String titulo, String genero, Integer anoLancamento, Integer temporada);

}
