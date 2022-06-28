package com.bank.Api_Banco.Repository;

import com.bank.Api_Banco.Entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, String> {
    Optional<Conta> findByConta(String Numero_Da_Conta);
    List<Conta> findByOrderBySaldoDesc();
}
