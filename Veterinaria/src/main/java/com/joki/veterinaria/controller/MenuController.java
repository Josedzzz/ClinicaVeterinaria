package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
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
                mascotaSeleccion = newSelection;
            }
        });

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

    @FXML
    void actualizarCliente(ActionEvent event) {

    }

    @FXML
    void aniadirCliente(ActionEvent event) {

    }

    @FXML
    void eliminarCliente(ActionEvent event) {

    }

    @FXML
    void mostrarMascotaCliente(ActionEvent event) {

    }

    @FXML
    void nuevoCliente(ActionEvent event) {

    }

    //FUNCIONES PARA PESTANIA DE MASCOTAS ------------------------------------------------------------

    @FXML
    void actualizarMascota(ActionEvent event) {

    }

    @FXML
    void aniadirMascota(ActionEvent event) {

    }

    @FXML
    void eliminarMascota(ActionEvent event) {

    }

    @FXML
    void nuevaMascota(ActionEvent event) {

    }

    //FUNCIONES PARA PESTANIA DE ATENCION VETERINARIA ------------------------------------------------

    @FXML
    void generarCitaAtencion(ActionEvent event) {
        String cedulaCliente = txtCedulaClienteAtencion.getText();
        String nombreMascota = txtNombreMascotaAtencion.getText();
        String codigoVeterinario = txtCodigoVeterinarioAtencion.getText();
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
            txtCodigoVeterinarioAtencion.setText("");
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
