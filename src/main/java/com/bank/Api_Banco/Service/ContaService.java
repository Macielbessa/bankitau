package com.bank.Api_Banco.Service;

import com.bank.Api_Banco.Dtos.*;
import com.bank.Api_Banco.Entity.Conta;
import com.bank.Api_Banco.Exceptions.ContaInvalida;
import com.bank.Api_Banco.Exceptions.ContaJaExiste;
import com.bank.Api_Banco.Exceptions.ContaNaoExiste;
import com.bank.Api_Banco.Exceptions.SaldoInsuficiente;
import com.bank.Api_Banco.Repository.ContaRepository;
import com.bank.Api_Banco.Repository.ParcelaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaBD;

    @Autowired
    private ParcelaRepository parcelaBD;

    public ContaService() {
    }

    @PostConstruct
    public void initContas() {
        try {
            if (contaBD.count() == 5) {
                System.out.println("Já existe 5 contas");
            } else {
                ObjectMapper mapper = new ObjectMapper();
                TypeReference<List<Conta>> tipoDeDados = new TypeReference<List<Conta>>() {
                };
                InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/contas.json");
                List<Conta> conta = mapper.readValue(inputStream, tipoDeDados);
                System.out.println("Contas salvas no Banco De Dados");
                LocalTime now = LocalTime.now();
                System.out.println(now);
                contaBD.saveAll(conta);

            }

        } catch (IOException e) {
            System.out.println("não foi possivel salvar " + e.getMessage());
        }

    }

    public CriarConta criarConta(Conta conta) {

        boolean existiConta = existeConta(conta.getCliente().getCpf());
        if (existiConta == true) {
            throw new ContaJaExiste();
        }
        contaBD.save(conta);
        return new CriarConta(conta);

    }

    public Conta getConta(String numeroConta) {
        Optional<Conta> optConta = contaBD.findByConta(numeroConta);
        if (optConta.isEmpty()) {
            throw new ContaNaoExiste();
        }
        return optConta.get();
    }

    public boolean existeConta(String cpf) {
        boolean existe = false;
        for (Conta conta : this.contaBD.findAll()) {

            if (conta.getCliente().getCpf().equals(cpf)) {

                existe = true;
            } else {
                existe = false;
            }
        }
        return existe;

    }

    public DepositoDTO depositar(Deposito conta) {
        Optional<Conta> conta01 = contaBD.findByConta(conta.getConta());
        Conta conta02 = conta01.get();

        if (conta.getAgencia().equals(conta02.getAgencia()) && conta.getConta().equals(conta02.getConta())) {
            conta02.creditar(conta.getDeposito());

        } else {
            throw new ContaInvalida();
        }

        contaBD.save(conta02);
        return new DepositoDTO(conta02);

    }

    @GetMapping("/buscarConta")
    public Conta buscarConta(String id) {
        Optional<Conta> optConta = contaBD.findByConta(id);
        if (optConta.isEmpty()) {
            throw new ContaNaoExiste();

        }
        return optConta.get();

    }

    public Conta validarConta(Optional<String> id) {
        if (id.isEmpty()) {
            throw new ContaNaoExiste();
        }
        Optional<Conta> conta = contaBD.findByConta(id.get());
        if (conta.isEmpty()) {
            throw new ContaNaoExiste();
        }
        return conta.get();

    }

    public List<ListaDTO> listaDeContas() {
        List<Conta> lista = contaBD.findAll();
        List<ListaDTO> listaDto = lista.stream().map(x -> new ListaDTO(x)).collect(Collectors.toList());
        return listaDto;
    }

    public List<Conta> listaDeContaDeSaldoMenor(double valor) {
        return contaBD.findAll().stream().filter(x -> x.getSaldo() < valor).collect(Collectors.toList());

    }

    public List<ListaDTO> HankindDeSaldos() {
        List<Conta> lista = contaBD.findByOrderBySaldoDesc();

        List<ListaDTO> listaDto = lista.stream().map(x -> new ListaDTO(x)).collect(Collectors.toList());
        return listaDto;
    }

    public TransferDTO tranferir(Transfer transferencia) {

        Optional<Conta> ContaOrigem = contaBD.findByConta(transferencia.getContaOrigem());
        Optional<Conta> ContaDestino = contaBD.findByConta(transferencia.getContaDestino());

        if (ContaOrigem.isPresent() && ContaDestino.isPresent()) {
            if (ContaOrigem.get().getSenha().equals(transferencia.getSenha())) {
                if (ContaOrigem.get().getSaldo() >= transferencia.getValor()) {

                    double valorDeTranferencia = transferencia.getValor();
                    ContaOrigem.get().debitar(transferencia.getValor());
                    ContaDestino.get().creditar(valorDeTranferencia);

                    contaBD.save(ContaOrigem.get());
                    contaBD.save(ContaDestino.get());

                } else {
                    throw new SaldoInsuficiente();
                }

            } else {
                throw new ContaInvalida();
            }

        } else {
            throw new ContaNaoExiste();

        }
        return new TransferDTO(transferencia);

    }

    public Conta getOne(String contaId) {
        Optional<Conta> conta = contaBD.findByConta(contaId);
        if (conta != null) {
            return conta.get();
        }
        throw new ContaInvalida("Conta invalida");

    }
}
