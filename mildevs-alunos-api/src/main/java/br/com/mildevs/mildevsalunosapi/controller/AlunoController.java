package br.com.mildevs.mildevsalunosapi.controller;

import br.com.mildevs.mildevsalunosapi.entity.Aluno;
import br.com.mildevs.mildevsalunosapi.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.awt.*;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepo;

    @PostMapping
    public Aluno insereAluno(@RequestBody Aluno aluno){
        return this.alunoRepo.save(aluno);
    }

    @GetMapping(path = "/{matricula}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Aluno> buscAluno(@PathVariable Long matricula){
        return this.alunoRepo.findById(matricula);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Aluno> buscaAlunos(){
        return (List<Aluno>) this.alunoRepo.findAll();
    }

}
