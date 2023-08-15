package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button btnIngresarLogin;

    @FXML
    private TextField txtCodigoLogin;

    @FXML
    private TextField txtNombreLogin;

    private Application application;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void iniciarSesion(ActionEvent event) {

    }
}