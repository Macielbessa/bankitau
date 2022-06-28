package com.bank.Api_Banco.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String conta;
    private String Agencia;
    private String senha;
    private double saldo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_cliente")
    private Cliente cliente;

    public Conta() {}

    public String getAgencia() {
        return this.Agencia;
    }

    public void setAgencia(String numeroDaAgencia) {
        this.Agencia = numeroDaAgencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String numero_Da_Conta) {
        conta = numero_Da_Conta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Agencia == null) ? 0 : Agencia.hashCode());
        result = prime * result + ((conta == null) ? 0 : conta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if (Agencia == null) {
            if (other.Agencia != null)
                return false;
        } else if (!Agencia.equals(other.Agencia))
            return false;
        if (conta == null) {
            if (other.conta != null)
                return false;
        } else if (!conta.equals(other.conta))
            return false;
        return true;
    }
    public void debitar(double valor) {
        this.saldo -=valor;
    }
    public void creditar(double valor) {
        this.saldo += valor;
    }
    public boolean isValid() {
        return !this.Agencia.isBlank()&&!this.conta.isBlank()&&!this.cliente.getCpf().isBlank();
    }

    @Override
    public String toString() {
        return "Conta{" +
                "conta='" + conta + '\'' +
                ", Agencia='" + Agencia + '\'' +
                ", senha='" + senha + '\'' +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
    }
}
