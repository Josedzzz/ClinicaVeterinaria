package com.joki.veterinaria.model;

import java.time.LocalDate;

public class Factura {
    private double costo;
    private String observaciones;
    private AtencionVeterinaria atencionVeterinaria;

    public Factura(double costo, String observaciones, AtencionVeterinaria atencionVeterinaria) {
        this.costo = costo;
        this.observaciones = observaciones;
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

    public AtencionVeterinaria getAtencionVeterinaria() {
        return atencionVeterinaria;
    }

    public void setAtencionVeterinaria(AtencionVeterinaria atencionVeterinaria) {
        this.atencionVeterinaria = atencionVeterinaria;
    }
}
