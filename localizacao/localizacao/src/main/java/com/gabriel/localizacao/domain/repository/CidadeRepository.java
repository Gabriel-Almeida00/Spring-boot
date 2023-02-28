package com.gabriel.localizacao.domain.repository;

import com.gabriel.localizacao.domain.entity.Cidade;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByNome(String nome);

    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLike(String nome, Sort sort);

    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    Page<Cidade> findByNomeLike(String nome, Pageable pageable);


    List<Cidade> findByNomeStartingWith(String nome);

    List<Cidade> findByNomeEndingWith(String nome);

    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByHabitantes(Long habitantes);

    List<Cidade> findByHabitantesLessThan(Long habitantes);

    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    List<Cidade> findByHabitantesGreaterThanEqual(Long habitantes);

    List<Cidade> findByHabitantesGreaterThanEqualAndNomeLike(Long habitantes, String nome);



}
