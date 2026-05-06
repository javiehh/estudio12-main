package com.example.resenasmix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.resenasmix.model.Videojuego;
import com.example.resenasmix.repository.VideojuegoRepository;

@Service
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository repository;

    public List<Videojuego> listar() {
        return repository.findAll();
    }

    public Videojuego guardar(Videojuego v) {
        return repository.save(v);
    }

    public Videojuego obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}