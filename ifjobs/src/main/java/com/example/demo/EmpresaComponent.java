package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class EmpresaComponent {

	@Autowired
	private EmpresaRepository repository;

	@Autowired
	private VagaRepository repositoryVaga;
	
	@PostConstruct
	private void testes() {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Você deseja fazer cadastro (1) ou uma consulta (2)? ");
		int a = sc.nextInt();
		System.out.println(" ");
		
		if(a == 1) {
		
			System.out.println("Cadastrar empresa: ");
			System.out.println(" ");
			System.out.print("Nome: ");
			sc.nextLine();
			String nome_emp = sc.nextLine();
			System.out.print("Descrição: ");
			String desc_emp = sc.nextLine();
			System.out.print("Cidade: ");
			String cidade_emp = sc.nextLine();
			System.out.print("Endereço: (Rua, Bairro, Número) ");
			String endereco_emp = sc.nextLine();
			System.out.print("Data de fundação: (dia mes ano) ");
			int dia_emp = sc.nextInt();
			int mes_emp = sc.nextInt();
			int ano_emp = sc.nextInt();
			LocalDate data_emp = LocalDate.of(ano_emp, mes_emp, dia_emp);
	
			Empresa e = new Empresa();
			e.setNome(nome_emp);
			e.setDescricao(desc_emp);
			e.setCidade(cidade_emp);
			e.setEndereco(endereco_emp);
			e.setDataFundacao(data_emp);
			
			System.out.println(" ");
			System.out.print("Quantas vagas você deseja cadastrar? ");
			int i = sc.nextInt();
			
			for(int j=1; j<=i; j++) {
				
				System.out.println("");
				System.out.println("Cadastrar vaga " + j + ": ");
				System.out.println(" ");
				System.out.print("Título: ");
				sc.nextLine();
				String titulo_vaga = sc.nextLine();
				System.out.print("Descrição: ");
				String desc_vaga = sc.nextLine();
				System.out.print("Curso: (1 para Informática, 2 para Eventos, 3 para Plásticos, 4 para Mecânica) ");
				int curso_vaga = sc.nextInt();
				
				System.out.print("Salário: ");
				Double salario_vaga = sc.nextDouble();
				
				Vaga v = new Vaga();
				v.setTitulo(titulo_vaga);
				v.setDescricao(desc_vaga);
				v.setSalario(salario_vaga);
				LocalDateTime data_vaga = LocalDateTime.now();
				v.setDataPublicacao(data_vaga);
				
				if(curso_vaga == 1) {
					v.setCurso(Cursos.INFORMATICA);
				} else if(curso_vaga == 2) {
					v.setCurso(Cursos.EVENTOS);
				} else if(curso_vaga == 3) {
					v.setCurso(Cursos.PLASTICOS);
				} else if(curso_vaga == 4) {
					v.setCurso(Cursos.MECANICA);
				} else {
					
				}
				
				v.setEmpresa(e);
				e.getItens().add(v);
				
				System.out.print(" ");
			}
	
			repository.save(e);
		
		} else if(a == 2) {
			
			System.out.print("Pesquisar empresa por nome (1), pesquisar vagas por descrição (2) ou pesquisar vagas por intervalo de data (3) ");
			int b = sc.nextInt();
			
			if(b == 1) {
				
				System.out.println("");
				System.out.print("Informe o nome da empresa: ");
				sc.nextLine();
				String nome_emp = sc.nextLine();
				List r1 = repository.findByNome(nome_emp);
				
				System.out.println("Empresas:");
				System.out.println(r1);
				
			} else if(b == 2) {
				
				System.out.println("");
				System.out.print("Informe a descrição da vaga: ");
				sc.nextLine();
				String desc_vaga = sc.nextLine();
				List r1 = repositoryVaga.findByDescricao(desc_vaga);
				
				System.out.println("Vagas:");
				System.out.println(r1);
				
			} else if(b == 3) {
				
				System.out.println("");
				System.out.print("Informe duas datas para pesquisar vagas publicadas entre elas: (dia mes ano hora minuto) ");
				int dia_emp = sc.nextInt();
				int mes_emp = sc.nextInt();
				int ano_emp = sc.nextInt();
				int hora_emp = sc.nextInt();
				int min_emp = sc.nextInt();
				LocalDateTime data_emp = LocalDateTime.of(ano_emp, mes_emp, dia_emp, hora_emp, min_emp);
				int dia_emp2 = sc.nextInt();
				int mes_emp2 = sc.nextInt();
				int ano_emp2 = sc.nextInt();
				int hora_emp2 = sc.nextInt();
				int min_emp2 = sc.nextInt();
				LocalDateTime data_emp2 = LocalDateTime.of(ano_emp2, mes_emp2, dia_emp2, hora_emp2, min_emp2);
				List r1 = repositoryVaga.findByDataPublicacaoBetween(data_emp, data_emp2);
				
				System.out.println("Vagas:");
				System.out.println(r1);
				
			}
			
		}
		
		sc.close();
	}
}
