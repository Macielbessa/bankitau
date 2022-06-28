package com.bank.Api_Banco.Dtos;

public class TransferDTO {
    private String contaOrigem;
    private String contaDestino;
    private double valorDestinado;

    public TransferDTO() {}


    public TransferDTO(Transfer conta) {
        super();
        this.contaOrigem = conta.getContaOrigem();
        //this.cpfOrigem = conta.getCliente().getCpf();
        this.contaDestino = conta.getContaDestino();
        //this.cpfDestinatario = conta.getCliente().getCpf();
        this.valorDestinado = conta.getValor();

    }

    public String getContaOrigem() {
        return contaOrigem;
    }
    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }
    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public double getValorDestinado() {
        return valorDestinado;
    }

    public void setValorDestinado(double valorDestinado) {
        this.valorDestinado = valorDestinado;
    }

}
