package com.darc.daveilguard.davback.services.impl;

import com.darc.daveilguard.davback.model.Clase;
import com.darc.daveilguard.davback.repositories.ClaseRepository;
import com.darc.daveilguard.davback.services.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Clase> findAll() {
        /*List<Clase> lista = (List<Clase>) repository.findAll();
        lista.forEach(clase -> {
            clase.getCategorias().forEach(categoria -> {
                categoria.geth
            });
        });*/
        return (List<Clase>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Clase> findByName(String name) {
        return repository.findByNombre(name);
    }
}
