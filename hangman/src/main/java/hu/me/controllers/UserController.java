package hu.me.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.entity.UserEntity;
import hu.me.exception.AdminUserNotAllowed;
import hu.me.modell.User;
import hu.me.service.UserService;
import java.util.*;




@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;	
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping(path = "", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<UserEntity> list() {
		return userService.listAllUser();
	}
	
	@PostMapping(path = "", consumes=MediaType.APPLICATION_JSON_VALUE)
	void createNew(@RequestBody UserEntity newUser) {
		if (newUser.getFirstName().toUpperCase().equals("ADMIN")) {
			throw new AdminUserNotAllowed();
		}
		userService.newUser(newUser);
	}
	
	@DeleteMapping(path = "/{id}")
	void deleteExisting(@PathVariable("id")long id) {
		userService.deleteUser(id);
	}
	
	@PutMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	void updateExisting(@PathVariable("id")long id, @RequestBody UserEntity newUser) {
		//userService.updateUser(id);
	}
//	@PutMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
//	void updateExisting(@PathVariable("id")long id, @RequestBody User newUser) {
//		//userService.updateUser(id);
//	}előző entity nélkül

//	@GetMapping(path = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
//	UserEntity showOne(long id) {
//		//list().
//		
//	}
	


}
