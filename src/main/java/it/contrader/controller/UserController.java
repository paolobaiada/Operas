package it.contrader.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController extends AbstractController<UserDTO>{

	@Autowired
	private UserService userService;

	@PostMapping(value = "/login")
	public ResponseEntity<UserDTO> login(@RequestBody @Valid LoginDTO loginDTO) {
		return new ResponseEntity<>(userService.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword()), HttpStatus.OK);
	}

	@PostMapping(value = "/registeruser")
	public ResponseEntity<UserDTO> register(@RequestBody @Valid UserDTO userDTO){
		return new ResponseEntity<>(userService.insert(userDTO), HttpStatus.OK);
	}

	@PatchMapping(value = "/updateuser/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO){
		UserDTO user = userService.read(id);
		if(userDTO.getEmail()!=null){
			user.setEmail(userDTO.getEmail());
		}
		if(userDTO.getPassword()!=null){
			user.setPassword(userDTO.getPassword());
		}
		return new ResponseEntity<>(userService.update(user),HttpStatus.OK);
	}

	@DeleteMapping( value = "/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}