package br.com.fiap.plataformaStreaming.service;

import br.com.fiap.plataformaStreaming.controller.dto.FilmeDTO;
import br.com.fiap.plataformaStreaming.controller.dto.FilmeUpdateDTO;
import br.com.fiap.plataformaStreaming.model.Filme;
import br.com.fiap.plataformaStreaming.repository.FilmeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {
    private FilmeRepository repository;

    public Filme createFilme(FilmeDTO filmeDTO){
        Filme filme = repository.save(new Filme(filmeDTO));
        return filme;
    }

    public Filme buscarFilmePorId(Long id) {
        return repository.getReferenceById(id);
    }

    public List<Filme> buscarFilmesPorTituloGeneroOuAno(String titulo,String genero, Integer anoLancamento) {

        // Verifica se algum parâmetro foi fornecido para a consulta
        if (titulo == null && genero == null && anoLancamento == null) {
            // Se nenhum parâmetro for fornecido, retorna todos os filmes
            return repository.findAll();
        } else {
            // Se algum parâmetro for fornecido, realiza a consulta personalizada
            return repository.findByTituloContainingOrGeneroContainingOrAnoLancamento(titulo, genero, anoLancamento);
        }
    }

    public List<Filme> buscarTodosFilmes() {
        return repository.findAll();
    }

    public Filme atualizarFilme(FilmeUpdateDTO filmeUpdateDTO){
        Filme filme = repository.getReferenceById(filmeUpdateDTO.id());
        filme.atualizarInformacoes(filmeUpdateDTO);
        return filme;
    }

    public void deletarFilme(Long id) {
        repository.deleteById(id);
    }
}
