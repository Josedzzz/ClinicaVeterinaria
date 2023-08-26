package com.joki.veterinaria.model;

public class Veterinario extends Persona {
    private String codigo;

    public Veterinario(String nombre, String correo, String telefono, String codigo) {
        super(nombre, correo, telefono);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
