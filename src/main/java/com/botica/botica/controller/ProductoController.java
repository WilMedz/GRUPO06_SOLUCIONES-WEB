package com.botica.botica.controller;

// Importamos las clases de las otras carpetas
import com.botica.botica.model.Producto;
import com.botica.botica.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public String listar(Model model) {
        List<Producto> lista = productoRepository.findAll();
        model.addAttribute("productos", lista);
        return "productos"; 
    }
}