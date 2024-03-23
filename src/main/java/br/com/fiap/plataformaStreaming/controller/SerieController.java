package br.com.fiap.plataformaStreaming.controller;

import br.com.fiap.plataformaStreaming.controller.dto.SerieDTO;
import br.com.fiap.plataformaStreaming.controller.dto.SerieUpdateDTO;
import br.com.fiap.plataformaStreaming.model.Serie;
import br.com.fiap.plataformaStreaming.repository.SerieRepository;
import br.com.fiap.plataformaStreaming.service.SerieService;
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
    private SerieService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Serie> createSerie(@RequestBody @Valid SerieDTO serieDTO){
        Serie serie = service.createSerie(serieDTO);
        return ResponseEntity.ok(serie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> buscarFilmePorId(@PathVariable Long id) {
        Serie serie = service.buscarSeriePorId(id);
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
            return service.buscarSeriesPorTituloGeneroAnoOuQtdTemporadas(titulo, genero, anoLancamento, temporada);
        } else {
            // Se algum parâmetro for fornecido, realiza a consulta personalizada
            return service.buscarSeriesPorTituloGeneroAnoOuQtdTemporadas(titulo, genero, anoLancamento, temporada);
        }
    }

    @GetMapping
    public ResponseEntity<List<Serie>> findAllSeries() {
        List<Serie> serie = service.buscarTodasAsSeries();
        return ResponseEntity.ok(serie);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Serie> atualizarSerie(@RequestBody @Valid SerieUpdateDTO serieUpdateDTO){
        Serie serie = service.atualizarSerie(serieUpdateDTO);
        serie.atualizarInformacoes(serieUpdateDTO);
        return ResponseEntity.ok(serie);
    }


    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id) {
        service.deletarSerie(id);
    }
}
