package com.joki.veterinaria.controller;

import com.joki.veterinaria.model.*;

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

    //FUNCIONES PARA EL MENU --------------------------------------------------------------------------

    //FUNCIONES PESTANIA CLIENTES -------------------------------------------------------------------

    /**
     * Obtengo la lista de clientes
     * @return
     */
    public List<Cliente> getListaClientes() {
        return clinica.getListaClientes();
    }

    //FUNCIONES PESTANIA MASCOTAS -------------------------------------------------------------------

    /**
     * Obtengo la lista de mascotas
     * @return
     */
    public List<Mascota> getListaMascotas() {
        return clinica.getListaMascotas();
    }

    //FUNCIONES PESTANIA ATENCION VETERINARIA --------------------------------------------------------

    //FUNCIONES PESTANIA LISTA ATENCIONES ------------------------------------------------------------

    /**
     * Obtengo la lista de atenciones veterinarias
     * @return
     */
    public List<AtencionVeterinaria> getListaAtenciones() {
        return clinica.getListaAtencionVeterinaria();
    }

    //FUNCIONES PESTANIA LISTA DE FACTURAS ------------------------------------------------------------

    /**
     * Obtengo la lista de facturas
     * @return
     */
    public List<Factura> getListaFacturas() {
        return clinica.getListaFacturas();
    }

    //FUNCIONES PESTANIA HISTORIAL CLINICO --------------------------------------------------------------

    //FUNCIONES PESTANIA FILTRAR CITAS ------------------------------------------------------------------

}
