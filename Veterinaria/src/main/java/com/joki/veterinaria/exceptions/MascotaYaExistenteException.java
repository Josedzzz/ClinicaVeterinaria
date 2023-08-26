package com.joki.veterinaria.exceptions;

public class MascotaYaExistenteException extends Exception{
    public MascotaYaExistenteException(String mensaje) {
        super(mensaje);
    }
}
