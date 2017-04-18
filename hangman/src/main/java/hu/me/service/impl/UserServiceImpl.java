package hu.me.service.impl;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.me.dao.UserDao;
import hu.me.entity.UserEntity;
import hu.me.modell.User;
import hu.me.repository.UserRepository;
import hu.me.service.UserService;

@Service
public class UserServiceImpl implements UserService {
//	private List<User> users = new ArrayList<>();
//	
//	@PostConstruct
//	void initUserList() {
//		users.add(new User("Bela", 0));
//		users.add(new User("Yuli", 1));
//		users.add(new User("Marci", 2));
//	}
	
	UserRepository userRepository;
	UserDao userDao;
	

	@Autowired
	public UserServiceImpl( UserRepository userRepository, UserDao userDao) {
		super();	
		this.userRepository = userRepository;
		this.userDao = userDao;
	}

	@Override
	public Iterable<UserEntity> listAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void newUser(UserEntity newUser) {
		userRepository.save(newUser);
	}

	@Override
	public void deleteUser(long id) {
//		for (User user: users) {
//			if(user.getId() == id) {
//				users.remove(user);
//				break;
//			}
		userRepository.delete(id);
		}
	
	@Override
	public List<UserEntity> findByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
		}

	@Override
	public List<UserEntity> getUserOrderByFirstNameDesc() {
		// TODO Auto-generated method stub
		return userDao.getUserOrderByFirtsNameDesc();
	}

	@Override
	public List<UserEntity> getUserFirstNameLikeNem() {
		// TODO Auto-generated method stub
		return userDao.getUserFirstNameLikeNem();
	}
	
}
