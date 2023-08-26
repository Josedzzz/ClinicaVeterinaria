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
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController implements Initializable {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    //VARIABLES PESTANIA CLIENTES --------------------------------------------------------------------------------

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
    private ComboBox<String> comboBoxListaClientes;

    @FXML
    private TableView<Mascota> tableViewMascota;

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
    private ComboBox<Veterinario> comboBoxCodigoVeterinario;

    @FXML
    private ComboBox<String> comboBoxListaClientesAtencionV;

    @FXML
    private TextField txtCodigoVeterinarioAtencion;

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
                System.out.println(newSelection);
                clienteSeleccion = newSelection;
                //llenarCampos();
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
                comboBoxListaClientes.setOnAction(actionEvent -> {
                    int seleccionNuevaCliente = comboBoxListaClientes.getSelectionModel().getSelectedIndex();
                    /*
                    La condición selectedIndex != -1 && selectedIndex != 3 verifica si
                     se ha seleccionado un elemento y si el índice seleccionado no es 3 (que corresponde a "Otro").
                     */
                    comboBoxListaClientes.setDisable(seleccionNuevaCliente !=-1 && seleccionNuevaCliente !=3);
                    comboBoxListaClientes.getValue();
                });
                comboBoxListaClientes.setDisable(true);
            }
        });

        //Manejo de comboBox de cedula clientes en la pestania Atencion Veterinaria
        comboBoxListaClientesAtencionV.setOnAction(actionEvent -> {
            int clienteSeleccionadoAtencion = comboBoxListaClientesAtencionV.getSelectionModel().getSelectedIndex();
            /*
            La condición selectedIndex != -1 && selectedIndex != 3 verifica si
             se ha seleccionado un elemento y si el índice seleccionado no es 3 (que corresponde a "Otro").
             */
            comboBoxListaClientesAtencionV.setDisable(clienteSeleccionadoAtencion !=-1 && clienteSeleccionadoAtencion !=3);
            comboBoxListaClientesAtencionV.getValue();
            comboBoxListaClientesAtencionV.setDisable(false);
        });
        //Manejo de comboBox de codigos de los veterinarios en la pestania Atencion veterinaria
            mfm.clinica.getListaVeterinarios();
            comboBoxCodigoVeterinario.getItems().addAll(mfm.clinica.getListaVeterinarios());
            //MOSTRAR EN EL COMBOBOX LOS CODIGO DE LOS VETERINARIOS

        //Datos en la tableViewAtenciones
        this.columnClienteAtencion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCliente().getCedula()));
        this.columnMascotaAtencion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getMascota().getNombre()));
        this.columnVeterinarioAtencion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getVeterinario().getNombre()));
        this.columnFechaAtencion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getFechaAtencion().toString()));
        this.columnEstadoAtencion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getEstadoAtencion().toString()));

        //Datos en la tableViewFacturas
        this.columnClienteFactura.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCliente().getCedula()));
        this.columnMascotaFactura.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getAtencionVeterinaria().getMascota().getNombre()));
        this.columnVeterinarioFactura.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getAtencionVeterinaria().getVeterinario().getNombre()));
        this.columnObservacionesFactura.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getObservaciones()));
        this.columnCostoFactura.setCellValueFactory(e -> {
            double costoFactura = e.getValue().getCosto();
            String costo = String.valueOf(costoFactura);
            return new ReadOnlyStringWrapper(costo);
        });
        this.columnFechaFactura.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getAtencionVeterinaria().getFechaAtencion().toString()));

        //Datos en la tableViewFiltrar
        //Cliente, nombre mascota, veterinario, fecha, estado Atencion
        this.columnClienteFiltrar.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCliente().getCedula()));
        this.columnMascotaFiltrar.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getMascota().getNombre()));
        this.columnVeterinarioFiltrar.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getVeterinario().getNombre()));
        this.columnFechaFiltrar.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getFechaAtencion().toString()));
        this.columnEstadoAtencionFiltrar.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getEstadoAtencion().toString()));

        //Lleno los combo box para mascota(Sexo,tipo,listaClientes)
        comboBoxTipoMascota.getItems().addAll(TipoMascota.values());
        comboBoxSexoMascota.getItems().addAll(SexoMascota.values());
        comboBoxListaClientes.getItems().addAll();

    }

    public void setAplicacion(Application application) {
        this.application = application;
        //Lista de clientes a mostrar
        tableViewCliente.getItems().clear();
        tableViewCliente.setItems(getListaClientes());
        //Lista de mascotas a mostrar
        tableViewMascota.getItems().clear();
        tableViewMascota.setItems(getListaMascotas());
    }

    private ObservableList<Cliente> getListaClientes() {
        listadoClientes.addAll(mfm.getListaClientes());
        return listadoClientes;
    }

    private ObservableList<Mascota> getListaMascotas() {
        listadoMascotas.addAll(mfm.getListaMascotas());
        return listadoMascotas;
    }

    public void init(Stage stage, LoginController loginController, Veterinario veterinarioLogin) {
        this.stage = stage;
        this.loginController = loginController;
        this.veterinarioLogin = veterinarioLogin;
    }

    public void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    //FUNCIONES PESTANIA CLIENTES ----------------------------------------------------------------

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
            if(clienteSeleccion != null){
                if(datosValidosCliente(nombre,correo,cedula,telefono,direccion)){
                    mfm.actualizarCliente(mfm.getClinica(),nombre,correo,cedula,telefono,direccion);
                    //Actualizo los datos en la interfaz
                    clienteSeleccion.setNombre(nombre);
                    clienteSeleccion.setCorreo(correo);
                    clienteSeleccion.setCedula(cedula);
                    clienteSeleccion.setTelefono(telefono);
                    clienteSeleccion.setDireccion(direccion);
                    //Actualizo la table view
                    tableViewCliente.refresh();
                    mostrarMensaje("Notificacion Veterinaria", "Cliente Actualizado","El cliente " + nombre +
                            " ha sido actualizado", Alert.AlertType.WARNING);
                }else{
                    mostrarMensaje("Notificacion Veterinaria", "Cliente no seleccionado", "No se ha seleccionado " +
                                  "ningun cliente", Alert.AlertType.WARNING);
                }
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
            comboBoxListaClientes.setItems(clientesNuevos);
            comboBoxListaClientesAtencionV.setItems(clientesNuevos);
        }
    }
    /*
    Crea un cliente con los datos simepre y cuando no se repitan
     */
    private void crearCliente(String nombre, String correo, String cedula, String telefono, String direccion) {
        boolean fueCreado;
            try{
                fueCreado = mfm.crearCliente(mfm.getClinica(), nombre, correo, cedula, telefono, direccion);
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
            }else{
                mostrarMensaje("Notificacion Veterinaria","Cliente eliminado", "Ningun cliente" +
                        "ha sido seleccionado", Alert.AlertType.WARNING);
            }
    }

    @FXML
    void mostrarMascotaCliente(ActionEvent event) {
        if(clienteSeleccion != null){
            for (Mascota mascota : listadoMascotas) {
                mostrarMensaje("Notificacion Veterinaria", "Lista mascotas", mascota.getNombre() +","+ clienteSeleccion.getCedula(), Alert.AlertType.INFORMATION);
                //recorrer la lista y sacar los atributos importantes y concatenarlos en un string
            }
        }else{
            tableViewMascota.getItems().clear();
            mostrarMensaje("Notificacion Veterinaria", "Cliente no seleccionado", "No se selcciono " +
                            "ningun cliente", Alert.AlertType.WARNING);
        }
    }


    //FUNCIONES PARA PESTANIA DE MASCOTAS ------------------------------------------------------------

    /*
    Limpia los textFields despues de ser seleccionados
     */
    public void limpiarCamposMascota(){
        txtNombreMascota.clear();
        txtEdadMascota.clear();
        txtRazaMascota.clear();
        comboBoxTipoMascota.getSelectionModel().clearSelection();
        comboBoxSexoMascota.getSelectionModel().clearSelection();
        comboBoxListaClientes.getSelectionModel().clearSelection();
    }

    /*
   Setea los datos seleccionados en la table view para ser mostrados
    */
    public void llenarCamposMascota(Mascota mascotaSeleccion) {
        String edadString = Integer.toString(mascotaSeleccion.getEdad());
        txtNombreMascota.setText(mascotaSeleccion.getNombre());
        txtEdadMascota.setText(edadString);
        txtRazaMascota.setText(mascotaSeleccion.getRaza());
        comboBoxSexoMascota.getSelectionModel().select(mascotaSeleccion.getSexo());
        comboBoxTipoMascota.getSelectionModel().select(mascotaSeleccion.getTipo());
        comboBoxListaClientes.getSelectionModel().select(clienteSeleccion.getCedula());
    }

    /*
    Setea los datos vacios del cliente para crearlo
     */
    @FXML
    void nuevaMascota(ActionEvent event) {
        txtNombreMascota.setText("");
        txtEdadMascota.setText("");
        txtRazaMascota.setText("");
        comboBoxSexoMascota.setValue(null);
        comboBoxTipoMascota.setValue(null);
        comboBoxListaClientes.setValue(null);
        mascotaSeleccion = null;
    }

    /*
    Actualiza los datos de una mascota
     */
    @FXML
    void actualizarMascota(ActionEvent event) throws MascotaNoRegistradaException {
        String nombre = txtNombreMascota.getText();
        int edad = Integer.parseInt(txtEdadMascota.getText());
        String raza = txtRazaMascota.getText();
        String cedulaCliente = comboBoxListaClientes.getSelectionModel().getSelectedItem();

        Cliente cliente = mfm.clinica.obtenerCliente(cedulaCliente);

        TipoMascota tipo = comboBoxTipoMascota.getValue();
        SexoMascota sexo = comboBoxSexoMascota.getValue();
        if(mascotaSeleccion != null){
            if(datosValidosMascota(nombre, String.valueOf(edad),raza,cedulaCliente,sexo,tipo)){
                mfm.actualizarMascota(mfm.getClinica(),nombre,edad,raza,cliente);
                //Actualiza los datos de la interfaz
                mascotaSeleccion.setNombre(nombre);
                mascotaSeleccion.setEdad(edad);
                mascotaSeleccion.setRaza(raza);
                //Actualiza los datos de la tabla de mascotas
                tableViewMascota.refresh();
                mostrarMensaje("Notificacion Veterinaria", "Mascota Actualizada", "La mascota " + nombre +
                                "ha sido actualizado", Alert.AlertType.WARNING);
            }
        }else{
            mostrarMensaje("Notificacion Veterinaria","Mascota no seleccionada", "No se ha seleccionado" +
                            " ningunca mascota", Alert.AlertType.WARNING);
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
        comboBoxListaClientes.setDisable(false);
        String nombre = txtNombreMascota.getText();
        int edad = Integer.parseInt(txtEdadMascota.getText());
        String raza = txtRazaMascota.getText();
        String cedulaDuenioMascota = comboBoxListaClientes.getSelectionModel().getSelectedItem();
        Cliente duenio = mfm.clinica.obtenerCliente(cedulaDuenioMascota);

        if(duenio != null) {

            TipoMascota tipo = comboBoxTipoMascota.getValue();
            SexoMascota sexo = comboBoxSexoMascota.getValue();
            comboBoxListaClientes.getValue();

            if (datosValidosMascota(nombre, String.valueOf(edad), raza, cedulaDuenioMascota, sexo, tipo)) {
                crearMascota(nombre, edad, sexo, raza, tipo, duenio);
                limpiarCamposMascota();
                tableViewCliente.getSelectionModel().clearSelection();
            }
        }else{
            mostrarMensaje("Error dueño", "Error dueño", "La cédula del cliente no existe", Alert.AlertType.ERROR);
        }
    }

    /*
    Crea una mascota con todos los datos siempre y cuando la cedula no se repita
     */
    private void crearMascota(String nombre,int edad,SexoMascota sexo,String raza,TipoMascota tipo, Cliente duenio) {
        boolean fueCreado;
        try {
            fueCreado = mfm.crearMascota(mfm.getClinica(),nombre,edad,sexo,raza,tipo,duenio);
            if(fueCreado){
            //Añade las mascota a la tabla de mascotas
            tableViewMascota.getItems().clear();
            tableViewMascota.setItems(getListaMascotas());
            mostrarMensaje("Notificacion Mascota","Mascota creada", "La mascota " + nombre +
                            " ha sido creado", Alert.AlertType.WARNING);
            }
        }catch (MascotaYaExistenteException e){
            mostrarMensaje("Notificacion Mascota","Mascota no creada", "La mascota " + nombre +
                            " Ya exsite", Alert.AlertType.WARNING);
        }

    }

    //comboBoxTipoMascota.setValue( capturar tipo mascota );

    /*
   Elemina a una mascota selccionado en la table view
    */
    @FXML
    void eliminarMascota(ActionEvent event) throws MascotaNoRegistradaException {
        String cedulaMascota = comboBoxListaClientes.getSelectionModel().getSelectedItem();
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
        listadoMascotas.remove(mascotaSeleccion);
    }


    //FUNCIONES PARA PESTANIA DE ATENCION VETERINARIA ------------------------------------------------

    @FXML
    void generarCitaAtencion(ActionEvent event) {

    }

    //FUNCIONES PARA PESTANIA LISTA DE ATENCIONES -----------------------------------------------------

    @FXML
    void atenderCitaAtencion(ActionEvent event) {

    }

    @FXML
    void cancelarCitaAtencion(ActionEvent event) {

    }

    //FUNCIONES PARA PESTANIA LISTA DE FACTURAS ----------------------------------------------------------

    //FUNCIONES PARA PESTANIA HISTORIAL CLINICO ------------------------------------------------------------

    @FXML
    void generarHistorial(ActionEvent event) {

    }

    //FUNCIONES PARA PESTANIA FILTRAR CITAS -----------------------------------------------------------

    @FXML
    void generarFiltrar(ActionEvent event) {

    }


    @FXML
    void reiniciarFiltrar(ActionEvent event) {

    }
}
