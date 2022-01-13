package br.com.isaiasdrocha.demo.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.isaiasdrocha.demo.forum.model.Topico;
import br.com.isaiasdrocha.demo.forum.repository.TopicoRepository;
import lombok.Data;

@Data
public class AtualizacaoTopicoForm {

	@NotNull
	/* @NotBlank */ @NotEmpty @Size(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Size(min = 10)
	private String mensagem;

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getById(id);
		
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		
		return topico;
	}
	
}