package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CRUDService<E> {

	List<E> getAll();
}
