package com.gabriel.localizacao.service;

import com.gabriel.localizacao.domain.entity.Cidade;
import com.gabriel.localizacao.domain.repository.CidadeRepository;
import com.gabriel.localizacao.domain.repository.projections.CidadeProjections;
import com.gabriel.localizacao.service.specs.CidadeSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.gabriel.localizacao.service.specs.CidadeSpecs.*;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public void listarCidadesPorHabitantes() {
        cidadeRepository.findByHabitantesGreaterThanEqualAndNomeLike(1000001L, "BR%")
                .forEach(System.out::println);
    }

    public void listarCidadePorNome() {
        Pageable pageable = PageRequest.of(0, 2);
        cidadeRepository.findByNomeLike("%%%%", pageable)
                .forEach(System.out::println);
    }

    public void listarCidadePorNomeSqlNativo() {
        cidadeRepository
                .findByNomeSqlNativo("São Paulo")
                .stream().map(cidadeProjections -> new Cidade
                        (cidadeProjections.getId(), cidadeProjections.getNome(),null))
                .forEach(System.out::println);
    }

    public void listarCidadePorHabitantes() {
        cidadeRepository.findByHabitantes(10000000L).forEach(System.out::println);
    }

    @Transactional
    public void salvarcidade() {
        var cidade = new Cidade(1L, "são paulo", 12396372L);
        cidadeRepository.save(cidade);
    }

    public void listarCidade() {
        cidadeRepository.findAll().forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade) {
        ExampleMatcher mather = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);

        Example<Cidade> example = Example
                .of(cidade, mather);
        return cidadeRepository.findAll(example);
    }

    public void listarCidadeByNomeSpecs() {
        Specification<Cidade> spec = CidadeSpecs.nomeEqual("São Paulo")
                .and(CidadeSpecs.greaterThan(1000L));
        cidadeRepository.findAll(spec).forEach(System.out::println);
    }

    public void listarCidadesSpecsFiltroDinamico(Cidade filtro) {
        Specification<Cidade> spec = Specification
                .where((root, query, cb) -> cb.conjunction());

        if (filtro.getId() != null) {
            spec = spec.and(idEqual(filtro.getId()));
        }

        if (StringUtils.hasText(filtro.getNome())) {
            spec = spec.and(nomeLike((filtro.getNome())));
        }

        if (filtro.getHabitantes() != null) {
            spec = spec.and(greaterThan(filtro.getHabitantes()));
        }

        cidadeRepository.findAll(spec).forEach(System.out::println);
    }
}
