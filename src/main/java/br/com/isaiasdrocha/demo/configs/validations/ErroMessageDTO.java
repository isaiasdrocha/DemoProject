package br.com.isaiasdrocha.demo.configs.validations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ErroMessageDTO {
	
	private String field;
	private String error;
	
}