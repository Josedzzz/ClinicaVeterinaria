package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import com.joki.veterinaria.exceptions.ClienteNoRegistradoException;
import com.joki.veterinaria.exceptions.ClienteYaExistenteException;
import com.joki.veterinaria.exceptions.MascotaNoRegistradaException;
import com.joki.veterinaria.exceptions.MascotaYaExistenteException;
import com.joki.veterinaria.model.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController implements Initializable {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    //VARIABLES PESTANIA CLIENTES --------------------------------------------------------------------------------

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private Button btnAniadirCliente;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private Button btnMostrarMascotasCliente;

    @FXML
    private Button btnNuevoCliente;

    @FXML
    private TableColumn<Cliente, String> columnCedulaCliente;

    @FXML
    private TableColumn<Cliente, String> columnCorreoCliente;

    @FXML
    private TableColumn<Cliente, String> columnDireccionCliente;

    @FXML
    private TableColumn<Cliente, String> columnNombreCliente;

    @FXML
    private TableColumn<Cliente, String> columnTelefonoCliente;

    @FXML
    private TableView<Cliente> tableViewCliente;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtCorreoCliente;

    @FXML
    private TextField txtDireccionCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtTelefonoCliente;

    //VARIABLES PESTANIA MASCOTAS ---------------------------------------------------------------

    @FXML
    private Button btnActualizarMascota;

    @FXML
    private Button btnAniadirMascota;

    @FXML
    private Button btnEliminarMascota;

    @FXML
    private Button btnNuevaMascota;

    @FXML
    private TableColumn<Mascota, String> columnCedulaMascota;

    @FXML
    private TableColumn<Mascota, String> columnEdadMascota;

    @FXML
    private TableColumn<Mascota, String> columnNombreMascota;

    @FXML
    private TableColumn<Mascota, String> columnRazaMascota;

    @FXML
    private TableColumn<Mascota, String> columnSexoMascota;

    @FXML
    private TableColumn<Mascota, String> columnTipoMascota;

    @FXML
    private ComboBox<SexoMascota> comboBoxSexoMascota;

    @FXML
    private ComboBox<TipoMascota> comboBoxTipoMascota;

    @FXML
    private TableView<Mascota> tableViewMascota;

    @FXML
    private TextField txtCedulaMascota;

    @FXML
    private TextField txtEdadMascota;

    @FXML
    private TextField txtNombreMascota;

    @FXML
    private TextField txtRazaMascota;

    //VARIABLES PESTANIA ATENCION VETERINARIA ------------------------------------------------------

    @FXML
    private Button btnGenerarCitaAtencion;

    @FXML
    private DatePicker datePickerFechaAtencion;

    @FXML
    private TextField txtCedulaClienteAtencion;

    @FXML
    private ComboBox<String> comboBoxCodigoVeterinario;

    @FXML
    private TextField txtNombreMascotaAtencion;

    //PESTANIA LISTA ATENCIONES ------------------------------------------------------------------------

    @FXML
    private Button btnAtenderCitaAtencion;

    @FXML
    private Button btnCancelarCitaAtencion;

    @FXML
    private TableColumn<AtencionVeterinaria, String> columnClienteAtencion;

    @FXML
    private TableColumn<AtencionVeterinaria, String> columnEstadoAtencion;

    @FXML
    private TableColumn<AtencionVeterinaria, String> columnFechaAtencion;

    @FXML
    private TableColumn<AtencionVeterinaria, String> columnMascotaAtencion;

    @FXML
    private TableColumn<AtencionVeterinaria, String> columnVeterinarioAtencion;

    @FXML
    private TableView<AtencionVeterinaria> tableViewAtenciones;

    //PESTANIA LISTA FACTURAS -------------------------------------------------------------------------

    @FXML
    private TableColumn<Factura, String> columnClienteFactura;

    @FXML
    private TableColumn<Factura, String> columnCostoFactura;

    @FXML
    private TableColumn<Factura, String> columnFechaFactura;

    @FXML
    private TableColumn<Factura, String> columnMascotaFactura;

    @FXML
    private TableColumn<Factura, String> columnObservacionesFactura;

    @FXML
    private TableColumn<Factura, String> columnVeterinarioFactura;

    @FXML
    private TableView<Factura> tableViewFacturas;

    @FXML
    private Button btnVerObservacionesFacturas;

    //PESTANIA HISTORIAL CLINICO --------------------------------------------------------------------

    @FXML
    private Button btnGenerarHistorial;

    @FXML
    private TextField txtCedulaClienteHistorial;

    @FXML
    private TextField txtNombreMascotaHistorial;

    //PESTANIA FILTRAR CITAS -----------------------------------------------------------------------

    @FXML
    private Button btnGenerarFiltrar;

    @FXML
    private Button btnReiniciarFiltrar;

    @FXML
    private TableColumn<AtencionVeterinaria, String> columnClienteFiltrar;

    @FXML
    private TableColumn<AtencionVeterinaria, String> columnEstadoAtencionFiltrar;

    @FXML
    private TableColumn<AtencionVeterinaria, String> columnFechaFiltrar;

    @FXML
    private TableColumn<AtencionVeterinaria, String> columnVeterinarioFiltrar;

    @FXML
    private TableColumn<AtencionVeterinaria, String> columnMascotaFiltrar;

    @FXML
    private DatePicker datePickerFinalFiltrar;

    @FXML
    private DatePicker datePickerIncialFiltrar;

    @FXML
    private TableView<AtencionVeterinaria> tableViewFiltrar;

    //Declaro variables auxiliares
    private Stage stage;
    private Application application;
    private LoginController loginController;
    private Veterinario veterinarioLogin;
    ObservableList<Cliente> listadoClientes = FXCollections.observableArrayList();
    private Cliente clienteSeleccion;
    ObservableList<Mascota> listadoMascotas = FXCollections.observableArrayList();
    private Mascota mascotaSeleccion;
    private String fechaAtencion;
    ObservableList<AtencionVeterinaria> listadoAtenciones = FXCollections.observableArrayList();
    private AtencionVeterinaria atencionVeterinariaSeleccion;
    ObservableList<Factura> listadoFacturas = FXCollections.observableArrayList();
    ObservableList<AtencionVeterinaria> listadoAtencionesFiltrar = FXCollections.observableArrayList();
    private Factura facturaSeleccion;
    private String fechaInicialFiltrar;
    private String fechaFinalFiltrar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Datos de la tableViewCliente
        this.columnNombreCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
        this.columnCorreoCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCorreo()));
        this.columnCedulaCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCedula()));
        this.columnTelefonoCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getTelefono()));
        this.columnDireccionCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getDireccion()));
        //Seleccion de clientes en la tabla
        tableViewCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                clienteSeleccion = newSelection;
                clienteSeleccion = tableViewCliente.getSelectionModel().getSelectedItem();
                llenarCamposCliente(clienteSeleccion);
                txtCedulaCliente.setDisable(true);
            }
        });

        //Datos en la tableViewMascota
        this.columnNombreMascota.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
        this.columnEdadMascota.setCellValueFactory(e -> {
            int edadMascota = e.getValue().getEdad();
            String edad = String.valueOf(edadMascota);
            return new ReadOnlyStringWrapper(edad);
        });
        this.columnRazaMascota.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getRaza()));
        this.columnSexoMascota.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getSexo().toString()));
        this.columnCedulaMascota.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getDuenio().getCedula()));
        this.columnTipoMascota.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getTipo().toString()));
        //Seleccion de mascotas en la tabla
        tableViewMascota.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println(newSelection);
                mascotaSeleccion = newSelection;
                mascotaSeleccion = tableViewMascota.getSelectionModel().getSelectedItem();
                llenarCamposMascota(mascotaSeleccion);
            }
            txtCedulaMascota.setDisable(true);
        });


        //Manejo de comboBox de codigos de los veterinarios en la pestania Atencion veterinaria
        Veterinario[] listaVeter = mfm.clinica.getListaVeterinarios();
        for(Veterinario veterinario : listaVeter){
            comboBoxCodigoVeterinario.getItems().add(veterinario.getCodigo());
        }

        //Datos del comboBox de sexo mascotas
        this.comboBoxSexoMascota.getItems().addAll(SexoMascota.values());
        //Datos del comboBox de tipo mascotas
        this.comboBoxTipoMascota.getItems().addAll(TipoMascota.values());


        //Manejo de la fecha para atenciones veterinarias
        datePickerFechaAtencion.setOnAction(event -> {
            LocalDate date = datePickerFechaAtencion.getValue();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechaAtencion = date.format(formato);
        });

        //Datos en la tableViewAtenciones
        this.columnClienteAtencion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCliente().getCedula()));
        this.columnMascotaAtencion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getMascota().getNombre()));
        this.columnVeterinarioAtencion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getVeterinario().getNombre()));
        this.columnFechaAtencion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getFechaAtencion()));
        this.columnEstadoAtencion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getEstadoAtencion().toString()));
        //Selecciono atenciones de la tabla
        tableViewAtenciones.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                atencionVeterinariaSeleccion = newSelection;
            }
        });

        //Datos en la tableViewFacturas
        this.columnClienteFactura.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getAtencionVeterinaria().getCliente().getCedula()));
        this.columnMascotaFactura.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getAtencionVeterinaria().getMascota().getNombre()));
        this.columnVeterinarioFactura.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getAtencionVeterinaria().getVeterinario().getNombre()));
        this.columnObservacionesFactura.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getObservaciones()));
        this.columnCostoFactura.setCellValueFactory(e -> {
            double costoFactura = e.getValue().getCosto();
            String costo = String.valueOf(costoFactura);
            return new ReadOnlyStringWrapper(costo);
        });
        this.columnFechaFactura.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getAtencionVeterinaria().getFechaAtencion().toString()));
        //Selecciono facturas en la tabla
        tableViewFacturas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                facturaSeleccion = newSelection;
            }
        });

        //Datos en la tableViewFiltrar
        this.columnClienteFiltrar.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCliente().getCedula()));
        this.columnMascotaFiltrar.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getMascota().getNombre()));
        this.columnVeterinarioFiltrar.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getVeterinario().getNombre()));
        this.columnFechaFiltrar.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getFechaAtencion().toString()));
        this.columnEstadoAtencionFiltrar.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getEstadoAtencion().toString()));

        //Manejo de la fecha inicial y final para manejo de atencionesVeterinarias filtradas
        datePickerIncialFiltrar.setOnAction(event -> {
            LocalDate date = datePickerIncialFiltrar.getValue();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechaInicialFiltrar = date.format(formato);
        });

        datePickerFinalFiltrar.setOnAction(event -> {
            LocalDate date = datePickerFinalFiltrar.getValue();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechaFinalFiltrar = date.format(formato);
        });
    }

    public void setAplicacion(Application application) {
        this.application = application;
        //Lista de clientes a mostrar
        tableViewCliente.getItems().clear();
        tableViewCliente.setItems(getListaClientes());
        //Lista de mascotas a mostrar
        tableViewMascota.getItems().clear();
        tableViewMascota.setItems(getListaMascotas());
        //Lista de atenciones a mostrar
        tableViewAtenciones.getItems().clear();
        tableViewAtenciones.setItems(getListaAtenciones());
        //Lista de facturas a mostrar
        tableViewFacturas.getItems().clear();
        tableViewFacturas.setItems(getListaFacturas());
    }

    /**
     * Obtengo la lista de clientes de la clinica
     * @return
     */
    private ObservableList<Cliente> getListaClientes() {
        listadoClientes.addAll(mfm.getListaClientes());
        return listadoClientes;
    }

    /**
     * Obtengo la lista de mascotas de la clinica
     * @return
     */
    private ObservableList<Mascota> getListaMascotas() {
        listadoMascotas.addAll(mfm.getListaMascotas());
        return listadoMascotas;
    }

    /**
     * Obtengo la lista de atenciones de la clinica
     * @return
     */
    private ObservableList<AtencionVeterinaria> getListaAtenciones() {
        listadoAtenciones.addAll(mfm.getListaAtenciones());
        return listadoAtenciones;
    }

    /**
     * Obtenfo la lista de facturas de la clinica
     * @return
     */
    private ObservableList<Factura> getListaFacturas() {
        listadoFacturas.addAll(mfm.getListaFacturas());
        return listadoFacturas;
    }

    public void init(Stage stage, LoginController loginController, Veterinario veterinarioLogin) {
        this.stage = stage;
        this.loginController = loginController;
        this.veterinarioLogin = veterinarioLogin;
    }

    /**
     * Muestra un mensaje por pantalla
     * @param title
     * @param header
     * @param content
     * @param alertType
     */
    public void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Muestro el menu y actualizo los datos
     */
    public void show() {
        stage.show();
        System.out.println(veterinarioLogin.toString());
        //Lista de clientes a mostrar
        tableViewCliente.getItems().clear();
        tableViewCliente.setItems(getListaClientes());
        //Lista de mascotas a mostrar
        tableViewMascota.getItems().clear();
        tableViewMascota.setItems(getListaMascotas());
        //Lista de atenciones a mostrar
        tableViewAtenciones.getItems().clear();
        tableViewAtenciones.setItems(getListaAtenciones());
        //Lista de facturas a mostrar
        tableViewFacturas.getItems().clear();
        tableViewFacturas.setItems(getListaFacturas());
    }

    //FUNCIONES PESTANIA CLIENTES ----------------------------------------------------------------

    @FXML
    void cerrarSesion(ActionEvent event) {
        this.stage.close();
        loginController.show();
    }

    /*
    Limpia los textFields despues de ser seleccionados
     */
    public void limpiarCamposCliente(){
        txtNombreCliente.clear();
        txtCedulaCliente.clear();
        txtCorreoCliente.clear();
        txtDireccionCliente.clear();
        txtTelefonoCliente.clear();
    }

    /*
    Setea los datos seleccionados de la table view para ser mostrados
     */
    public void llenarCamposCliente(Cliente clienteSeleccion) {
        txtNombreCliente.setText(clienteSeleccion.getNombre());
        txtCedulaCliente.setText(clienteSeleccion.getCedula());
        txtCorreoCliente.setText(clienteSeleccion.getCorreo());
        txtDireccionCliente.setText(clienteSeleccion.getDireccion());
        txtTelefonoCliente.setText(clienteSeleccion.getTelefono());
    }

    /*
    Setea los datos vacios del cliente para crearlo
     */
    @FXML
    void nuevoCliente(ActionEvent event) {
        txtCedulaCliente.setDisable(false);
        txtNombreCliente.setText("");
        txtCedulaCliente.setText("");
        txtCorreoCliente.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCliente.setText("");
        clienteSeleccion = null;
    }
    /*
    Actualiza los datos de un cliente seleccionado
     */
    @FXML
    void actualizarCliente(ActionEvent event) throws ClienteNoRegistradoException {
        String nombre = txtNombreCliente.getText();
        String correo = txtCorreoCliente.getText();
        String cedula = txtCedulaCliente.getText();
        String telefono = txtTelefonoCliente.getText();
        String direccion = txtDireccionCliente.getText();
        if (clienteSeleccion != null) {
            if (datosValidosCliente(nombre, correo, cedula, telefono, direccion)) {
                mfm.actualizarCliente(nombre, correo, cedula, telefono, direccion);
                //Actualizo los datos en la interfaz
                clienteSeleccion.setNombre(nombre);
                clienteSeleccion.setCorreo(correo);
                clienteSeleccion.setCedula(cedula);
                clienteSeleccion.setTelefono(telefono);
                clienteSeleccion.setDireccion(direccion);
                //Actualizo la table view
                tableViewCliente.refresh();
                mostrarMensaje("Notificacion Veterinaria", "Cliente Actualizado", "El cliente " + nombre +
                        " ha sido actualizado", Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje("Notificacion Veterinaria", "Cliente no seleccionado", "No se ha seleccionado " +
                    "ningun cliente", Alert.AlertType.WARNING);
        }
    }
    /*
    Verifica que los datos del cliente no esten vacio
     */
    private boolean datosValidosCliente(String nombre, String correo, String cedula, String telefono, String direccion) {
        String notifiacaion = "";
        if(nombre == null || nombre.equals("")){
            notifiacaion += "El nombre es invalido\n";
        }
        if(correo == null || correo.equals("")){
            notifiacaion += "El correo es invalido\n";
        }
        if(cedula == null || cedula.equals("")){
            notifiacaion += "La cedula es invalida\n";
        }
        if(telefono == null || telefono.equals("")){
            notifiacaion += "El telefono es invalido\n";
        }
        if(direccion == null || direccion.equals("")){
            notifiacaion += "La direccion es invalida\n";
        }
        //Si no hay notificacion los datos son validos
        if(notifiacaion.equals("")){
            return true;
        }
        mostrarMensaje("Notificacion Clinica", "Infacion del cliente invalida", notifiacaion, Alert.AlertType.WARNING);
        return false;
    }

    /*
    Registra el cliente si los datos son validos (llama a crear cliente)
     */
    @FXML
    void aniadirCliente(ActionEvent event) throws ClienteYaExistenteException {
        txtCedulaCliente.setDisable(false);
        String nombre = txtNombreCliente.getText();
        String correo = txtCorreoCliente.getText();
        String cedula = txtCedulaCliente.getText();
        String telefono = txtTelefonoCliente.getText();
        String direccion = txtDireccionCliente.getText();
        if(datosValidosCliente(nombre, correo, cedula, telefono,direccion)){
            crearCliente(nombre, correo, cedula, telefono, direccion);
            limpiarCamposCliente();
            ObservableList<String> clientesNuevos = FXCollections.observableArrayList(cedula);
        }
    }
    /*
    Crea un cliente con los datos simepre y cuando no se repitan
     */
    private void crearCliente(String nombre, String correo, String cedula, String telefono, String direccion) {
        boolean fueCreado;
        try{
            fueCreado = mfm.crearCliente(nombre, correo, cedula, telefono, direccion);
            if(fueCreado){
                //Añado cliente a la table view
                tableViewCliente.getItems().clear();
                tableViewCliente.setItems(getListaClientes());
                mostrarMensaje("Notificacion Veterinaria", "Cliente Registrado", "El cliente " + nombre +
                        " ha sido registrado", Alert.AlertType.WARNING);
            }
        }catch (ClienteYaExistenteException e){
            mostrarMensaje("Notificacion Veterinaria", "Cliente no registrado", "El cliente con cedula" + cedula +
                    " ya existe", Alert.AlertType.WARNING);
        }
    }

    /*
    Elimina a un cliente selccionado en la table view
     */
    @FXML
    void eliminarCliente(ActionEvent event) throws ClienteNoRegistradoException{
        txtCedulaCliente.setDisable(false);
        String nombre = txtNombreCliente.getText();
        clienteSeleccion = tableViewCliente.getSelectionModel().getSelectedItem();
        if(clienteSeleccion != null){
            listadoClientes.remove(clienteSeleccion);
            mostrarMensaje("Norificacion Veterinaria", "Cliente eliminado", "El cliente " + nombre +
                    "ha sido eliminado", Alert.AlertType.WARNING );
            limpiarCamposCliente();
            txtCedulaCliente.setDisable(false);
        }else{
            mostrarMensaje("Notificacion Veterinaria","Cliente eliminado", "Ningun cliente" +
                    " ha sido seleccionado", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void mostrarMascotaCliente(ActionEvent event) {
        if(clienteSeleccion != null){
            for (Mascota mascota : clienteSeleccion.getListaMascotas()) {
                mostrarMensaje("Notificacion Veterinaria", "Lista mascotas", mascota.getNombre() +","+ clienteSeleccion.getCedula(), Alert.AlertType.INFORMATION);
                //recorrer la lista y sacar los atributos importantes y concatenarlos en un string
            }
        }else{
            tableViewMascota.getItems().clear();
        }
        mostrarMensaje("Notificacion Veterinaria", "Cliente no seleccionado", "No se selecciono " +
                "ningun cliente", Alert.AlertType.WARNING);
    }

    //FUNCIONES PARA PESTANIA DE MASCOTAS ------------------------------------------------------------

    /*
    Limpia los textFields despues de ser seleccionados
     */
    public void limpiarCamposMascota(){
        txtNombreMascota.clear();
        txtEdadMascota.clear();
        txtRazaMascota.clear();
        txtCedulaMascota.clear();
        comboBoxTipoMascota.getSelectionModel().clearSelection();
        comboBoxSexoMascota.getSelectionModel().clearSelection();
    }

    /*
   Setea los datos seleccionados en la table view para ser mostrados
    */
    public void llenarCamposMascota(Mascota mascotaSeleccion) {
        txtCedulaMascota.setDisable(false);
        String edadString = Integer.toString(mascotaSeleccion.getEdad());
        txtNombreMascota.setText(mascotaSeleccion.getNombre());
        txtEdadMascota.setText(edadString);
        txtRazaMascota.setText(mascotaSeleccion.getRaza());
        txtCedulaMascota.setText(mascotaSeleccion.getDuenio().getCedula());
        comboBoxSexoMascota.getSelectionModel().select(mascotaSeleccion.getSexo());
        comboBoxTipoMascota.getSelectionModel().select(mascotaSeleccion.getTipo());
    }

    /*
    Setea los datos vacios del cliente para crearlo
     */
    @FXML
    void nuevaMascota(ActionEvent event) {
        txtCedulaMascota.setDisable(false);
        txtNombreMascota.setText("");
        txtEdadMascota.setText("");
        txtRazaMascota.setText("");
        txtCedulaMascota.setText("");
        comboBoxSexoMascota.setValue(null);
        comboBoxTipoMascota.setValue(null);
        mascotaSeleccion = null;
    }

    /*
    Actualiza los datos de una mascota
     */
    @FXML
    void actualizarMascota(ActionEvent event) throws MascotaNoRegistradaException {
        String nombre = txtNombreMascota.getText();
        String edad = txtEdadMascota.getText();
        String raza = txtRazaMascota.getText();
        String cedulaCliente = txtCedulaMascota.getText();

        Cliente cliente = mfm.clinica.obtenerCliente(cedulaCliente);

        TipoMascota tipo = comboBoxTipoMascota.getValue();
        SexoMascota sexo = comboBoxSexoMascota.getValue();
        if(mascotaSeleccion != null){
            if(datosValidosMascota(nombre,edad,raza,cedulaCliente,sexo,tipo)){
                mfm.actualizarMascota(nombre, Integer.parseInt(edad),raza,cliente);
                //Actualiza los datos de la interfaz
                mascotaSeleccion.setNombre(nombre);
                mascotaSeleccion.setEdad(Integer.parseInt(edad));
                mascotaSeleccion.setRaza(raza);
                //Actualiza los datos de la tabla de mascotas
                tableViewMascota.refresh();
                mostrarMensaje("Notificacion Veterinaria", "Mascota Actualizada", "La mascota " + nombre +
                        "ha sido actualizado", Alert.AlertType.WARNING);
            }
        }else{
            mostrarMensaje("Notificacion Veterinaria","Mascota no seleccionada", "No se ha seleccionado" +
                    " ningun mascota", Alert.AlertType.WARNING);
        }
    }

    /*
    Verifica que los datos de mascotas no esten vacios
     */
    private boolean datosValidosMascota(String nombre, String edad, String raza, String cedulaMascota, SexoMascota sexo, TipoMascota tipo) {

        String notificacion = "";
        if(nombre == null || nombre.equals("")){
            notificacion += "El nombre es invalido";
        }
        if(edad == null || edad.equals("")){
            notificacion += "La edad es invalida";
        }
        if(raza == null || raza.equals("")){
            notificacion += "La raza es invalida";
        }
        if(cedulaMascota == null || cedulaMascota.equals("")){
            notificacion += "La cedula es invalida";
        }
        if(tipo == null){
            notificacion += "El tipo es invalido";
            return false;
        }
        if(sexo == null){
            notificacion += "El sexo es invalido";
            return false;
        }
        //Si no hay notificacion los datos son validos
        if(notificacion.equals("")) {
            return true;
        }
        mostrarMensaje("Notificacion Veterinaria", "Mascota invalida", notificacion, Alert.AlertType.WARNING);
        return false;
    }

    /*
    Registra la mascota si los datos son validos (llama a crear la mascota)
     */
    @FXML
    void aniadirMascota(ActionEvent event) throws MascotaYaExistenteException {
        txtCedulaMascota.setDisable(false);
        String nombre = txtNombreMascota.getText();
        String edad = txtEdadMascota.getText();
        String raza = txtRazaMascota.getText();
        String cedulaDuenioMascota = txtCedulaMascota.getText();
        Cliente duenio = mfm.clinica.obtenerCliente(cedulaDuenioMascota);

        if(duenio != null) {

            TipoMascota tipo = comboBoxTipoMascota.getValue();
            SexoMascota sexo = comboBoxSexoMascota.getValue();

            if (datosValidosMascota(nombre, edad, raza, cedulaDuenioMascota, sexo, tipo)) {
                crearMascota(nombre, Integer.parseInt(edad), sexo, raza, tipo, duenio);
                limpiarCamposMascota();
                tableViewCliente.getSelectionModel().clearSelection();
            }
        }else{
            mostrarMensaje("Notificacion veterinaria", "Error mascota", "Los datos son invalidos ", Alert.AlertType.ERROR);
        }
    }

    /*
    Crea una mascota con todos los datos siempre y cuando la cedula no se repita
     */
    private void crearMascota(String nombre,int edad,SexoMascota sexo,String raza,TipoMascota tipo, Cliente duenio) {
        boolean fueCreado;
        try {
            fueCreado = mfm.crearMascota(nombre,edad,sexo,raza,tipo,duenio);
            if(fueCreado){
                //Añade las mascota a la tabla de mascotas
                tableViewMascota.getItems().clear();
                tableViewMascota.setItems(getListaMascotas());
                mostrarMensaje("Notificacion Mascota","Mascota creada", "La mascota " + nombre +
                        " ha sido creado", Alert.AlertType.WARNING);
            }
        }catch (MascotaYaExistenteException e){
            mostrarMensaje("Notificacion Mascota","Mascota no creada", "La mascota " + nombre +
                    " ya exsite", Alert.AlertType.WARNING);
        }

    }

    //comboBoxTipoMascota.setValue( capturar tipo mascota );

    /*
   Elemina a una mascota selccionado en la table view
    */
    @FXML
    void eliminarMascota(ActionEvent event) throws MascotaNoRegistradaException {
        String cedulaMascota = txtCedulaMascota.getText();
        mascotaSeleccion = tableViewMascota.getSelectionModel().getSelectedItem();
        if(mascotaSeleccion != null){
            listadoMascotas.remove(mascotaSeleccion);
            mostrarMensaje("Norificacion Veterinaria", "Mascota eliminada", "La mascota " + cedulaMascota +
                    " ha sido eliminada", Alert.AlertType.WARNING );
            limpiarCamposMascota();
        }else{
            mostrarMensaje("Notificacion Veterinaria","Mascota eliminada", "Ninguna mascota " +
                    " ha sido seleccionada", Alert.AlertType.WARNING);
        }
    }

    //FUNCIONES PARA PESTANIA DE ATENCION VETERINARIA ------------------------------------------------

    @FXML
    void generarCitaAtencion(ActionEvent event) {
        String cedulaCliente = txtCedulaClienteAtencion.getText();
        String nombreMascota = txtNombreMascotaAtencion.getText();
        String codigoVeterinario = comboBoxCodigoVeterinario.getSelectionModel().getSelectedItem();
        if (datosValidosAtencion(cedulaCliente, nombreMascota, codigoVeterinario, fechaAtencion)) {
            generarCitaAtencion(cedulaCliente, nombreMascota, codigoVeterinario, fechaAtencion);
        }
    }

    /**
     * Verifica que los datos esten llenados y que la fecha esté en el formato indicado
     * @param cedulaCliente
     * @param nombreMascota
     * @param codigoVeterinario
     * @param fecha
     * @return
     */
    private boolean datosValidosAtencion(String cedulaCliente, String nombreMascota, String codigoVeterinario, String fecha) {
        String notificacion = "";
        boolean fechaValida = mfm.validarFechaAtencion(fecha);
        if (cedulaCliente == null || cedulaCliente.equals("")) {
            notificacion += "Ingrese la cedula del cliente\n";
        }
        if (nombreMascota == null || nombreMascota.equals("")) {
            notificacion += "Ingrese el nombre de la mascota \n";
        }
        if (codigoVeterinario == null || codigoVeterinario.equals("")) {
            notificacion += "Ingrese el código del veterinario \n";
        }
        if (!fechaValida) {
            notificacion += "La fecha de la atención es invalida\n";
        }
        //Si no hay notificacion es porque los datos estan validos
        if (notificacion.equals("")) {
            return true;
        }
        mostrarMensaje("Notificación atención", "Información para la atención invalida", notificacion, Alert.AlertType.WARNING);
        return false;
    }

    /**
     * Genera una cita si todos los datos son validos y existen
     * @param cedulaCliente
     * @param nombreMascota
     * @param codigoVeterinario
     * @param fecha
     */
    private void generarCitaAtencion(String cedulaCliente, String nombreMascota, String codigoVeterinario, String fecha) {
        String fueGenerada = ""; //Variable auxiliar para revisar campos
        fueGenerada = mfm.generarAtencion(cedulaCliente, nombreMascota, codigoVeterinario, fecha);
        if (fueGenerada.equals("")) {
            //Add atencion a la tableView
            tableViewAtenciones.getItems().clear();
            tableViewAtenciones.setItems(getListaAtenciones());
            txtCedulaClienteAtencion.setText("");
            txtNombreMascotaAtencion.setText("");
            comboBoxCodigoVeterinario.setValue(null);
            mostrarMensaje("Notificación atención", "Atención generada correctamente", "La cita ya se encuentra en el sistema", Alert.AlertType.CONFIRMATION);
        } else {
            mostrarMensaje("Notificación atención", "Información no valida", fueGenerada, Alert.AlertType.WARNING);
        }
    }

    //FUNCIONES PARA PESTANIA LISTA DE ATENCIONES -----------------------------------------------------

    /**
     * Genera la ventana para atender una nueva cita
     * @param event
     * @throws IOException
     */
    @FXML
    void atenderCitaAtencion(ActionEvent event) throws IOException {
        if (atencionVeterinariaSeleccion != null) {
            if (atencionVeterinariaSeleccion.getEstadoAtencion().equals(EstadoAtencion.CREADA)) {
                if (atencionVeterinariaSeleccion.getVeterinario().equals(veterinarioLogin)) {
                    if (mfm.esFechaActual(atencionVeterinariaSeleccion.getFechaAtencion())) {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Application.class.getResource("/com/joki/veterinaria/AtencionCitaView.fxml"));
                        BorderPane borderPane = (BorderPane) loader.load();
                        AtencionCitaController controller = loader.getController();
                        controller.setAplicacion(application);
                        Scene scene = new Scene(borderPane);
                        Stage stage = new Stage();
                        stage.setTitle("Atender cita veterinaria");
                        stage.setScene(scene);
                        controller.init(stage, this, atencionVeterinariaSeleccion);
                        stage.show();
                        this.stage.close();
                        System.out.println(atencionVeterinariaSeleccion.toString());
                    } else {
                        mostrarMensaje("Notificación manejo de citas", "No se puede atender la cita", "Verifique que la fecha de atención sea la fecha actual", Alert.AlertType.WARNING);
                        System.out.println(atencionVeterinariaSeleccion.getFechaAtencion());
                    }
                } else {
                    mostrarMensaje("Notificación manejo de citas", "No se puede atender la cita", "No se inicio sesión como el veterinario encargado", Alert.AlertType.WARNING);
                }
            } else {
                mostrarMensaje("Notificación manejo de citas", "No se puede atender la cita", "Verifique que la cita no esté cancelada o atendida", Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje("Notificación manejo de citas", "Atención no seleccionada", "No se ha seleccionado ninguna atención", Alert.AlertType.WARNING);
        }
    }

    /**
     * Cancela una atencion veterinaria cambiando su estado a CANCELADA
     * @param event
     */
    @FXML
    void cancelarCitaAtencion(ActionEvent event) {
        if (atencionVeterinariaSeleccion != null) {
            boolean atencionCancelada = mfm.cancelarAtencionVeterinaria(atencionVeterinariaSeleccion);
            if (atencionCancelada) {
                tableViewAtenciones.refresh();
                mostrarMensaje("Notificación manejo de citas", "Cita cancelada", "La cita ha sido cancelada correctamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Notificación manejo de citas", "Cita no cancelada", "La cita no ha podido ser cancelada ya que anteriormente fue atendida o cancelada", Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje("Notificación manejo de citas", "Atención no seleccionada", "No se ha seleccionado ninguna atención", Alert.AlertType.WARNING);
        }
    }

    //FUNCIONES PARA PESTANIA LISTA DE FACTURAS ------------------------------------------------------

    /**
     * Selecciona una factura para mostrar el mensaje de las observaciones
     * @param event
     */
    @FXML
    void verObservacionesFacturas(ActionEvent event) {
        if (facturaSeleccion != null) {
            String observacion = mfm.verObservacionesFacturas(facturaSeleccion);
            mostrarMensaje("Notificación facturas", "Las observaciones puestas por el veterinario son: ", observacion, Alert.AlertType.INFORMATION);
        } else {
            mostrarMensaje("Notificación facturas", "Factura no seleccionada", "No se ha seleccionado ninguna factura", Alert.AlertType.WARNING);
        }
    }

    //FUNCIONES PARA PESTANIA HISTORIAL CLINICO -------------------------------------------------------

    /**
     * Abre una ventana en donde se ve el historial clinico de la mascota
     * Paso como parametro la mascota a la cual deseo ver la informacion
     * @param event
     */
    @FXML
    void generarHistorial(ActionEvent event) throws IOException {
        String cedula = txtCedulaClienteHistorial.getText();
        String nombreMascota = txtNombreMascotaHistorial.getText();
        if (datosValidosHistorial(cedula, nombreMascota))  {
            Mascota mascotaHistorial = mfm.obtenerMascotaHistorial(cedula, nombreMascota);
            if (mascotaHistorial != null) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Application.class.getResource("/com/joki/veterinaria/HistorialClinicoView.fxml"));
                BorderPane borderPane = (BorderPane) loader.load();
                HistorialClinicoController controller = loader.getController();
                controller.setApplication(application);
                Scene scene = new Scene(borderPane);
                Stage stage = new Stage();
                stage.setTitle("Historial clinico de la mascota");
                stage.setScene(scene);
                controller.init(stage, this, mascotaHistorial);
                stage.show();
                this.stage.close();
            } else {
                mostrarMensaje("Notificación historial", "Datos invalidos", "Por favor verifique que los datos ingresados sean correctos", Alert.AlertType.WARNING);
            }
        }
    }

    /**
     * Verifica que los datos para el historial no esten vacios
     * @param cedula
     * @param nombreMascota
     * @return
     */
    private boolean datosValidosHistorial(String cedula, String nombreMascota) {
        String notificacion = "";
        if (cedula == null || cedula.equals("")) {
            notificacion += "Ingrese la cedula del dueño";
        }
        if (nombreMascota == null || nombreMascota.equals("")) {
            notificacion += "Ingrese el nombre de la mascota";
        }
        if (notificacion.equals("")) {
            return true;
        }
        mostrarMensaje("Notificación historial", "Información para generar el historial invalida", notificacion, Alert.AlertType.WARNING);
        return false;
    }

    //FUNCIONES PARA PESTANIA FILTRAR CITAS -----------------------------------------------------------

    /**
     * Filtra las citas dada una fecha inicial y una fecha final
     * @param event
     */
    @FXML
    void generarFiltrar(ActionEvent event) {
        if (fechaInicialFiltrar != null && fechaFinalFiltrar != null) {
            try {
                if (mfm.validarFechasFiltrar(fechaInicialFiltrar, fechaFinalFiltrar)) {
                    tableViewFiltrar.getItems().clear();
                    tableViewFiltrar.setItems(getListaAtencionesFechas(fechaInicialFiltrar, fechaFinalFiltrar));
                }
            } catch (ParseException e) {
                mostrarMensaje("Notificación filtrar citas", "Fechas invalidas", "Ocurrió un erro con las fechas ingresadas", Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje("Notificación filtrar citas", "Fechas no seleccionadas", "Por favor seleccionar las fechas", Alert.AlertType.WARNING);
        }
    }

    /**
     * Obtengo la lista de atenciones veterinarias filtradas por una fecha inicial y una fecha final
     * @param fechaInicialFiltrar
     * @param fechaFinalFiltrar
     * @return
     */
    private ObservableList<AtencionVeterinaria> getListaAtencionesFechas(String fechaInicialFiltrar, String fechaFinalFiltrar) {
        listadoAtencionesFiltrar.addAll(mfm.getListaAtencionesFechas(fechaInicialFiltrar, fechaFinalFiltrar));
        return listadoAtencionesFiltrar;
    }


    /**
     * Reinicia los elementos de la tabla a filtrar haciendole un clear a la tabla
     * @param event
     */
    @FXML
    void reiniciarFiltrar(ActionEvent event) {
        tableViewFiltrar.getItems().clear();
    }
}
