package com.finance.finance_person.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer id;

    @Column(length = 45, nullable = false)
    private String tipo; // INGRESO o GASTO

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal monto;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 255)
    private String descripcion;

    // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Relación con Categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // =========================================
    // CONSTRUCTORES
    // =========================================

    public Movimiento() {
        this.fecha = LocalDate.now();
    }

    public Movimiento(String tipo, BigDecimal monto, Usuario usuario, Categoria categoria) {
        this.tipo = tipo;
        this.monto = monto;
        this.usuario = usuario;
        this.categoria = categoria;
        this.fecha = LocalDate.now();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}