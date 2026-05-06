package com.example.resenasmix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import com.example.resenasmix.model.Resena;
import com.example.resenasmix.model.Usuario;
import com.example.resenasmix.model.Videojuego;
import com.example.resenasmix.repository.ResenaRepository;
import com.example.resenasmix.repository.UsuarioRepository;
import com.example.resenasmix.repository.VideojuegoRepository;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    public List<Resena> listar() {
        return repository.findAll();
    }

    public Resena obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Resena guardar(Resena r) {
        if (r.getUsuario() == null || r.getUsuario().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debes enviar usuario.id");
        }

        if (r.getVideojuego() == null || r.getVideojuego().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debes enviar videojuego.id");
        }

        Usuario usuario = usuarioRepository.findById(r.getUsuario().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        Videojuego videojuego = videojuegoRepository.findById(r.getVideojuego().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Videojuego no encontrado"));

        r.setUsuario(usuario);
        r.setVideojuego(videojuego);

        return repository.save(r);
    }

    public List<Resena> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}