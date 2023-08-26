package com.joki.veterinaria.model;

import com.joki.veterinaria.exceptions.ClienteNoRegistradoException;
import com.joki.veterinaria.exceptions.ClienteYaExistenteException;
import com.joki.veterinaria.exceptions.MascotaNoRegistradaException;
import com.joki.veterinaria.exceptions.MascotaYaExistenteException;

import java.util.ArrayList;

public class Clinica {
    private String nombre;
    private Veterinario[] listaVeterinarios;
    private ArrayList<AtencionVeterinaria> listaAtencionVeterinaria;
    private ArrayList<Factura> listaFacturas;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Mascota> listaMascotas;

    public Clinica(String nombre) {
        this.nombre = nombre;
        this.listaVeterinarios = new Veterinario[4];
        this.listaAtencionVeterinaria = new ArrayList<AtencionVeterinaria>();
        this.listaFacturas = new ArrayList<Factura>();
        this.listaClientes = new ArrayList<Cliente>();
        this.listaMascotas = new ArrayList<Mascota>();
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

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    //FUNCIONES LOGIN ------------------------------------------------------------------------------

    /**
     * Retorna el veterinario si encuentra los campos
     * @param nombre
     * @param codigo
     * @return
     */
    public Veterinario darVeterinario(String nombre, String codigo) {
        Veterinario veterinarioEncontrado = null;
        for (Veterinario veterinario : listaVeterinarios) {
            if (veterinario.getNombre().equals(nombre) && veterinario.getCodigo().equals(codigo)) {
                veterinarioEncontrado = veterinario;
            }
        }
        return veterinarioEncontrado;
    }

    //Retorna el codigo del veterinario

    public Veterinario darCodigoVeterinario(String codigo) {
    Veterinario veterinarioEncontrado = null;
        for (Veterinario veterinario : listaVeterinarios) {
            if (veterinario.getCodigo().equals(codigo)) {
                veterinarioEncontrado = veterinario;
            }
        }
    return veterinarioEncontrado;
    }
    //FUNCIONES CRUD CLIENTES ------------------------------------------------------------------------------------------
    public Cliente obtenerCliente(String cedula){
        Cliente clienteEncontrado = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                clienteEncontrado = cliente;
            }
        }
        return clienteEncontrado;
    }

    public boolean crearCliente(Clinica clinica, String nombre, String correo, String cedula, String telefono, String Direccion) throws ClienteYaExistenteException {
        boolean fueCreado = false;
        Cliente clienteAsociado = obtenerCliente(cedula);
        if (clienteAsociado != null){
            throw new ClienteYaExistenteException("El cliente ya existe");
        } else {
            Cliente clienteNuevo = new Cliente(nombre,correo,telefono, cedula, Direccion);
            listaClientes.add(clienteNuevo);
            fueCreado = true;
        }
        return fueCreado;
    }

    public void actualizarCliente(Clinica clinica, String nombre, String correo, String cedula, String telefono, String direccion) throws ClienteNoRegistradoException{
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if (clienteEncontrado == null) {
            throw new ClienteNoRegistradoException("El cliente no esta registrado");
        } else {
            clienteEncontrado.setNombre(nombre);
            clienteEncontrado.setCorreo(correo);
            clienteEncontrado.setTelefono(telefono);
            clienteEncontrado.setCedula(cedula);
            clienteEncontrado.setDireccion(direccion);
            ;
        }
    }

    public void eliminarCliente(String cedula) throws ClienteNoRegistradoException {
        Cliente clientePorEliminar = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                clientePorEliminar = cliente;
            }
        }
        if (clientePorEliminar != null){
            listaClientes.remove(clientePorEliminar);
        } else {
            throw new ClienteNoRegistradoException("El cliente con cedula" + cedula + "no esta registrado");
        }
    }

    //FUNCIONES CRUD MASCOTAS ------------------------------------------------------------------------------------------

    public Mascota obtenerMascota(String nombreMascota, Cliente cliente){
        Mascota mascotaEncontrada = null;
        for(Mascota mascota : listaMascotas){
            if(mascota.getDuenio().getCedula().equals(cliente.getCedula()) && mascota.getNombre().equals(nombreMascota)){
                mascotaEncontrada = mascota;
            }
        }
        return mascotaEncontrada;
    }

    public ArrayList<Mascota> obtenerMascotas(Cliente cliente){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for(Mascota mascota : listaMascotas){
            if(mascota.getDuenio().getCedula().equals(cliente.getCedula())){
                mascotas.add(mascota);
            }
        }
        return mascotas;
    }

    public boolean crearMascota(Clinica clinica, String nombre, int edad, SexoMascota sexo, String raza, TipoMascota tipo, Cliente duenio) throws MascotaYaExistenteException {
        boolean  fueCreado = false;
        Mascota mascotaAsociada = obtenerMascota(nombre, duenio);
        if(mascotaAsociada != null){
            throw new MascotaYaExistenteException("Esta mas ya fue creada");
        }else{
            Mascota mascotaNueva = new Mascota(nombre,edad,sexo,raza,tipo,duenio);
            listaMascotas.add(mascotaNueva);
            fueCreado = true;
        }
        return fueCreado;
    }

    public void actualizarMascota(Clinica clinica, String nombre, int edad,String raza,Cliente duenio) throws MascotaNoRegistradaException {
        Mascota mascotaEncontrada = obtenerMascota(nombre, duenio);
        if(mascotaEncontrada == null){
            throw new MascotaNoRegistradaException("La mascota no esta registrada");
        }else{
            mascotaEncontrada.setNombre(nombre);
            mascotaEncontrada.setEdad(edad);
            mascotaEncontrada.setRaza(raza);
        }
    }

    public void eliminarMascota(String nombre, Cliente duenio) throws MascotaNoRegistradaException {
        Mascota mascotaAEliminar = obtenerMascota(nombre, duenio);
        for(Mascota mascota : listaMascotas){
            if(mascota.getDuenio().equals(duenio)){
                mascotaAEliminar = mascota;
            }
            if(mascotaAEliminar !=null){
                listaMascotas.remove(mascotaAEliminar);
            }else{
                throw new MascotaNoRegistradaException("La mascota con duenño " + duenio + "no existe");
            }
        }
    }
}
