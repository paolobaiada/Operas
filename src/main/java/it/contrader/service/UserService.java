package it.contrader.service;

import it.contrader.exceptions.InvalidCredentialsException;
import org.springframework.stereotype.Service;

import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService extends AbstractService<User,UserDTO> {

	public UserDTO findByEmailAndPassword(String email, String password) {
		return converter.toDTO(((UserRepository)repository).findByEmailAndPassword(email, password)
				.orElseThrow(() -> new InvalidCredentialsException("Credenziali Errate")));
	}

/*	public UserDTO updateById(UserDTO userDTO, Long id){
		return converter.toDTO(((UserRepository)repository).updateById(converter.toEntity(userDTO), id).
				orElseThrow(() -> new InvalidCredentialsException("Aggiornamento fallito")));
	}*/

}
