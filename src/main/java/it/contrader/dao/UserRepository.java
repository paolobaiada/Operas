package it.contrader.dao;

import javax.transaction.Transactional;

import it.contrader.dto.UserDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;

import java.util.Optional;


/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD. 
 * Definisce il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @see CrudRepository
 *
 */
@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findByEmailAndPassword(String email, String password);

	//Optional<User> updateById(User user, Long id);
	
}
