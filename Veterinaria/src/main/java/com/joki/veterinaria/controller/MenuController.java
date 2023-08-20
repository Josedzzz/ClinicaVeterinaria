package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import com.joki.veterinaria.model.*;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

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
        this.columnFechaAtencion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getFechaAtencion().toString()));
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

    //FUNCIONES PESTANIA CLIENTES ----------------------------------------------------------------
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
