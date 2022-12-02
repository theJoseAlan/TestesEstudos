package br.com.mildevs;

import br.com.mildevs.entity.Sala;
import br.com.mildevs.entity.Aluno;
import br.com.mildevs.entity.Professor;
import br.com.mildevs.entity.Turma;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("escola");

        EntityManager manager = entityManagerFactory.createEntityManager();

        Professor professor = new Professor();
        professor.setCodFuncionario(1);
        professor.setDisciplina("Lógica de programação");
        professor.setNivelGraduacao("Doutorado");
        professor.setNome("Alan");
        professor.setSalario(2000);
        professor.setTelefone("1234567890");


        Turma turma = new Turma();
        turma.setCodTurma(1);

        List<Turma> turmasDoAlan = new ArrayList<>();
        turma.setProfessor(professor);
        turmasDoAlan.add(turma);
        professor.setTurmas(turmasDoAlan);

        manager.getTransaction().begin();
        manager.persist(professor);
        manager.getTransaction().commit();

        manager.close();
        entityManagerFactory.close();

    }
}
