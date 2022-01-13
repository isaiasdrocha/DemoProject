package br.com.isaiasdrocha.demo.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.isaiasdrocha.demo.forum.model.Curso;
import br.com.isaiasdrocha.demo.forum.model.Topico;
import br.com.isaiasdrocha.demo.forum.repository.CursoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TopicoForm {

	@NotNull @NotBlank  @NotEmpty @Size(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Size(min = 10)
	private String mensagem;
	
	@NotNull @NotEmpty
	private String nomeCurso;
	
	
	
	public Topico converter(CursoRepository cursoRepository) {
		
		Curso curso = cursoRepository.findByNome(nomeCurso);
		
		return new Topico(this.titulo, this.mensagem, curso);
	}
	
}