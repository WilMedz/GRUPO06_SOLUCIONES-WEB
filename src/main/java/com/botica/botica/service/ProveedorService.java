package com.botica.botica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.botica.botica.model.Proveedor;
import com.botica.botica.repository.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository repository;

    public List<Proveedor> listarTodos() {
        return repository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}