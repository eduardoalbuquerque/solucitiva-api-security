package br.com.solucitiva.apisecurity.domain.DTO;

import br.com.solucitiva.apisecurity.domain.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class UserDTO {
	
	@EqualsAndHashCode.Include
	private Long id;
	
	private String cpf;
	private String name;
	private String email;
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.cpf=user.getCpf().substring(0, 3)+"***.***-**";
		this.name = user.getName();
		this.email=user.getEmail();
	}

}
