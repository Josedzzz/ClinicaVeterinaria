package com.joki.veterinaria.model;

import java.time.LocalDate;

public class Factura {
    private double costo;
    private String observaciones;
    private Cliente cliente;
    private AtencionVeterinaria atencionVeterinaria;

    public Factura(double costo, String observaciones, Cliente cliente, AtencionVeterinaria atencionVeterinaria) {
        this.costo = costo;
        this.observaciones = observaciones;
        this.cliente = cliente;
        this.atencionVeterinaria = atencionVeterinaria;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public AtencionVeterinaria getAtencionVeterinaria() {
        return atencionVeterinaria;
    }

    public void setAtencionVeterinaria(AtencionVeterinaria atencionVeterinaria) {
        this.atencionVeterinaria = atencionVeterinaria;
    }
}
