package br.com.fiap.plataformaStreaming.controller;


import br.com.fiap.plataformaStreaming.controller.dto.FilmeDTO;
import br.com.fiap.plataformaStreaming.controller.dto.FilmeUpdateDTO;
import br.com.fiap.plataformaStreaming.model.Filme;
import br.com.fiap.plataformaStreaming.repository.FilmeRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/filme")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @PostMapping
    public ResponseEntity<Filme> createFilme(@RequestBody @Valid FilmeDTO filmeDTO){
        Filme filme = repository.save(new Filme(filmeDTO));
        return ResponseEntity.ok(filme);
    }

    @GetMapping("/{id}")
    public Filme buscarFilmePorId(@PathVariable Long id) {
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
            return repository.findByTituloContainingOrGeneroContainingOrAnoLancamento(titulo, genero, anoLancamento);
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
