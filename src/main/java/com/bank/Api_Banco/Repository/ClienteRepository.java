package com.bank.Api_Banco.Repository;

import com.bank.Api_Banco.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    List<Cliente> findByOrderByNomeAsc();
    Optional<Cliente> findByEndereco(String cpf);
    Optional<Cliente> findByCpf(String cpf);
    Optional<Cliente> findByNome(String nome);
}
