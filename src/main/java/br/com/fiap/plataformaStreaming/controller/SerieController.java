package br.com.fiap.plataformaStreaming.controller;

import br.com.fiap.plataformaStreaming.controller.dto.SerieDTO;
import br.com.fiap.plataformaStreaming.model.Serie;
import br.com.fiap.plataformaStreaming.repository.SerieRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Serie createFilme(@RequestBody @Valid SerieDTO serieDTO){
        repository.save(new Serie(serieDTO));
    }

    @GetMapping("/{id}")
    public Serie buscarFilmePorId(@PathVariable Long id) {
        return repository.getReferenceById(id);
    }

    @GetMapping("/buscar")
    public List<Filme> buscarFilmesPorTituloGeneroEAno(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) Integer anoLancamento) {

        // Verifica se algum parâmetro foi fornecido para a consulta
        if (titulo == null && genero == null && anoLancamento == null) {
            // Se nenhum parâmetro for fornecido, retorna todos os filmes
            return repository.findAll();
        } else {
            // Se algum parâmetro for fornecido, realiza a consulta personalizada
            return repository.fin(titulo, genero, anoLancamento);
        }
    }

    @GetMapping
    public List<Filme> buscarTodosFilmes() {
        return repository.findAll();
    }


    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
