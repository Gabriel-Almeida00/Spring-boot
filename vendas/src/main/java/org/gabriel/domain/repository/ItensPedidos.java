package org.gabriel.domain.repository;

import org.gabriel.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensPedidos extends JpaRepository<ItemPedido, Integer> {
}
