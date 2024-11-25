package com.darc.daveilguard.davback.services.impl;

import com.darc.daveilguard.davback.model.Habilidad;
import com.darc.daveilguard.davback.repositories.HabilidadRepository;
import com.darc.daveilguard.davback.services.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadServiceImpl implements HabilidadService {

    @Autowired
    private HabilidadRepository repository;

    @Override
    public List<Habilidad> findAll() {
        return (List<Habilidad>) repository.findAll();
    }
}
