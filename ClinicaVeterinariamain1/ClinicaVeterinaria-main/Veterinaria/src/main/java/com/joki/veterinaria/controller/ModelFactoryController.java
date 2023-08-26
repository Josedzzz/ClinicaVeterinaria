package com.joki.veterinaria.controller;

import com.joki.veterinaria.exceptions.ClienteNoRegistradoException;
import com.joki.veterinaria.exceptions.ClienteYaExistenteException;
import com.joki.veterinaria.exceptions.MascotaNoRegistradaException;
import com.joki.veterinaria.exceptions.MascotaYaExistenteException;
import com.joki.veterinaria.model.*;
import javafx.collections.ObservableList;

import java.util.List;

public class ModelFactoryController {
    Clinica clinica = null;

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("Invocacion de la clase singleton");
        incializarDatos();
    }

    /**
     * Inicio los datos que va a tener la clinica, incluyendo el unico objeto Clinica
     */
    private void incializarDatos() {
        clinica = new Clinica("Clinica Veterinaria Uq");
        //Inicializo datos
        Veterinario veterinario1 = new Veterinario("Luis","luisveter10@gmail.com","3214567284", "1111");
        Veterinario veterinario2 = new Veterinario("Camilo","camiloveter25@gmail.com","3102568970","2222");
        Veterinario veterinario3 = new Veterinario("Andres", "andresveter04@gmail.com","3214567890","3333");
        Veterinario veterinario4 = new Veterinario("Juanchito", "juanchitoveter08@gmail.com","3104562345","4444");
        clinica.getListaVeterinarios()[0] = veterinario1;
        clinica.getListaVeterinarios()[1] = veterinario2;
        clinica.getListaVeterinarios()[2] = veterinario3;
        clinica.getListaVeterinarios()[3] = veterinario4;
    }

    //FUNCIONES PARA EL LOGIN ----------------------------------------------------------------------

    /**
     * Verifica que el veterinario exista y lo retorna
     * @param nombre
     * @param codigo
     * @return
     */
    public Veterinario darVeterinario(String nombre, String codigo) {
        return clinica.darVeterinario(nombre, codigo);
    }
    public Veterinario darCodigoVeterinario(String codigo){
        return clinica.darCodigoVeterinario(codigo);
    }

    //FUNCIONES PARA EL MENU --------------------------------------------------------------------------


    //FUNCIONES PESTANIA CLIENTES -------------------------------------------------------------------

    /*
    Actualiza todos los datos del cliente
    */
    public void actualizarCliente(Clinica clinica1, String nombre, String correo, String cedula, String telefono, String direccion) throws ClienteNoRegistradoException {
        clinica.actualizarCliente(clinica, nombre, correo, cedula, telefono, direccion);
    }

    /*
    Crea los datos para cliente
    */
    public boolean crearCliente(Clinica clinica1, String nombre, String correo, String cedula, String telefono, String direccion) throws ClienteYaExistenteException {
        return this.clinica.crearCliente(this.clinica, nombre, correo, cedula, telefono, direccion);
    }

    /**
     * Obtengo la lista de clientes
     * @return
     */
    public List<Cliente> getListaClientes() {
        return clinica.getListaClientes();
    }

    //FUNCIONES PESTANIA MASCOTAS -------------------------------------------------------------------

    /*
    Actualizar todos los datos de la mascota
     */
    public void actualizarMascota(Clinica clinica2, String nombre, int edad,String raza,Cliente duenio) throws MascotaNoRegistradaException {
        clinica.actualizarMascota(clinica,nombre,edad,raza,duenio);
    }

    /*
    Crea los datos para mascota
    */
    public boolean crearMascota(Clinica clinica2, String nombre, int edad, SexoMascota sexo, String raza, TipoMascota tipo, Cliente duenio) throws MascotaYaExistenteException {
        return this.clinica.crearMascota(this.clinica,nombre,edad,sexo,raza,tipo,duenio);
    }

    public List<Mascota> getListaMascotas() {
        return clinica.getListaMascotas();
    }

}
