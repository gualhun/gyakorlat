package hu.me.service;

import java.util.*;

import org.springframework.stereotype.Service;

import hu.me.entity.UserEntity;
import hu.me.modell.User;


public interface UserService {
	Iterable<UserEntity> listAllUser();
	void newUser(UserEntity newUser);
	void deleteUser(long id);

}
