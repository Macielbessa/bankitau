package com.bank.Api_Banco.Controller;

import com.bank.Api_Banco.Dtos.ListaClientDTO;
import com.bank.Api_Banco.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClientController {
    @Autowired
    private ClienteService clientServico;


    @GetMapping("/listaAlfabetica")
    public ResponseEntity<List<ListaClientDTO>> listaEmOrdemAlfabetica(){
        try {
            return new ResponseEntity<List<ListaClientDTO>>(clientServico.ListaDeClienteEmOrdemAlfabetica(), HttpStatus.OK);
        }
        catch(HttpServerErrorException.BadGateway e) {
            return new ResponseEntity<List<ListaClientDTO>>(HttpStatus.BAD_GATEWAY);
        }
    }

}
