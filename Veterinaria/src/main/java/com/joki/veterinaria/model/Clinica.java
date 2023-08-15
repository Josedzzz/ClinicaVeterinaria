package com.joki.veterinaria.model;

import java.util.ArrayList;

public class Clinica {
    private String nombre;
    private Veterinario[] listaVeterinarios;
    private ArrayList<AtencionVeterinaria> listaAtencionVeterinaria;
    private ArrayList<Factura> listaFacturas;

    public Clinica(String nombre) {
        this.nombre = nombre;
        this.listaVeterinarios = new Veterinario[4];
        this.listaAtencionVeterinaria = new ArrayList<AtencionVeterinaria>();
        this.listaFacturas = new ArrayList<Factura>();
    }

    public Clinica() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Veterinario[] getListaVeterinarios() {
        return listaVeterinarios;
    }

    public void setListaVeterinarios(Veterinario[] listaVeterinarios) {
        this.listaVeterinarios = listaVeterinarios;
    }

    public ArrayList<AtencionVeterinaria> getListaAtencionVeterinaria() {
        return listaAtencionVeterinaria;
    }

    public void setListaAtencionVeterinaria(ArrayList<AtencionVeterinaria> listaAtencionVeterinaria) {
        this.listaAtencionVeterinaria = listaAtencionVeterinaria;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }
}
