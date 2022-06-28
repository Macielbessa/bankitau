package com.bank.Api_Banco.Dtos;

import com.bank.Api_Banco.Entity.Conta;

public class DepositoDTO {
    private String agencia;
    private String conta;
    private Double saldo;


    public DepositoDTO() {}

    public DepositoDTO(Conta conta) {
        super();
        this.agencia = conta.getAgencia();
        this.conta = conta.getConta();
        this.saldo = conta.getSaldo();

    }

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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
