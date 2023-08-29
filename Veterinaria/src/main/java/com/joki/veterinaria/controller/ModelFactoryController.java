package com.joki.veterinaria.controller;

import com.joki.veterinaria.exceptions.ClienteNoRegistradoException;
import com.joki.veterinaria.exceptions.ClienteYaExistenteException;
import com.joki.veterinaria.exceptions.MascotaNoRegistradaException;
import com.joki.veterinaria.exceptions.MascotaYaExistenteException;
import com.joki.veterinaria.model.*;

import java.text.ParseException;
import java.util.ArrayList;
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

        Cliente cliente1 = new Cliente("Julian", "julian@gmail.com", "123456789", "10097001", "Cra 18 #11-11");
        Cliente cliente2 = new Cliente("Lorena", "lorena@gmail.com", "312888833", "22255511", "Cra 12 #22-22");
        Cliente cliente3 = new Cliente("Alex", "alex@gmail.com", "311999231", "10971222", "Cra 22 #33-33");
        clinica.getListaClientes().add(cliente1);
        clinica.getListaClientes().add(cliente2);
        clinica.getListaClientes().add(cliente3);

        Mascota mascota1 = new Mascota("Hermes", 1, SexoMascota.MACHO, "Criollo", TipoMascota.PERRO, cliente2);
        clinica.getListaMascotas().add(mascota1);
        cliente2.getListaMascotas().add(mascota1);

        Mascota mascota2 = new Mascota("Mercy", 3, SexoMascota.HEMBRA, "Criolla", TipoMascota.GATO, cliente1);
        clinica.getListaMascotas().add(mascota2);
        cliente1.getListaMascotas().add(mascota2);

        AtencionVeterinaria atencionVeterinaria1 = new AtencionVeterinaria(cliente2, mascota1, veterinario1, EstadoAtencion.CREADA, "25/08/2023");
        clinica.getListaAtencionVeterinaria().add(atencionVeterinaria1);
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

    /*
    Actualiza todos los datos del cliente
    */
    public void actualizarCliente(String nombre, String correo, String cedula, String telefono, String direccion) throws ClienteNoRegistradoException {
        clinica.actualizarCliente(nombre, correo, cedula, telefono, direccion);
    }

    /*
    Crea los datos para cliente
    */
    public boolean crearCliente(String nombre, String correo, String cedula, String telefono, String direccion) throws ClienteYaExistenteException {
        return this.clinica.crearCliente(nombre, correo, cedula, telefono, direccion);
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
    public void actualizarMascota(String nombre, int edad,String raza,Cliente duenio) throws MascotaNoRegistradaException {
        clinica.actualizarMascota(nombre,edad,raza,duenio);
    }

    /*
    Crea los datos para mascota
    */
    public boolean crearMascota(String nombre, int edad, SexoMascota sexo, String raza, TipoMascota tipo, Cliente duenio) throws MascotaYaExistenteException {
        return this.clinica.crearMascota(nombre,edad,sexo,raza,tipo,duenio);
    }


    /**
     * Obtengo la lista de mascotas
     * @return
     */
    public List<Mascota> getListaMascotas() {
        return clinica.getListaMascotas();
    }

    //FUNCIONES PESTANIA ATENCION VETERINARIA --------------------------------------------------------

    /**
     * Valida que la fecha esté en el formato correcto
     * @param fecha
     * @return
     */
    public boolean validarFechaAtencion(String fecha) {
        return clinica.validarFechaAtencion(fecha);
    }

    /**
     * Genera la atencion. Si el String es "" es porque fue generada correctamente
     * @param cedulaCliente
     * @param nombreMascota
     * @param codigoVeterinario
     * @param fecha
     * @return
     */
    public String generarAtencion(String cedulaCliente, String nombreMascota, String codigoVeterinario, String fecha) {
        String fueGenerada = clinica.generarAtencion(cedulaCliente, nombreMascota, codigoVeterinario, fecha);
        return fueGenerada;
    }

    //FUNCIONES PESTANIA LISTA ATENCIONES ------------------------------------------------------------

    /**
     * Obtengo la lista de atenciones veterinarias
     * @return
     */
    public List<AtencionVeterinaria> getListaAtenciones() {
        return clinica.getListaAtencionVeterinaria();
    }

    /**
     * Cancela una atencion
     * @param atencionVeterinaria
     * @return
     */
    public boolean cancelarAtencionVeterinaria(AtencionVeterinaria atencionVeterinaria) {
        return clinica.cancelarAtencionVeterinaria(atencionVeterinaria);
    }

    //FUNCIONES PESTANIA LISTA DE FACTURAS ------------------------------------------------------------

    /**
     * Obtengo la lista de facturas
     * @return
     */
    public List<Factura> getListaFacturas() {
        return clinica.getListaFacturas();
    }

    /**
     * Obtengo las observaciones de una factura
     * @param facturaSeleccion
     * @return
     */
    public String verObservacionesFacturas(Factura facturaSeleccion) {
        String observacion = clinica.verObservacionesFacturas(facturaSeleccion);
        return observacion;
    }

    //FUNCIONES PESTANIA HISTORIAL CLINICO --------------------------------------------------------------

    /**
     * Obtengo la mascota correspondiente al duenio
     * @param cedula
     * @param nombreMascota
     * @return
     */
    public Mascota obtenerMascotaHistorial(String cedula, String nombreMascota) {
        Mascota mascotaHistorial = clinica.obtenerMascotaHistorial(cedula, nombreMascota);
        return mascotaHistorial;
    }

    //FUNCIONES PESTANIA FILTRAR CITAS ------------------------------------------------------------------

    /**
     * Valida que la fecha inicial sea menor a la fecha final
     * @param fechaInicialFiltrar
     * @param fechaFinalFiltrar
     * @return
     */
    public boolean validarFechasFiltrar(String fechaInicialFiltrar, String fechaFinalFiltrar) throws ParseException {
        return clinica.validarFechasFiltrar(fechaInicialFiltrar, fechaFinalFiltrar);
    }

    /**
     * Retorna el arrayList con las atenciones correspondientes a las fechas seleccionadas
     * @param fechaInicialFiltrar
     * @param fechaFinalFiltrar
     * @return
     */
    public ArrayList<AtencionVeterinaria> getListaAtencionesFechas(String fechaInicialFiltrar, String fechaFinalFiltrar) {
        ArrayList<AtencionVeterinaria> listaAtencionesFechas = clinica.getListaAtencionesFechas(fechaInicialFiltrar, fechaFinalFiltrar);
        return listaAtencionesFechas;
    }

    //FUNCIONES PARA LA ATENCION CITA -------------------------------------------------------------------

    /**
     * Genera una factura dada por finalizada la atencion de una mascota
     * @param atencionVeterinaria
     * @param precio
     * @param observaciones
     */
    public void crearFactura(AtencionVeterinaria atencionVeterinaria, Double precio, String observaciones) {
        clinica.crearFactura(atencionVeterinaria, precio, observaciones);
    }

    //FUNCIONES PARA EL HISTORIAL CLINICO

    /**
     * Obtengo el historial de facturas de una mascota
     * @return
     */
    public ArrayList<Factura> getHistorialMascota(Mascota mascotaHistorial) {
        ArrayList<Factura> listadoMascotaHistorial = clinica.getHistorialMascota(mascotaHistorial);
        return listadoMascotaHistorial;
    }


}
