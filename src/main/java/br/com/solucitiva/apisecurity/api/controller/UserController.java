package br.com.solucitiva.apisecurity.api.controller;

import java.util.List;
import java.util.Optional;

import br.com.solucitiva.apisecurity.api.controller.assembler.UserAssembler;
import br.com.solucitiva.apisecurity.api.controller.disassembler.UserDisassembler;
import br.com.solucitiva.apisecurity.api.controller.model.input.UserModelInput;
import br.com.solucitiva.apisecurity.api.controller.model.output.UserModelOutput;
import br.com.solucitiva.apisecurity.domain.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "API REST User")
@CrossOrigin(origins = "*")
public class UserController {

	private UserService userService;

	private UserAssembler userAssembler;
	private UserDisassembler userDisassembler;


	@GetMapping
	@ApiOperation(value = "Return list of users")
	public ResponseEntity<List<UserModelOutput>> listAll(){
		List<UserModelOutput> listOutput = userAssembler.toListModelOutput(userService.findAll());
		return ResponseEntity.ok(listOutput);
	}


	@GetMapping("/{userId}")
	@ApiOperation(value = "Return a users by ID")
	public ResponseEntity<UserModelOutput> findById(@PathVariable Long userId){

		Optional<User> userOptional= userService.findById(userId);
		if(userOptional.isPresent()){
			return ResponseEntity.ok(userAssembler.toModelOutput(userOptional.get()));
		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create a User and return the user created")
	public ResponseEntity<UserModelOutput> save(@RequestBody UserModelInput userModelInput){
		try {
			User userToSave = userService.save(userDisassembler.toModelInput(userModelInput));
			return  ResponseEntity.ok(userAssembler.toModelOutput(userToSave));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}


	@DeleteMapping("/{userId}")
	@ApiOperation(value = "Delete a User and return a user created or a error message")
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
