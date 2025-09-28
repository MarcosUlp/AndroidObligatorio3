package com.example.obligatorio3.Modelo;

import java.io.Serializable;
//serializable significa que el objeto se transforma en secuencia de bytes para ser almacenada
// o transmitida y luego se reconstruye en objeto igual a la original
public class Producto implements Serializable {
    private String codigo;
    private String descripcion;
    private double precio;

    public Producto(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }

    // Setters si los necesitás
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(double precio) { this.precio = precio; }
}
