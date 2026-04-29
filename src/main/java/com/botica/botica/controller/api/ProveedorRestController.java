package com.botica.botica.controller.api;

import com.botica.botica.model.Proveedor;
import com.botica.botica.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorRestController {

    @Autowired
    private ProveedorService service;

    @GetMapping
    public List<Proveedor> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Proveedor guardar(@RequestBody Proveedor proveedor) {
        return service.guardar(proveedor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}