package com.finance.finance_person.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 45, nullable = false)
    private String tipo; // INGRESO o GASTO

    @Column(length = 100)
    private String color;

    private Integer icono;

    // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Relación con Movimientos
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Movimiento> movimientos;

    // =========================================
    // CONSTRUCTORES
    // =========================================

    public Categoria() {
    }

    public Categoria(String nombre, String tipo, Usuario usuario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.usuario = usuario;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getIcono() {
        return icono;
    }

    public void setIcono(Integer icono) {
        this.icono = icono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}