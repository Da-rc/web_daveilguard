package com.darc.daveilguard.davback.repositories;

import com.darc.daveilguard.davback.model.Clase;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClaseRepository extends CrudRepository<Clase, Integer> {
    Optional<Clase> findByNombre(String name);
}
