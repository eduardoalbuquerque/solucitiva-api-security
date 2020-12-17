package br.com.solucitiva.apisecurity.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.solucitiva.apisecurity.domain.exception.EntidadeEmUsoException;
import br.com.solucitiva.apisecurity.domain.exception.EntidadeNaoEncontradaException;
import br.com.solucitiva.apisecurity.domain.model.User;
import br.com.solucitiva.apisecurity.domain.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserService {

	private  UserRepository userRepository;
	
	public List<User> findAll(){
		List<User> listUser= userRepository.findAll();
		return null;
//		return listUser.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
	}

	public Optional<User> findById(Long userId){
		Optional<User> userOptional =  userRepository.findById(userId);
		return userOptional;
	}


	public User save(User user){
		return userRepository.save(user);
	}

	
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
