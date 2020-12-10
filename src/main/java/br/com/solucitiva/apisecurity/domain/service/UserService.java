package br.com.solucitiva.apisecurity.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.solucitiva.apisecurity.domain.DTO.UserDTO;
import br.com.solucitiva.apisecurity.domain.exception.EntidadeEmUsoException;
import br.com.solucitiva.apisecurity.domain.exception.EntidadeNaoEncontradaException;
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
	
//	public UserDTO save(UserDTO user) {
//		userRepository.save(entity);
//	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}catch(EntidadeNaoEncontradaException e){
			throw new EntidadeEmUsoException(String.format("Usuário Não encontrado para o id %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Usuário %d está em uso, não pode ser removido", id));
		}
	}
	
}
