package br.com.isaiasdrocha.demo.forum.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.isaiasdrocha.demo.forum.controller.form.AtualizacaoTopicoForm;
import br.com.isaiasdrocha.demo.forum.controller.form.TopicoForm;
import br.com.isaiasdrocha.demo.forum.dto.DetalhesTopicoDto;
import br.com.isaiasdrocha.demo.forum.dto.TopicoDto;
import br.com.isaiasdrocha.demo.forum.model.Topico;
import br.com.isaiasdrocha.demo.forum.repository.CursoRepository;
import br.com.isaiasdrocha.demo.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso){
		
		List<Topico> topicos = null;
		if (nomeCurso == null)
			topicos = topicoRepository.findAll();
		else
			topicos = topicoRepository.findByCursoNome(nomeCurso);
		
		return TopicoDto.converter(topicos);
	}
	
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		
		Topico topico = form.converter(cursoRepository);
		
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	@GetMapping("/{id}")
	public DetalhesTopicoDto detalhar(@PathVariable Long id) {
		
		Topico topico = topicoRepository.getById(id);
		return new DetalhesTopicoDto(topico);
	}
	
	//@PatchMapping //pequena alteraçao
	@PutMapping("/{id}") //Alteracao completa - Mais comum no desenv
	@Transactional // Avisa o spring que tem que realizar o commit no final do método
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
		
		Topico topico = form.atualizar(id, topicoRepository);
		
		return ResponseEntity.ok(new TopicoDto(topico));
		
	}
	
}