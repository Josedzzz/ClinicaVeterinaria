package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    //Declaro variables auxiliares
    private Stage stage;
    private Application application;
    private LoginController loginController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setAplicacion(Application application) {
        this.application = application;
    }

    public void init(Stage stage, LoginController loginController) {
        this.stage = stage;
        this.loginController = loginController;
    }
}
