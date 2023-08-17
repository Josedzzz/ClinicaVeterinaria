package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import com.joki.veterinaria.model.Veterinario;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import java.net.URL;
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
    private TableColumn<?, ?> columnCedulaCliente;

    @FXML
    private TableColumn<?, ?> columnCorreoCliente;

    @FXML
    private TableColumn<?, ?> columnDireccionCliente;

    @FXML
    private TableColumn<?, ?> columnNombreCliente;

    @FXML
    private TableColumn<?, ?> columnTelefonoCliente;

    @FXML
    private TableView<?> tableViewCliente;

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
    private TableColumn<?, ?> columnCedulaMascota;

    @FXML
    private TableColumn<?, ?> columnEdadMascota;

    @FXML
    private TableColumn<?, ?> columnNombreMascota;

    @FXML
    private TableColumn<?, ?> columnRazaMascota;

    @FXML
    private TableColumn<?, ?> columnSexoMascota;

    @FXML
    private TableColumn<?, ?> columnTipoMascota;

    @FXML
    private ComboBox<?> comboBoxSexoMascota;

    @FXML
    private ComboBox<?> comboBoxTipoMascota;

    @FXML
    private TableView<?> tableViewMascota;

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
    private TableColumn<?, ?> columnClienteAtencion;

    @FXML
    private TableColumn<?, ?> columnEstadoAtencion;

    @FXML
    private TableColumn<?, ?> columnFechaAtencion;

    @FXML
    private TableColumn<?, ?> columnMascotaAtencion;

    @FXML
    private TableColumn<?, ?> columnVeterinarioAtencion;

    @FXML
    private TableView<?> tableViewAtenciones;

    //PESTANIA LISTA FACTURAS -------------------------------------------------------------------------

    @FXML
    private TableColumn<?, ?> columnClienteFactura;

    @FXML
    private TableColumn<?, ?> columnCostoFactura;

    @FXML
    private TableColumn<?, ?> columnFechaFactura;

    @FXML
    private TableColumn<?, ?> columnMascotaFactura;

    @FXML
    private TableColumn<?, ?> columnObservacionesFactura;

    @FXML
    private TableColumn<?, ?> columnVeterinarioFactura;

    @FXML
    private TableView<?> tableViewFacturas;

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
    private TableColumn<?, ?> columnClienteFiltrar;

    @FXML
    private TableColumn<?, ?> columnEstadoAtencionFiltrar;

    @FXML
    private TableColumn<?, ?> columnFechaFiltrar;

    @FXML
    private TableColumn<?, ?> columnVeterinarioFiltrar;

    @FXML
    private TableColumn<?, ?> columnMascotaFiltrar;

    @FXML
    private DatePicker datePickerFinalFiltrar;

    @FXML
    private DatePicker datePickerIncialFiltrar;

    @FXML
    private TableView<?> tableViewFiltrar;

    //Declaro variables auxiliares
    private Stage stage;
    private Application application;
    private Veterinario veterinarioLogin;
    private LoginController loginController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setAplicacion(Application application) {
        this.application = application;
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
