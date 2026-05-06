package com.example.resenasmix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.resenasmix.model.Videojuego;
import com.example.resenasmix.service.VideojuegoService;

@RestController
@RequestMapping("/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoService service;

    @GetMapping
    public List<Videojuego> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Videojuego obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Videojuego guardar(@RequestBody Videojuego v) {
        return service.guardar(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}