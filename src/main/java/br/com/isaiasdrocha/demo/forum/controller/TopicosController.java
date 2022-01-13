package br.com.isaiasdrocha.demo.forum.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Page<TopicoDto> lista(@RequestParam(required = false) String nomeCurso, 
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
		// v1/topicos?page=0&size=10&sort=id,ASC&sort=DataCriacao,desc
		
		if (nomeCurso == null) {
			Page<Topico> topicos = topicoRepository.findAll(paginacao);
			
			return TopicoDto.converter(topicos);
		}
		else {
			Page<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso, paginacao);
			return TopicoDto.converter(topicos);
		}
	}
	
	@GetMapping("/old")
	public Page<TopicoDto> listaOld(@RequestParam(required = false) String nomeCurso, 
			@RequestParam int pagina, 
			@RequestParam int qtd,
			@RequestParam String ordenacao){
		
		
		Pageable paginacao = PageRequest.of(pagina, qtd, Direction.DESC, ordenacao);
		if (nomeCurso == null) {
			Page<Topico> topicos = topicoRepository.findAll(paginacao);
			
			return TopicoDto.converter(topicos);
		}
		else {
			Page<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso, paginacao);
			return TopicoDto.converter(topicos);
		}
	}
	
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		
		Topico topico = form.converter(cursoRepository);
		
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesTopicoDto> detalhar(@PathVariable Long id) {
		
		Optional<Topico> topico = topicoRepository.findById(id);
		
		if (topico.isPresent())
			return ResponseEntity.ok(new DetalhesTopicoDto(topico.get()));
		else
			return ResponseEntity.notFound().build();		
	}
	
	//@PatchMapping //pequena alteraçao
	@PutMapping("/{id}") //Alteracao completa - Mais comum no desenv
	@Transactional // Avisa o spring que tem que realizar o commit no final do método
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
		Optional<Topico> optional = topicoRepository.findById(id);
		
		if (optional.isPresent()) {
			
			Topico topico = form.atualizar(id, topicoRepository);
			return ResponseEntity.ok(new TopicoDto(topico));
		}
		else
			return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> remover(@PathVariable Long id){
		Optional<Topico> optional = topicoRepository.findById(id);
		
		if (optional.isPresent()) {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else
			return ResponseEntity.notFound().build();		

	}
	
}