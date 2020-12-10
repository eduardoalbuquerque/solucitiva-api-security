package br.com.solucitiva.apisecurity.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solucitiva.apisecurity.domain.DTO.UserDTO;
import br.com.solucitiva.apisecurity.domain.exception.EntidadeEmUsoException;
import br.com.solucitiva.apisecurity.domain.exception.EntidadeNaoEncontradaException;
import br.com.solucitiva.apisecurity.domain.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> listAll(){
		return ResponseEntity.ok().body(userService.findAll());

	}


	@DeleteMapping("/{userId}")
	public ResponseEntity<UserDTO> deleteById(@PathVariable(value="userId") Long userId) {
		try {
			
			userService.delete(userId);
			return ResponseEntity.noContent().build();
			
		} catch(EntidadeNaoEncontradaException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
	
}
