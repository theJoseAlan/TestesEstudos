package br.com.mildevs.mildevsalunosapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mildevs.mildevsalunosapi.entity.Aluno;
import br.com.mildevs.mildevsalunosapi.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepo;
	
	public Aluno insereAluno(@RequestBody Aluno aluno) {
		
		return this.alunoRepo.save(aluno);
		
	}
	
}
