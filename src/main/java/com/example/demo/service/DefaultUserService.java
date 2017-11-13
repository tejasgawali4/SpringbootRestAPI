package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestree.restful.model.Employee;
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
}
