package org.gabriel.domain.repositorio;

import org.gabriel.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Clientes extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNomeContains(String nome);

    boolean existsByNome(String nome);

}