package br.com.isaiasdrocha.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

	public User(User user) {
		super();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.roles = user.getRoles();
		this.id = user.getId();
	}

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
//	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String password;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name="user_role",
//			joinColumns = @JoinColumn(name="user_id"),
//			inverseJoinColumns = @JoinColumn(name="role_id")
//	)
	private List<Role> roles;
	
}