package com.joki.veterinaria.exceptions;

public class ClienteYaExistenteException extends Exception{
    public ClienteYaExistenteException(String mensaje) {
        super(mensaje);
    }
}
