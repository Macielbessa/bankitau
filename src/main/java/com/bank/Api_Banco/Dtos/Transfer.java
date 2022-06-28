package com.bank.Api_Banco.Dtos;

public class Transfer {
    private String contaOrigem;
    private String senha;
    private double valor;
    private String contaDestino;
    private String cpfDestinatario;


    public String getContaOrigem() {
        return contaOrigem;
    }
    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getContaDestino() {
        return contaDestino;
    }
    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }
    public String getCpfDestinatario() {
        return cpfDestinatario;
    }
    public void setCpfDestinatario(String cpfDestinatario) {
        this.cpfDestinatario = cpfDestinatario;
    }

}
