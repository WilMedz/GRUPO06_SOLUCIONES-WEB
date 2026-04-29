package com.botica.botica.service;

import com.botica.botica.model.Producto;
import com.botica.botica.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public Producto guardar(Producto producto) {
    return repository.save(producto);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
// Lógica de negocio para productos de la botica