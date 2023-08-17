package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import com.joki.veterinaria.model.Veterinario;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

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
}
