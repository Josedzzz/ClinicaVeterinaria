package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import com.joki.veterinaria.model.Factura;
import com.joki.veterinaria.model.Mascota;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HistorialClinicoController implements Initializable {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    @FXML
    private Button btnRegresarHistorial;

    @FXML
    private TableColumn<Factura, String> columnFechaHistorial;

    @FXML
    private TableColumn<Factura, String> columnObservacionesHistorial;

    @FXML
    private TableColumn<Factura, String> columnVeterinarioHistorial;

    @FXML
    private TableView<Factura> tableViewHistorial;

    @FXML
    private TextField txtEdadHistorial;

    @FXML
    private TextField txtNombreHistorial;

    @FXML
    private TextField txtRazaHistorial;

    @FXML
    private TextField txtSexoHistorial;

    @FXML
    private TextField txtTipoMascotaHistorial;

    //Creo variables auxiliares
    private Application application;
    private Stage stage;
    private Mascota mascotaHistorial;
    private MenuController menuController;
    ObservableList<Factura> listadoMascotaHistorial = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Datos en la tableView del historial
        this.columnVeterinarioHistorial.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getAtencionVeterinaria().getVeterinario().getNombre()));
        this.columnFechaHistorial.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getAtencionVeterinaria().getFechaAtencion()));
        this.columnObservacionesHistorial.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getObservaciones()));
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    private ObservableList<Factura> getHistorialMascota() {
        listadoMascotaHistorial.addAll(mfm.getHistorialMascota(mascotaHistorial));
        return listadoMascotaHistorial;
    }


    public void init(Stage stage, MenuController menuController, Mascota mascotaHistorial) {
        this.mascotaHistorial = mascotaHistorial;
        this.stage = stage;
        this.menuController = menuController;
        //Historial de la mascota que se va a mostrar
        tableViewHistorial.getItems().clear();
        tableViewHistorial.setItems(getHistorialMascota());
        //Lleno los campos sobre la información de la mascota
        txtNombreHistorial.setText(mascotaHistorial.getNombre());
        txtNombreHistorial.setDisable(true);
        txtEdadHistorial.setText(mascotaHistorial.getEdad() + " año(s)");
        txtEdadHistorial.setDisable(true);
        txtSexoHistorial.setText(mascotaHistorial.getSexo().toString());
        txtSexoHistorial.setDisable(true);
        txtRazaHistorial.setText(mascotaHistorial.getRaza());
        txtRazaHistorial.setDisable(true);
        txtTipoMascotaHistorial.setText(mascotaHistorial.getTipo().toString());
        txtTipoMascotaHistorial.setDisable(true);
    }

    //FUNCIONES DE LA VENTANA HISTORIAL CLINICO ------------------------------------------------------

    @FXML
    void regresarHistorial(ActionEvent event) {
        this.stage.close();
        menuController.show();
    }

}
