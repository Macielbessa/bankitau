package com.bank.Api_Banco.Service;

import com.bank.Api_Banco.Dtos.ListaClientDTO;
import com.bank.Api_Banco.Entity.Cliente;
import com.bank.Api_Banco.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteBD;

    public List<ListaClientDTO> ListaDeClienteEmOrdemAlfabetica(){
        List<Cliente> lista = clienteBD.findByOrderByNomeAsc();
        List<ListaClientDTO> listaDto = lista.stream().map(x -> new ListaClientDTO(x)).collect(Collectors.toList());
        return listaDto;
    }

}
