package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import com.joki.veterinaria.model.*;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
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
    private Veterinario veterinarioLogin;
    private LoginController loginController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Datos de la tableViewCliente
        this.columnNombreCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
        this.columnCorreoCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCorreo()));
        this.columnCedulaCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCedula()));
        this.columnTelefonoCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getTelefono()));
        this.columnDireccionCliente.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getDireccion()));

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
