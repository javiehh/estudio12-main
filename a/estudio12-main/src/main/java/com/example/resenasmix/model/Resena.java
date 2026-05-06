package com.example.resenasmix.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "resenas")
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentario;
    private int calificacion;

    @ManyToOne
    @JoinColumn(name = "videojuego_id")
    @JsonIgnoreProperties("resenas")
    private Videojuego videojuego;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("resenas")
    private Usuario usuario;

   
}