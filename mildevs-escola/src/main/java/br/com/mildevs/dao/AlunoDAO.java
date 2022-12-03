package br.com.mildevs.dao;

import br.com.mildevs.entity.Aluno;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class AlunoDAO {
    private EntityManager manager;

    public AlunoDAO() {
        this.manager = Persistence.createEntityManagerFactory("escola").createEntityManager();
    }
    //Criação
    public boolean criarAluno(Aluno aluno){
        manager.getTransaction().begin();
        manager.persist(aluno);
        manager.getTransaction().commit();

        return true;
    }

    //Consulta
    public Aluno consultaAluno(int matricula){
        return manager.find(Aluno.class, matricula);
    }

    //Listar
    public List<Aluno> listaAlunos(){
        Query query = manager.createQuery("SELECT a FROM Aluno as a");
        return query.getResultList();
    }

    //Remover
    public boolean removeAluno(int matricula){
        Aluno alunoAserRemovido = manager.find(Aluno.class, matricula);

        if(alunoAserRemovido==null){
            return false;
        }
        manager.getTransaction().begin();
        manager.remove(alunoAserRemovido);
        manager.getTransaction().commit();
        return true;
    }
}
