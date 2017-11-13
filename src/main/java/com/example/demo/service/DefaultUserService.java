package com.example.demo.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class DefaultUserService implements UserService {

	
	@Autowired
	private UsersRepository userRepository;

	@Override
	public List<Users> getAll() {
		return userRepository.findAll();
	}
	
	@Override
	public Users save(Users entity) {
		return userRepository.save(entity);
	}

	@Override
	public Users getById(Serializable id) {
		return userRepository.findOne((Integer) id);
	}
	
	@Override
	public void delete(Serializable id) {
		userRepository.delete((Integer) id);
	}
}
