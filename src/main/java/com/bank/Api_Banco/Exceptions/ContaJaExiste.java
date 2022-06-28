package com.bank.Api_Banco.Exceptions;

public class ContaJaExiste extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ContaJaExiste(String msg) {
        super(msg);
    }
    public ContaJaExiste() {}

}
