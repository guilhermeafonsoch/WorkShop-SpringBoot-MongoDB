package com.afonso.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afonso.workshopmongo.domain.User;
import com.afonso.workshopmongo.dto.UserDTO;
import com.afonso.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	 private UserService service;
	
	@RequestMapping(method =RequestMethod.GET)
	private ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll(); 
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}

}
