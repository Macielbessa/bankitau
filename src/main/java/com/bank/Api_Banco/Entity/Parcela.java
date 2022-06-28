package com.bank.Api_Banco.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Parcela implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int QuantidadeDeParcelas;

    @Column(name = "ultima_parcela")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date DataDeVencimento;
    private double valor;

    public Parcela() {}

    public Parcela(int quantidadeDeParcelas, Date dataDeVencimento, double valordaParcela) {
        QuantidadeDeParcelas = quantidadeDeParcelas;
        valor = valordaParcela;
    }
    public Parcela(int quantidadeDeParcelas, double valordaParcela) {
        QuantidadeDeParcelas = quantidadeDeParcelas;
        valor = valordaParcela;
    }

    public int getQuantidadeDeParcelas() {
        return QuantidadeDeParcelas;
    }

    public void setQuantidadeDeParcelas(int quantidadeDeParcelas) {
        QuantidadeDeParcelas = quantidadeDeParcelas;
    }

    public Date getDataDeVencimento() {
        return DataDeVencimento;
    }

    public void setDataDeVencimento(Date dataDeVencimento) {
        DataDeVencimento = dataDeVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valorr) {
        valor = valorr/this.QuantidadeDeParcelas;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Parcela{" +
                "id=" + id +
                ", QuantidadeDeParcelas=" + QuantidadeDeParcelas +
                ", DataDeVencimento=" + DataDeVencimento +
                ", valor=" + valor +
                '}';
    }
}
