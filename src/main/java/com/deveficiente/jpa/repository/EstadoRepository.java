package com.deveficiente.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deveficiente.jpa.entity.EstadoEntity;

@Repository
public interface EstadoRepository extends CrudRepository<EstadoEntity, Long> {

	boolean existsByPaisId(Long pais);

	boolean existsByIdAndPaisId(Long estadoId, Long pais);

}
