package com.flatron.modelos;

public class UnidadDeMedida implements java.io.Serializable {

    private Integer codigo;
    private String nombre;
    private String simbolo;

    public UnidadDeMedida() {
    }

    public UnidadDeMedida(String nombre, String simbolo) {
        this.nombre = nombre;

    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;

    }

}
