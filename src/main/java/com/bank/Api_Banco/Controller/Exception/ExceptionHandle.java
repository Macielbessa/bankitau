package com.bank.Api_Banco.Controller.Exception;

import com.bank.Api_Banco.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(ContaInvalida.class)
    public ResponseEntity<StandardError> ContaInvalidaException(ContaInvalida e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Conta Invalida", "Algum dado informado, está incorreto :(", request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(ContaNaoExiste.class)
    public ResponseEntity<StandardError> ContaInexistenteException(ContaNaoExiste e,HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Conta não existe", "Não conseguimos localizar a conta informada", request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(ContaJaExiste.class)
    public ResponseEntity<StandardError> ContaJaExisteException(ContaJaExiste e,HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Conflito", "Impossivel cadastrar novo Usuario, pois essa conta já existi", request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(SaldoInsuficiente.class)
    public ResponseEntity<StandardError> SaldoInsuficienteException(SaldoInsuficiente e,HttpServletRequest request){
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Saldo Insuficiente", "Você não tem saldo suficiente, para executar essa operação :(", request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(LimiteInsuficiente.class)
    public ResponseEntity<StandardError> SaldoInsuficienteException(LimiteInsuficiente e,HttpServletRequest request){
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Você não tem limite suficiente, para executar Empréstimo/cartaoDeCredito :(", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
