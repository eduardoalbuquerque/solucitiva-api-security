package br.com.solucitiva.apisecurity.api.controller;

import java.util.List;
import java.util.Optional;

import br.com.solucitiva.apisecurity.api.controller.assembler.UserAssembler;
import br.com.solucitiva.apisecurity.api.controller.disassembler.UserDisassembler;
import br.com.solucitiva.apisecurity.api.controller.model.input.UserModelInput;
import br.com.solucitiva.apisecurity.api.controller.model.output.UserModelOutput;
import br.com.solucitiva.apisecurity.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.com.solucitiva.apisecurity.domain.exception.EntidadeEmUsoException;
import br.com.solucitiva.apisecurity.domain.exception.EntidadeNaoEncontradaException;
import br.com.solucitiva.apisecurity.domain.service.UserService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private UserService userService;

	private UserAssembler userAssembler;
	private UserDisassembler userDisassembler;


	@GetMapping
	public ResponseEntity<List<UserModelOutput>> listAll(){
		List<UserModelOutput> listOutput = userAssembler.toListModelOutput(userService.findAll());
		return ResponseEntity.ok(listOutput);
	}


	@GetMapping("/{userId}")
	public ResponseEntity<UserModelOutput> findById(@PathVariable Long userId){

		Optional<User> userOptional= userService.findById(userId);
		if(userOptional.isPresent()){
			return ResponseEntity.ok(userAssembler.toModelOutput(userOptional.get()));
		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserModelOutput> save(@RequestBody UserModelInput userModelInput){
		try {
			User userToSave = userService.save(userDisassembler.toModelInput(userModelInput));
			return  ResponseEntity.ok(userAssembler.toModelOutput(userToSave));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}


	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteById(@PathVariable Long userId) {

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
