package com.botica.botica.controller.api;

import com.botica.botica.model.Producto;
import com.botica.botica.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public void guardar(@RequestBody Producto producto) {
        service.guardar(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
    service.eliminar(id);
    }
}
// Endpoints para consumo de API JSON
