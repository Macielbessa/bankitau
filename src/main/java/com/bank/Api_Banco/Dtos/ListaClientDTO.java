package com.bank.Api_Banco.Dtos;

import com.bank.Api_Banco.Entity.Cliente;

public class ListaClientDTO {
    private String conta;
    private String nome;
    private String telefone;
    private String cpf ;
    private String cidade;




    public ListaClientDTO(Cliente cliente) {
        super();
        this.conta = cliente.getConta().getConta();

        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.cidade = cliente.getEndereco().getCidade();
    }

    public ListaClientDTO() {}


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
}
