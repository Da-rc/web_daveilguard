package com.darc.daveilguard.davback.services.impl;

import com.darc.daveilguard.davback.model.Categoria;
import com.darc.daveilguard.davback.repositories.CategoriaRepository;
import com.darc.daveilguard.davback.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public List<Categoria> findAll() {
        return (List<Categoria>) repository.findAll();
    }
}
