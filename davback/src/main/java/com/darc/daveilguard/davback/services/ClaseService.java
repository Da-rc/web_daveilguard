package com.darc.daveilguard.davback.services;


import com.darc.daveilguard.davback.model.Clase;

import java.util.List;
import java.util.Optional;

public interface ClaseService {
    List<Clase> findAll();
    Optional<Clase> findByName(String name);
}
