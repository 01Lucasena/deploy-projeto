package com.example.projeto.exception;

public class NumeroCamisaJaExistenteException extends RuntimeException {

    public NumeroCamisaJaExistenteException(String numeroCamisa) {
        super("Número de camisa já existente: " + numeroCamisa);
    }

}
