package com.joki.veterinaria.model;

import java.util.ArrayList;

public class Cliente extends Persona {
    private String cedula;
    private String direccion;
    private ArrayList<Mascota> listaMascotas;

    public Cliente(String nombre, String correo, String telefono, String cedula, String direccion) {
        super(nombre, correo, telefono);
        this.cedula = cedula;
        this.direccion = direccion;
        this.listaMascotas = new ArrayList<Mascota>();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }
}
