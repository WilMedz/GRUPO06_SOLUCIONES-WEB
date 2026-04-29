package com.botica.botica.controller.api;

import com.botica.botica.model.DetalleVenta;
import com.botica.botica.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalleventas")
public class DetalleVentaRestController {

    @Autowired
    private DetalleVentaService service;

    @GetMapping
    public List<DetalleVenta> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> guardar(@RequestBody DetalleVenta detalleVenta) {
        DetalleVenta guardado = service.guardar(detalleVenta);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
