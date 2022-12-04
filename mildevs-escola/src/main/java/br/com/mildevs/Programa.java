package br.com.mildevs;

import br.com.mildevs.dao.AlunoDAO;
import br.com.mildevs.dao.ProfessorDAO;
import br.com.mildevs.dao.TurmaDAO;
import br.com.mildevs.entity.Aluno;
import br.com.mildevs.entity.Professor;
import br.com.mildevs.entity.Sala;
import br.com.mildevs.entity.Turma;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Programa {
    public static void main(String[] args) {

        ProfessorDAO professorDAO = new ProfessorDAO();
        TurmaDAO turmaDAO = new TurmaDAO();
        AlunoDAO alunoDAO = new AlunoDAO();

        Professor professor = new Professor();
        professor.setDisciplina("Lógica de programação");
        professor.setNivelGraduacao("Doutorado");
        professor.setNome("Alan");
        professor.setSalario(2000);
        professor.setTelefone("1234567890");
        professorDAO.criaProfessor(professor);

        Professor professorDb = professorDAO.concultaProfessor(1);
        System.out.println("Professor encontrado -> ");

        List<Professor> professoresNoDb = professorDAO.listaProfessores();
        for(Professor professorEncontradoNaListagem : professoresNoDb){
            System.out.println(professorEncontradoNaListagem);
        }

        Sala sala = new Sala();
        sala.setAltura(10);
        sala.setComprimento(15);
        sala.setLargura(345);

        Turma turmaCriada = turmaDAO.criaTurma(sala);
        turmaDAO.adcionaProfessor(professorDb,turmaCriada.getCodTurma());

        Aluno aluno = new Aluno();
        aluno.setDataNascimento(LocalDate.now());
        aluno.setNome("José");
        aluno.setSerie("1 série");

        Aluno aluno2 = new Aluno();
        aluno2.setDataNascimento(LocalDate.now());
        aluno2.setNome("Victor");
        aluno2.setSerie("1 série");

        Aluno aluno3 = new Aluno();
        aluno3.setDataNascimento(LocalDate.now());
        aluno3.setNome("Joana");
        aluno3.setSerie("1 série");

        turmaDAO.adcionaAluno(aluno, turmaCriada.getCodTurma());
        turmaDAO.adcionaAluno(aluno2, turmaCriada.getCodTurma());
        turmaDAO.adcionaAluno(aluno3, turmaCriada.getCodTurma());

        List<Turma> turmas = turmaDAO.listarTurmas();

        for (Turma turmaNoDb : turmas){
            System.out.println(turmaNoDb);
        }

    }
}
