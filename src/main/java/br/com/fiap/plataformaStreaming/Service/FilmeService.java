package br.com.fiap.plataformaStreaming.Service;

import br.com.fiap.plataformaStreaming.controller.dto.FilmeDTO;
import br.com.fiap.plataformaStreaming.model.Filme;
import br.com.fiap.plataformaStreaming.repository.FilmeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;
    private final AtomicLong counter = new AtomicLong();

    public void createFilme(FilmeDTO filmeDTO){
        repository.save()
    }

}
