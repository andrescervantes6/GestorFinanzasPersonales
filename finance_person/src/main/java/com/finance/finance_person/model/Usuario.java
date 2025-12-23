package com.finance.finance_person.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 250, nullable = false)
    private String password;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(nullable = false)
    private Boolean activo;

    // Relación con Categorías
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Categoria> categorias;

    // Relación con Movimientos
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Movimiento> movimientos;

    // =========================================
    // CONSTRUCTORES
    // =========================================

    public Usuario() {
        this.fechaRegistro = LocalDateTime.now();
        this.activo = true;
    }

    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fechaRegistro = LocalDateTime.now();
        this.activo = true;
    }

    // =========================================
    // GETTERS Y SETTERS
    // =========================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}