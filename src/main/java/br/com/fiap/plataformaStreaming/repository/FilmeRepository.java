package br.com.fiap.plataformaStreaming.repository;

import br.com.fiap.plataformaStreaming.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
