package br.com.isaiasdrocha.demo.forum.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.isaiasdrocha.demo.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	List<Topico> findByCursoNome(String nomeCurso);
	Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);
	
	@Query("SELECT t FROM  Topico t WHERE t.curso.nome = :nomeCurso")
	List<Topico> exemploPesquisaPersonalizado(@Param("nomeCurso") String nomeCurso);

}