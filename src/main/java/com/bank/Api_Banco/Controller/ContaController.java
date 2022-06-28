package com.bank.Api_Banco.Controller;

import com.bank.Api_Banco.Dtos.*;
import com.bank.Api_Banco.Entity.Conta;
import com.bank.Api_Banco.Exceptions.ContaInvalida;
import com.bank.Api_Banco.Exceptions.ContaJaExiste;
import com.bank.Api_Banco.Exceptions.ContaNaoExiste;
import com.bank.Api_Banco.Exceptions.SaldoInsuficiente;
import com.bank.Api_Banco.Service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaService contaServico;

    private ModelMapper modelMapper;

    @PostMapping("/criarConta")
    public ResponseEntity<CriarConta> abrirConta(@RequestBody Conta conta) {

        try {
            return new ResponseEntity<CriarConta>(contaServico.criarConta(conta), HttpStatus.CREATED);

        } catch (ContaJaExiste e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (ContaInvalida e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }

    @PutMapping("/deposito")
    public ResponseEntity<DepositoDTO> depositar(@RequestBody Deposito conta) {
        try {

            return new ResponseEntity<DepositoDTO>(contaServico.depositar(conta), HttpStatus.OK);
        } catch (ContaInvalida e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    
    @GetMapping("/buscarConta/{id}")
    public ResponseEntity<Conta> buscarConta(@PathVariable String id) {
        try {
            return new ResponseEntity<Conta>(contaServico.buscarConta(id), HttpStatus.OK);
        } catch (ContaNaoExiste e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ListaDTO>> lista() {
        return new ResponseEntity<List<ListaDTO>>(contaServico.listaDeContas(), HttpStatus.OK);

    }
    @GetMapping("/listacontasmenores/{valor}")
    public ResponseEntity<List<Conta>> listaDeContaComSaldoMenor(@PathVariable double valor){
        try {
            return new ResponseEntity<>(contaServico.listaDeContaDeSaldoMenor(valor),HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
    @GetMapping("hankindDeSaldo")

    public ResponseEntity<List<ListaDTO>> hankingDeSaldo(){
        try {
            return new ResponseEntity<List<ListaDTO>>(contaServico.HankindDeSaldos(),HttpStatus.OK);
        }
        catch(HttpServerErrorException.BadGateway e) {
            return new ResponseEntity<List<ListaDTO>>(HttpStatus.BAD_GATEWAY);
        }
    }

    public Conta toEntity(Transfer tranferencia) {
        return modelMapper.map(tranferencia, Conta.class);
    }
    public Conta toConta(Deposito deposito) {
        return modelMapper.map(deposito, Conta.class);
    }
    public DepositoDTO toContaOur(Conta conta) {
        return modelMapper.map(conta, DepositoDTO.class);
    }

    @PutMapping("/transferencia")
    public ResponseEntity<TransferDTO> tranferencia(@RequestBody Transfer tranferencia){


        try {
            return new ResponseEntity<TransferDTO>(contaServico.tranferir(tranferencia),HttpStatus.OK);
        }
        catch(ContaNaoExiste e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(ContaInvalida e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        catch(SaldoInsuficiente e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
