package com.deveficiente.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deveficiente.jpa.entity.AutorEntity;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {

}
