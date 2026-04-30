package com.botica.botica.controller.api;

import com.botica.botica.model.Producto;
import com.botica.botica.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    @Autowired
    private ProductoService service;

   @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // probar en thunderclient con POST http://localhost:8080/api/productos
    @PostMapping
    public ResponseEntity<Producto> guardar(@Valid @RequestBody Producto producto) {
        Producto guardado = service.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    // probar en thunderclient con PUT http://localhost:8080/api/productos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @Valid @RequestBody Producto producto) {
    Producto existente = service.buscarPorId(id);
    
    if (existente == null) {
        return ResponseEntity.notFound().build();
    }

    // Actualizamos solo los campos
    existente.setNombre(producto.getNombre());
    existente.setPrecio(producto.getPrecio());
    existente.setStock(producto.getStock());

    Producto actualizado = service.guardar(existente);
    return ResponseEntity.ok(actualizado);
}

    // probar en thunderclient con DELETE http://localhost:8080/api/productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
}
//api JSON
