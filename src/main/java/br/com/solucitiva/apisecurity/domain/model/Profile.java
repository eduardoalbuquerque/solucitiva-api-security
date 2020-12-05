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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Profile {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=50)
	private String description;
	
	@ManyToMany(mappedBy = "profiles")
	List<User> users;
	
	@ManyToMany
	@JoinTable(name="profile_permission",
			joinColumns = @JoinColumn(name="profile_id"),
			inverseJoinColumns = @JoinColumn(name="permission_id"))
	private List<Permission> permissions;
}
