package br.com.isaiasdrocha.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Role /* implements GrantedAuthority */{

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
//	@Override
//	public String getAuthority() {
//		return this.name;
//	}
	
}