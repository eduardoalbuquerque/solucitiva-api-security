package br.com.solucitiva.apisecurity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.solucitiva.apisecurity.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
