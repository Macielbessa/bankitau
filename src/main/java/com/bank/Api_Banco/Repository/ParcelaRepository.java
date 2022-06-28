package com.bank.Api_Banco.Repository;

import com.bank.Api_Banco.Entity.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Integer> {
}
