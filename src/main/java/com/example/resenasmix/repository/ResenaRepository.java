package com.example.resenasmix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.resenasmix.model.Resena;

public interface ResenaRepository extends JpaRepository<Resena, Long> {
}