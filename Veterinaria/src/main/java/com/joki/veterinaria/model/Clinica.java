package com.joki.veterinaria.model;

import com.joki.veterinaria.exceptions.ClienteNoRegistradoException;
import com.joki.veterinaria.exceptions.ClienteYaExistenteException;
import com.joki.veterinaria.exceptions.MascotaNoRegistradaException;
import com.joki.veterinaria.exceptions.MascotaYaExistenteException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
     *
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

    /**
     * Retorna el veterinario solo con el codigo
     * @param codigo
     * @return
     */
    public Veterinario obtenerVeterinario(String codigo) {
        Veterinario veterinarioEncontrado = null;
        for (Veterinario veterinario : listaVeterinarios) {
            if (veterinario.getCodigo().equals(codigo)) {
                veterinarioEncontrado = veterinario;
            }
        }
        return veterinarioEncontrado;
    }

    //FUNCIONES MENU -------------------------------------------------------------------------------------

    //FUNCIONES PESTANIA DE CLIENTES ---------------------------------------------------------------------

    /**
     * Retorna el cliente dada su cedula
     * @param cedula
     * @return
     */
    public Cliente obtenerCliente(String cedula){
        Cliente clienteEncontrado = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                clienteEncontrado = cliente;
            }
        }
        return clienteEncontrado;
    }

    /**
     * Retorna el valor booleano si se pudo crear un cliente
     * @param nombre
     * @param correo
     * @param cedula
     * @param telefono
     * @param Direccion
     * @return
     * @throws ClienteYaExistenteException
     */
    public boolean crearCliente(String nombre, String correo, String cedula, String telefono, String Direccion) throws ClienteYaExistenteException {
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

    /**
     * Actualiza los datos de un cliente
     * @param nombre
     * @param correo
     * @param cedula
     * @param telefono
     * @param direccion
     * @throws ClienteNoRegistradoException
     */
    public void actualizarCliente(String nombre, String correo, String cedula, String telefono, String direccion) throws ClienteNoRegistradoException{
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if (clienteEncontrado == null) {
            throw new ClienteNoRegistradoException("El cliente no esta registrado");
        } else {
            clienteEncontrado.setNombre(nombre);
            clienteEncontrado.setCorreo(correo);
            clienteEncontrado.setTelefono(telefono);
            clienteEncontrado.setDireccion(direccion);
        }
    }

    /**
     * Elimina un cliente dada su cedula
     * @param cedula
     * @throws ClienteNoRegistradoException
     */
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

    /**
     * Retorna la mascota de un cliente
     * @param clienteEncontrado
     * @param nombreMascota
     * @return
     */
    private Mascota obtenerMascota(Cliente cliente, String nombreMascota) {
        Mascota mascotaEncontrada = null;
        for (Mascota mascota : cliente.getListaMascotas()) {
            if (mascota.getNombre().equals(nombreMascota)) {
                mascotaEncontrada = mascota;
            }
        }
        return mascotaEncontrada;
    }

    //FUNCIONES PESTANIA DE MASCOTAS -----------------------------------------------------------------

    /**
     * Crea una mascota
     * @param nombre
     * @param edad
     * @param sexo
     * @param raza
     * @param tipo
     * @param duenio
     * @return
     * @throws MascotaYaExistenteException
     */
    public boolean crearMascota(String nombre, int edad, SexoMascota sexo, String raza, TipoMascota tipo, Cliente duenio) throws MascotaYaExistenteException {
        boolean  fueCreado = false;
        Mascota mascotaAsociada = obtenerMascota(duenio, nombre);
        if(mascotaAsociada != null){
            throw new MascotaYaExistenteException("Esta mascota ya fue creada");
        }else{
            Mascota mascotaNueva = new Mascota(nombre,edad,sexo,raza,tipo,duenio);
            listaMascotas.add(mascotaNueva);
            fueCreado = true;
        }
        return fueCreado;
    }

    /**
     * Actualiza los datos de una mascota
     * @param nombre
     * @param edad
     * @param raza
     * @param duenio
     * @throws MascotaNoRegistradaException
     */
    public void actualizarMascota(String nombre, int edad, String raza, Cliente duenio) throws MascotaNoRegistradaException {
        Mascota mascotaEncontrada = obtenerMascota(duenio, nombre);
        if(mascotaEncontrada == null){
            throw new MascotaNoRegistradaException("La mascota no esta registrada");
        }else{
            mascotaEncontrada.setNombre(nombre);
            mascotaEncontrada.setEdad(edad);
            mascotaEncontrada.setRaza(raza);
        }
    }

    /**
     * Elimina a una mascota de la lista de mascotas y de la lista del duenio
     * @param nombre
     * @param duenio
     * @throws MascotaNoRegistradaException
     */
    public void eliminarMascota(String nombre, Cliente duenio) throws MascotaNoRegistradaException {
        Mascota mascotaAEliminar = obtenerMascota(duenio, nombre);
        for(Mascota mascota : listaMascotas){
            if(mascota.getDuenio().equals(duenio)){
                mascotaAEliminar = mascota;
            }
            if(mascotaAEliminar !=null){
                listaMascotas.remove(mascotaAEliminar);
                duenio.getListaMascotas().remove(mascotaAEliminar);
            }else{
                throw new MascotaNoRegistradaException("La mascota con duenño " + duenio + "no existe");
            }
        }
    }

    //FUNCIONES PESTANIA ATENCION VETERINARIA --------------------------------------------------------

    /**
     * Valida que una fehca esté en el formato correcto
     * @param fecha
     * @return
     */
    public boolean validarFechaAtencion(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        try {
            formatoFecha.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Si los objetos son encontrados genero la atencion
     * @param cedulaCliente
     * @param nombreMascota
     * @param codigoVeterinario
     * @param fecha
     * @return
     */
    public String generarAtencion(String cedulaCliente, String nombreMascota, String codigoVeterinario, String fecha) {
        String fueCreado = "";
        Veterinario veterinarioEncontrado = obtenerVeterinario(codigoVeterinario);
        Cliente clienteEncontrado = obtenerCliente(cedulaCliente);
        Mascota mascotaEncontrada = null;
        if (veterinarioEncontrado == null) {
            fueCreado += "El código del veterinario no existe\n";
        }
        if (clienteEncontrado == null) {
            fueCreado += "La cédula del cliente no existe";
        } else {
            mascotaEncontrada = obtenerMascota(clienteEncontrado, nombreMascota);
        }
        if (mascotaEncontrada == null) {
            fueCreado += "El nombre de la mascota no corresponde a una mascota del dueño\n";
        }
        //Dependiendo de fueCreado se sabe si todos los valores son correctos o no
        if (fueCreado.equals("")) {
            AtencionVeterinaria atencionVeterinaria = new AtencionVeterinaria(clienteEncontrado, mascotaEncontrada, veterinarioEncontrado, EstadoAtencion.CREADA, fecha);
            listaAtencionVeterinaria.add(atencionVeterinaria);
        }
        return fueCreado;
    }


    //FUNCIONES PESTANIA LISTA DE ATENCIONES ---------------------------------------------------------

    /**
     * Cancela una atencion veterinaria cambiando su estado a CANCELADA
     * @param atencionVeterinaria
     * @return
     */
    public boolean cancelarAtencionVeterinaria(AtencionVeterinaria atencionVeterinaria) {
        boolean existeAtencion = existeAtencion(atencionVeterinaria);
        if (existeAtencion && atencionVeterinaria.getEstadoAtencion().equals(EstadoAtencion.CREADA)) {
            atencionVeterinaria.setEstadoAtencion(EstadoAtencion.CANCELADA);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Reviso que una atencion si exista
     * @param atencionVeterinaria
     * @return
     */
    private boolean existeAtencion(AtencionVeterinaria atencionVeterinaria) {
        for (AtencionVeterinaria atencionVeterinariaAux : listaAtencionVeterinaria) {
            if (atencionVeterinariaAux.equals(atencionVeterinaria)) {
                return true;
            }
        }
        return false;
    }

    //FUCNIONES PESTANIA LISTA DE FACTURAS -----------------------------------------------------------

    /**
     * Obtengo las observaciones de una factura
     * @param facturaSeleccion
     * @return
     */
    public String verObservacionesFacturas(Factura facturaSeleccion) {
        String observaciones = facturaSeleccion.getObservaciones();
        return observaciones;
    }

    //FUNCIONES PESTANIA HISTORIAL CLINICO -----------------------------------------------------------

    /**
     * Obtengo la mascota correspondiente a la cedula del duenio y a el nombre de la misma
     * @param cedula
     * @param nombreMascota
     * @return
     */
    public Mascota obtenerMascotaHistorial(String cedula, String nombreMascota) {
        Cliente clienteEncontrado = obtenerCliente(cedula);
        Mascota mascotaEncontrada = null;
        if (clienteEncontrado != null) {
            mascotaEncontrada = obtenerMascota(clienteEncontrado, nombreMascota);
        }
        return mascotaEncontrada;
    }

    //FUNCIONES PESTANIA FILTRAR CITAS ---------------------------------------------------------------

    /**
     * Valida que las fechas del reporte esten correctas (la fecha inicial debe ser menor a la final)
     * @param fechaInicialFiltrar
     * @param fechaFinalFiltrar
     * @return
     * @throws ParseException
     */
    public boolean validarFechasFiltrar(String fechaInicialFiltrar, String fechaFinalFiltrar) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
        Date fechaInicio = simpleDateFormat.parse(fechaInicialFiltrar);
        Date fechaFinal = simpleDateFormat.parse(fechaFinalFiltrar);
        return fechaInicio.before(fechaFinal);
    }

    /**
     * Retorna la lista de atenciones que esten dentro de la fecha inicial y la fecha final
     * @param fechaInicialFiltrar
     * @param fechaFinalFiltrar
     * @return
     */
    public ArrayList<AtencionVeterinaria> getListaAtencionesFechas(String fechaInicialFiltrar, String fechaFinalFiltrar) {
        ArrayList<AtencionVeterinaria> listaAtencionesFechas = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
        try {
            Date fechaInicio = simpleDateFormat.parse(fechaInicialFiltrar);
            Date fechaFinal = simpleDateFormat.parse(fechaFinalFiltrar);
            for (AtencionVeterinaria atencionVeterinaria : listaAtencionVeterinaria) {
                Date fechaAtencion = simpleDateFormat.parse(atencionVeterinaria.getFechaAtencion());
                if (fechaAtencion.after(fechaInicio) && fechaAtencion.before(fechaFinal)) {
                    listaAtencionesFechas.add(atencionVeterinaria);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return listaAtencionesFechas;
    }

    //FUNCIONES PARA LA ATENCION CITA ----------------------------------------------------------------

    /**
     * Crea la factura correspondiente a la atencion veterinaria ya finalizada
     * @param atencionVeterinaria
     * @param precio
     * @param observaciones
     */
    public void crearFactura(AtencionVeterinaria atencionVeterinaria, Double precio, String observaciones) {
        atencionVeterinaria.setEstadoAtencion(EstadoAtencion.ATENTIDA);
        Factura factura = new Factura(precio, observaciones, atencionVeterinaria);
        listaFacturas.add(factura);
    }

    //FUNCIONES PARA EL HISTORIAL CLINICO -------------------------------------------------------------

    /**
     * Retorna un array de las facturas correspondientes a una mascota
     * @param mascotaHistorial
     * @return
     */
    public ArrayList<Factura> getHistorialMascota(Mascota mascotaHistorial) {
        ArrayList<Factura> listadoMascotaHistorial = new ArrayList<Factura>();
        for (Factura factura : listaFacturas) {
            if (factura.getAtencionVeterinaria().getMascota().getNombre().equals(mascotaHistorial.getNombre()) && factura.getAtencionVeterinaria().getMascota().getDuenio().equals(mascotaHistorial.getDuenio())) {
                listadoMascotaHistorial.add(factura);
            }
        }
        return listadoMascotaHistorial;
    }
}
