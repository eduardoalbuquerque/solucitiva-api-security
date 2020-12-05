package br.com.solucitiva.apisecurity.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.solucitiva.apisecurity.domain.DTO.UserDTO;
import br.com.solucitiva.apisecurity.domain.model.User;
import br.com.solucitiva.apisecurity.domain.repository.UserRepository;

@Service
public class UserService {

	private  UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<UserDTO> findAll(){
		List<User> listUser= userRepository.findAll();
		
		return listUser.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
	}
	
}
