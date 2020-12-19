package br.com.solucitiva.apisecurity.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "tb_user")
public class User {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length = 14)
	private String cpf;
	
	@Column(nullable=false, length=100)
	private String name;
	
	@Column(nullable=false, length=150)
	private String email;
	
	@Column(nullable=false, length=15)
	private String password;
	
	@ManyToMany
	@JoinTable(name="user_profile",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="profile_id"))
	private List<Profile> profiles;
}
