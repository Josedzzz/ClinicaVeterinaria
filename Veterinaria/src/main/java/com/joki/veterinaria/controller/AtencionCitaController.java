package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import com.joki.veterinaria.model.AtencionVeterinaria;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AtencionCitaController implements Initializable {
    private Application application;
    private Stage stage;
    private MenuController menuController;
    private AtencionVeterinaria atencionVeterinariaSeleccionada;
    ModelFactoryController mfm = ModelFactoryController.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setAplicacion(Application application) {
        this.application = application;
    }

    public void init(Stage stage, MenuController menuController, AtencionVeterinaria atencionVeterinariaSeleccionada) {
        this.stage = stage;
        this.menuController = menuController;
        this.atencionVeterinariaSeleccionada = atencionVeterinariaSeleccionada;
    }

}
