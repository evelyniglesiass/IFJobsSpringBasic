package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Integer>{

	List findByDescricao(String descricao);
	List findByDataPublicacaoBetween(LocalDateTime data1, LocalDateTime data2);
	
}
