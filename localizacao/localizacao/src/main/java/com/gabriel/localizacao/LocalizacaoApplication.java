package com.gabriel.localizacao;

import com.gabriel.localizacao.domain.entity.Cidade;
import com.gabriel.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		listarCidadePorNome();
	}

	void listarCidadePorNome(){
		cidadeRepository.findByNomeContaining("a").forEach(System.out::println);
	}

	void listarCidadePorHabitantes(){
		cidadeRepository.findByHabitantes(10000000L).forEach(System.out::println);
	}

	@Transactional
	void salvarcidade(){
		var cidade = new Cidade(1L,"são paulo", 12396372L);
		cidadeRepository.save(cidade);
	}

	void listarCidade(){
		cidadeRepository.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}


}