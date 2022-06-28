package com.bank.Api_Banco.Dtos;

public class Deposito {
    private String conta;
    private String agencia;
    private double deposito;
    public String getConta() {
        return conta;
    }
    public void setConta(String conta) {
        this.conta = conta;
    }
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public double getDeposito() {
        return deposito;
    }
    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

}
