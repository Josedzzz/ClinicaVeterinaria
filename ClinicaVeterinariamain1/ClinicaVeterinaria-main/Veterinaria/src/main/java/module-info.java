module com.joki.veterinaria {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.joki.veterinaria.controller;
    opens com.joki.veterinaria.controller to javafx.fxml;
    exports com.joki.veterinaria.application;
    opens com.joki.veterinaria.application to javafx.fxml;
}