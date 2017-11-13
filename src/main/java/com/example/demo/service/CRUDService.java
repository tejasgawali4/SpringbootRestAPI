package com.example.demo.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;

@Repository
public interface CRUDService<E> {

	List<E> getAll();

	void delete(Serializable id);

	Users getById(Serializable id);

	Users save(Users entity);
}
