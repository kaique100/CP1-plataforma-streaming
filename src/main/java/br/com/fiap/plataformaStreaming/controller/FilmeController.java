package br.com.fiap.plataformaStreaming.controller;


import br.com.fiap.plataformaStreaming.controller.dto.FilmeDTO;
import br.com.fiap.plataformaStreaming.controller.dto.FilmeUpdateDTO;
import br.com.fiap.plataformaStreaming.model.Filme;


import br.com.fiap.plataformaStreaming.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/filme")
public class FilmeController {

    @Autowired
    private FilmeService service;

    @PostMapping
    public ResponseEntity<Filme> createFilme(@RequestBody @Valid FilmeDTO filmeDTO){
        Filme filme = service.createFilme(filmeDTO);
        return ResponseEntity.ok(filme);
    }

    @GetMapping("/{id}")
    public Filme buscarFilmePorId(@PathVariable Long id) {
        return service.buscarFilmePorId(id);
    }

    @GetMapping("/buscar")
    public List<Filme> buscarFilmesPorTituloGeneroOuAno(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) Integer anoLancamento) {

        // Verifica se algum parâmetro foi fornecido para a consulta
        if (titulo == null && genero == null && anoLancamento == null) {
            // Se nenhum parâmetro for fornecido, retorna todos os filmes
            return service.buscarFilmesPorTituloGeneroOuAno(titulo, genero, anoLancamento);
        } else {
            // Se algum parâmetro for fornecido, realiza a consulta personalizada
            return service.buscarFilmesPorTituloGeneroOuAno(titulo, genero, anoLancamento);
        }
    }

    @GetMapping
    public List<Filme> buscarTodosFilmes() {
        return service.buscarTodosFilmes();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Filme> atualizarFilme(@RequestBody @Valid FilmeUpdateDTO filmeUpdateDTO){
        Filme filme = service.atualizarFilme(filmeUpdateDTO);
        filme.atualizarInformacoes(filmeUpdateDTO);
        return ResponseEntity.ok(filme);
    }

    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id) {
        service.deletarFilme(id);
    }
}
