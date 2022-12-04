package br.com.mildevs.dao;

import br.com.mildevs.entity.Aluno;
import br.com.mildevs.entity.Professor;
import br.com.mildevs.entity.Sala;
import br.com.mildevs.entity.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
    private EntityManager manager;

    public TurmaDAO(){
        this.manager = Persistence.createEntityManagerFactory("escola").createEntityManager();
    }

    //Criação
    public Turma criaTurma(Sala sala){ //Cria a turma e uma sala, de uma lapada só
        Turma turma = new Turma();
        turma.setSala(sala);
        sala.setTurma(turma);

        this.manager.getTransaction().begin();
        this.manager.persist(turma);
        this.manager.getTransaction().commit();

        return turma;
    }

    public boolean adcionaProfessor(Professor professor, int codTurma){
        Turma turma = this.manager.find(Turma.class, codTurma);

        if(turma==null){
            return false;
        }

        if(turma.getProfessor()!=null){//se já existir um professor
            return false; //assim o método não executa denovo
        }

        turma.setProfessor(professor);
        this.manager.getTransaction().begin();
        this.manager.merge(turma);
        this.manager.getTransaction().commit();
        return true;
    }

    public boolean adcionaAluno(Aluno aluno, int codTurma){
        Turma turma = this.manager.find(Turma.class, codTurma);

        if(turma==null){
            return false;
        }
        if (turma.getProfessor()==null){
            return false;
        }

        List<Aluno> alunosTurma = turma.getAlunos();

        if (alunosTurma==null){
            alunosTurma = new ArrayList<Aluno>();
        }

        alunosTurma.add(aluno);
        turma.setAlunos(alunosTurma);

        List<Turma> turmasAluno = aluno.getTurmas();

        if(turmasAluno==null){
            turmasAluno = new ArrayList<Turma>();
        }
        turmasAluno.add(turma);
        aluno.setTurmas(turmasAluno);

        this.manager.getTransaction().begin();
        this.manager.merge(turma);
        this.manager.getTransaction().commit();

        return true;
    }

    public void listaDeChamada(int codTurma){
        Turma turma = this.manager.find(Turma.class, codTurma);

        if (turma==null){
            return;
        }

        for (Aluno aluno : turma.getAlunos()){
            System.out.println(aluno);
        }
    }

    public List<Turma> listarTurmas(){
        Query query = this.manager.createQuery("SELECT t FROM Turma as t");
        return query.getResultList();
    }

    public boolean removeTurma(int codTurma){
        Turma turma = this.manager.find(Turma.class, codTurma);

        if (turma==null){
            return false;
        }

        this.manager.getTransaction().begin();
        this.manager.remove(turma);
        this.manager.getTransaction().commit();

        return true;
    }
}
