package br.com.isaiasdrocha.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.isaiasdrocha.demo.api.RestVerbsApi;
import br.com.isaiasdrocha.demo.domain.MessageResponse;
import br.com.isaiasdrocha.demo.domain.SuccessResponse;
import br.com.isaiasdrocha.demo.enums.EnumParam;

@RestController
public class RestVerbsApiController implements RestVerbsApi {

	@Override
	public ResponseEntity<?> methdNameOne(Integer param1, String param2, EnumParam enumParam3,
			String param4) {
		
		return new ResponseEntity<>(new MessageResponse(param1, param2), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> methodName(String param1) {
		return new ResponseEntity<>(new SuccessResponse(param1), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> methdPost(String param1) {
		return null;
	}

	@Override
	public ResponseEntity<?> methDelete(String param1) {
		return null;
	}

	@Override
	public ResponseEntity<?> methPut(String param1) {
		return null;
	}

}