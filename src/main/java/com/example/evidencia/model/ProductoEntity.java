package com.example.evidencia.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "producto", schema = "usuarios", catalog = "")
public class ProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproducto")
    private int idproducto;
    @Basic
    @Column(name = "idcategoria")
    private Integer idcategoria;
    @Basic
    @Column(name = "medida")
    private String medida;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "precio")
    private Integer precio;
    @Basic
    @Column(name = "stock")
    private Integer stock;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoEntity that = (ProductoEntity) o;
        return idproducto == that.idproducto && Objects.equals(idcategoria, that.idcategoria) && Objects.equals(medida, that.medida) && Objects.equals(nombre, that.nombre) && Objects.equals(precio, that.precio) && Objects.equals(stock, that.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproducto, idcategoria, medida, nombre, precio, stock);
    }
}
