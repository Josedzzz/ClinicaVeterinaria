package com.joki.veterinaria.model;

public class AtencionVeterinaria {
    private Cliente cliente;
    private Mascota mascota;
    private Veterinario veterinario;
    private EstadoAtencion estadoAtencion;
    private String fechaAtencion;

    public AtencionVeterinaria(Cliente cliente, Mascota mascota, Veterinario veterinario, EstadoAtencion estadoAtencion, String fechaAtencion) {
        this.cliente = cliente;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.estadoAtencion = estadoAtencion;
        this.fechaAtencion = fechaAtencion;
    }

    public AtencionVeterinaria() {

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public EstadoAtencion getEstadoAtencion() {
        return estadoAtencion;
    }

    public void setEstadoAtencion(EstadoAtencion estadoAtencion) {
        this.estadoAtencion = estadoAtencion;
    }

    public String getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
}
