package br.com.solucitiva.apisecurity.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solucitiva.apisecurity.domain.DTO.UserDTO;
import br.com.solucitiva.apisecurity.domain.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> listar(){
		return ResponseEntity.ok().body(userService.findAll());

	}
	
	
	
}
