package com.joki.veterinaria.exceptions;

public class ClienteNoRegistradoException extends Exception {
    public ClienteNoRegistradoException(String mensaje){
        super(mensaje);
    }
}
