package com.example.resenasmix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.resenasmix.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}