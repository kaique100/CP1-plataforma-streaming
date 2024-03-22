package br.com.fiap.plataformaStreaming.controller;

import br.com.fiap.plataformaStreaming.controller.dto.SerieDTO;
import br.com.fiap.plataformaStreaming.model.Serie;
import br.com.fiap.plataformaStreaming.repository.SerieRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serie")
public class SerieController {
    @Autowired
    private SerieRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Serie> createSerie(@RequestBody @Valid SerieDTO serieDTO){
        if (serieDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        Serie serie = new Serie(serieDTO.titulo(), serieDTO.descricao(), serieDTO.anoLancamento(), serieDTO.genero(), serieDTO.episodios());
        serie = repository.save(serie);

        return ResponseEntity.ok(serie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> buscarFilmePorId(@PathVariable Long id) {
        Serie serie = repository.getReferenceById(id);
        return ResponseEntity.ok(serie);
    }

    @GetMapping("/buscar")
    public List<Serie> findSerieByTitleOrGenerOrReleaseYearOrSeasonNumber(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) Integer anoLancamento,
            @RequestParam(required = false) Integer temporada) {

        // Verifica se algum parâmetro foi fornecido para a consulta
        if (titulo == null && genero == null && anoLancamento == null && temporada == null) {
            // Se nenhum parâmetro for fornecido, retorna todos os filmes
            return repository.findAll();
        } else {
            // Se algum parâmetro for fornecido, realiza a consulta personalizada
            return repository.findByTituloContainingOrGeneroContainingOrAnoLancamentoOrEpisodios_Temporada(titulo, genero, anoLancamento, temporada);
        }
    }

    @GetMapping
    public ResponseEntity<List<Serie>> findAllSeries() {
        List<Serie> serie = repository.findAll();
        return ResponseEntity.ok(serie);
    }


    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
