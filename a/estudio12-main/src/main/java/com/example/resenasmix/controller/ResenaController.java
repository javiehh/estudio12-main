package com.example.resenasmix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.resenasmix.model.Resena;
import com.example.resenasmix.service.ResenaService;

@RestController
@RequestMapping("/resenas")
public class ResenaController {

    @Autowired
    private ResenaService service;

    @GetMapping
    public ResponseEntity<List<Resena>> listar() {
        List<Resena> resenas = service.findAll();
        return ResponseEntity.ok(resenas); //200 ok
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resena> obtener(@PathVariable Long id) {
        Resena r = service.obtenerPorId(id);
        if (r != null){
            return ResponseEntity.ok(r);
        } else {
            return ResponseEntity.notFound().build(); //404 no existe
        }
    }

    @PostMapping
    public ResponseEntity<Resena> guardar(@RequestBody Resena r) {
        Resena nuevaResena = service.guardar(r);
        return new ResponseEntity<>(nuevaResena, HttpStatus.CREATED); //201 creado
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build(); //204 no hay contenido 
    }
}