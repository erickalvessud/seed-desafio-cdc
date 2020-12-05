package com.deveficiente.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deveficiente.jpa.entity.CategoriaEntity;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Long> {

	boolean existsByNome(String nome);

}
