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

    //FUNCIONES LOGIN ------------------------------------------------------------------------------

    /**
     * Retorna tru si existe un veterinario con el nombre y codigo
     * @param nombre
     * @param codigo
     * @return
     */
    public boolean verificarVeterinario(String nombre, String codigo) {
        for (Veterinario veterinario : listaVeterinarios) {
            if (veterinario.getNombre().equals(nombre) && veterinario.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public Cliente obtenerCliente(String cedula){
        Cliente clienteEncontrado = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                clienteEncontrado = cliente;
            }
        }
        return clienteEncontrado;
    }

    public boolean crearCliente(String nombre, String correo, String telefono, String cedula, String Direccion, ArrayList listaMascotas) throws ClienteYaExistenteException {
        boolean fueCreado = false;
        Cliente clienteAsociado = obtenerCliente(cedula);
    if(clienteAsociado != null){
        throw new ClienteYaExistenteException("El cliente ya existe");
    }else {
        Cliente clienteNuevo = new Cliente(nombre,correo,telefono, cedula, Direccion,listaMascotas);
        listaClientes.add(clienteNuevo);
        fueCreado = true;
    }
       return fueCreado;
    }

    public void actualizarCliente(String nombre, String correo, String telefono, String cedula, String direccion, ArrayList listaMascotas) throws ClienteNoRegistradoException{
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if(clienteEncontrado == null){
            throw new ClienteNoRegistradoException("El cliente no esta registrado");
        }else{
            clienteEncontrado.setNombre(nombre);
            clienteEncontrado.setCorreo(correo);
            clienteEncontrado.setTelefono(telefono);
            clienteEncontrado.setCedula(cedula);
            clienteEncontrado.setDireccion(direccion);
            clienteEncontrado.setListaMascotas(listaMascotas);
        }
    }

    public void eliminarCliente(String cedula) throws ClienteNoRegistradoException{
        Cliente clientePorEliminar = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                clientePorEliminar = cliente;
            }
        }
        if(clientePorEliminar != null){
            listaClientes.remove(clientePorEliminar);
        }else{
            throw new ClienteNoRegistradoException("El cliente con cedula" + cedula + "no esta registrado");
        }
    }
}
