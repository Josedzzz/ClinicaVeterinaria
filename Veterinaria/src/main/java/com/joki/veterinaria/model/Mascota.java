package com.joki.veterinaria.model;

public class Mascota {
    private String nombre;
    private int edad;
    private SexoMascota sexo;
    private String raza;
    private TipoMascota tipo;

    public Mascota(String nombre, int edad, SexoMascota sexo, String raza, TipoMascota tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.raza = raza;
        this.tipo = tipo;
    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public SexoMascota getSexo() {
        return sexo;
    }

    public void setSexo(SexoMascota sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public TipoMascota getTipo() {
        return tipo;
    }

    public void setTipo(TipoMascota tipo) {
        this.tipo = tipo;
    }
}
