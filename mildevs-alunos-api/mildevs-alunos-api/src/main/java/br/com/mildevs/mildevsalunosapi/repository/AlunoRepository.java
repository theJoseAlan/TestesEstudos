package br.com.mildevs.mildevsalunosapi.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import br.com.mildevs.mildevsalunosapi.entity.Aluno;

@Repository
public class AlunoRepository extends CrudRepository<Aluno, Long> {

}
