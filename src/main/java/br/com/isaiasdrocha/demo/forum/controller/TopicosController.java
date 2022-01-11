package br.com.isaiasdrocha.demo.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.isaiasdrocha.demo.forum.dto.TopicoDto;
import br.com.isaiasdrocha.demo.forum.model.Curso;
import br.com.isaiasdrocha.demo.forum.model.Topico;

@RestController
public class TopicosController {

	@RequestMapping(value = "/topicosold", method = RequestMethod.GET)
	public List<Topico> listaOld(){
		Topico topico = new Topico("Dúvida", "Dúvida com spring", new Curso("Spring", "programação"));
		
		return Arrays.asList(topico, topico, topico);
	}
	
	@RequestMapping(value = "/topicos", method = RequestMethod.GET)
	public List<TopicoDto> lista(){
		Topico topico = new Topico("Dúvida", "Dúvida com spring", new Curso("Spring", "programação"));
		
		return TopicoDto.converter(Arrays.asList(topico, topico, topico));
	}
}