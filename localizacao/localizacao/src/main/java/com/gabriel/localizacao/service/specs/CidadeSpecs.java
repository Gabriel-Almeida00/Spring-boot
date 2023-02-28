package com.gabriel.localizacao.service.specs;

import com.gabriel.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

import javax.swing.text.html.HTMLDocument;

public abstract class CidadeSpecs {

    public static Specification<Cidade> nomeEqual(String nome){
        return (root, query, cb) -> cb.equal( root.get("nome") , nome );
    }

    public static Specification<Cidade> habitantesGreaterThan(Integer value){
        return (root, query, cb) -> cb.greaterThan( root.get("habitantes") , value );
    }
}
