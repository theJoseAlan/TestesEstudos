package br.com.mildevs.mildevsalunosapi.repository;

import br.com.mildevs.mildevsalunosapi.entity.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {



}
