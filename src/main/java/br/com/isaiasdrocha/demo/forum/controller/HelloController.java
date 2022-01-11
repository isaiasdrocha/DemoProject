package br.com.isaiasdrocha.demo.forum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("/1")
	@ResponseBody
	public String hello() {
		return "Sucesso!";
	}
	
	@RequestMapping(value = "/2", method = RequestMethod.GET)
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<>("Sucesso+", HttpStatus.OK);
	}
	
}