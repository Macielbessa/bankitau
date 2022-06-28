package com.bank.Api_Banco.Dtos;

import com.bank.Api_Banco.Entity.Conta;

public class SaqueDTO {private String agencia;
    private String conta;
    private double saldo;
    private double valor;


    public SaqueDTO(Conta conta) {
        super();
        this.agencia = conta.getAgencia();
        this.conta = conta.getConta();
        this.saldo = conta.getSaldo();
    }
    public SaqueDTO() {}

    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public String getConta() {
        return conta;
    }
    public void setConta(String conta) {
        this.conta = conta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }



}
