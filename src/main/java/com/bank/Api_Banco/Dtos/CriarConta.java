package com.bank.Api_Banco.Dtos;

import com.bank.Api_Banco.Entity.Conta;

public class CriarConta {
    private String conta;
    private String agencia;
    private String senha;
    private double saldoInicial;
    private String cpf;
    private String nome;

    public CriarConta (Conta conta) {
        String camuflagem = conta.getSenha().replace(conta.getSenha(), "*****");
        this.conta = conta.getConta();
        this.agencia = conta.getAgencia();
        this.senha = camuflagem;
        this.saldoInicial = conta.getSaldo();
        this.cpf = conta.getCliente().getCpf();
        this.nome = conta.getCliente().getNome();

    }

    public CriarConta() {
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String numeroDaAgencia) {
        agencia = numeroDaAgencia;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
}
