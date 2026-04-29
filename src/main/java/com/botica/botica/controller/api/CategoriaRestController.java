package com.botica.botica.controller.api;

import com.botica.botica.model.Categoria;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaRestController {

   
    private Categoria[] categorias = {
        new Categoria(1, "Antibióticos", "Medicamentos para infecciones"),
        new Categoria(2, "Analgésicos", "Para el alivio del dolor")
    };

    @GetMapping
    public Categoria[] listarTodas() {
        return categorias;
    }

    @PostMapping
    public Categoria guardar(@RequestBody Categoria nueva) {
        
        System.out.println("Guardando: " + nueva.getNombre());
        return nueva;
    }
}