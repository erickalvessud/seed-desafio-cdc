package com.deveficiente.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.deveficiente.jpa.entity.LivroEntity;

public interface LivroRepository extends CrudRepository<LivroEntity, Long>{

}
