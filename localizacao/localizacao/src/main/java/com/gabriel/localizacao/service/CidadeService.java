package com.gabriel.localizacao.service;

import com.gabriel.localizacao.domain.entity.Cidade;
import com.gabriel.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public void listarCidadesPorHabitantes(){
        cidadeRepository.findByHabitantesGreaterThanEqualAndNomeLike(1000001L,"BR%" )
                .forEach(System.out::println);
    }

    public void listarCidadePorNome(){
        Pageable pageable  = PageRequest.of(0, 2);
        cidadeRepository.findByNomeLike("%%%%", pageable )
                .forEach(System.out::println);
    }

    public void listarCidadePorHabitantes(){
        cidadeRepository.findByHabitantes(10000000L).forEach(System.out::println);
    }

    @Transactional
    public void salvarcidade(){
        var cidade = new Cidade(1L,"são paulo", 12396372L);
        cidadeRepository.save(cidade);
    }

    public void listarCidade(){
        cidadeRepository.findAll().forEach(System.out::println);
    }
}
