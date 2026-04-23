package com.botica.botica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.botica.botica.model.Producto;
import com.botica.botica.repository.ProductoRepository;

@Controller
public class MainController {

    @Autowired
    private ProductoRepository productoRepository;

    // Ruta para la página de bienvenida (index.html)
    @GetMapping("/bienvenida")
    public String bienvenida() {
        return "index"; 
    }

    // Ruta para la gestión de productos (productos.html - El diseño azul)
    @GetMapping("/") // He puesto "/" aquí para que sea la página principal
    public String gestion(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("listaProductos", productoRepository.findAll());
        return "productos";
    }

    // Procesa el formulario y guarda en la base de datos
    @PostMapping("/guardar")
    public String guardar(Producto producto) {
        productoRepository.save(producto);
        return "redirect:/"; // Regresa a la página de gestión
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
    productoRepository.deleteById(id);
    return "redirect:/"; // Redirige a la tabla para ver el cambio
}

} // Solo una llave al final para cerrar la clase