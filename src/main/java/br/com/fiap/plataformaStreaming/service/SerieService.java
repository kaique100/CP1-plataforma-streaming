package br.com.fiap.plataformaStreaming.service;

import br.com.fiap.plataformaStreaming.controller.dto.SerieDTO;
import br.com.fiap.plataformaStreaming.controller.dto.SerieUpdateDTO;
import br.com.fiap.plataformaStreaming.model.Serie;
import br.com.fiap.plataformaStreaming.repository.SerieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {
    private SerieRepository repository;

    public Serie createSerie(SerieDTO serieDTO){
        Serie serie = new Serie(serieDTO.titulo(), serieDTO.descricao(), serieDTO.anoLancamento(), serieDTO.genero(), serieDTO.episodios());
        serie = repository.save(serie);

        return serie;
    }

    public Serie buscarSeriePorId(Long id) {
        return repository.getReferenceById(id);
    }

    public List<Serie> buscarSeriesPorTituloGeneroAnoOuQtdTemporadas(String titulo, String genero, Integer anoLancamento, Integer temporada) {

        // Verifica se algum parâmetro foi fornecido para a consulta
        if (titulo == null && genero == null && anoLancamento == null && temporada == null) {
            // Se nenhum parâmetro for fornecido, retorna todos os Series
            return repository.findAll();
        } else {
            // Se algum parâmetro for fornecido, realiza a consulta personalizada
            return repository.findByTituloContainingOrGeneroContainingOrAnoLancamentoOrEpisodios_Temporada(titulo, genero, anoLancamento, temporada);
        }
    }

    public List<Serie> buscarTodasAsSeries() {
        return repository.findAll();
    }

    public Serie atualizarSerie(SerieUpdateDTO serieUpdateDTO){
        Serie serie = repository.getReferenceById(serieUpdateDTO.id());
        serie.atualizarInformacoes(serieUpdateDTO);
        return serie;
    }

    public void deletarSerie(Long id) {
        repository.deleteById(id);
    }
}
