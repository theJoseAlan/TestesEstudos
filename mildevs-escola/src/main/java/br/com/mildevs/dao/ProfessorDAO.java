package br.com.mildevs.dao;

import br.com.mildevs.entity.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ProfessorDAO {
    private EntityManager manager;

    public ProfessorDAO() {
        this.manager = Persistence.createEntityManagerFactory("escola").createEntityManager();
    }

    //Criação
    public boolean criaProfessor(Professor professor) {

        this.manager.getTransaction().begin();
        this.manager.persist(professor);
        this.manager.getTransaction().commit();

        return true;
    }
    //Consulta
    public Professor consultaProfessor(int codFuncionario){
        return this.manager.find(Professor.class, codFuncionario);
    }

    //Listar
    public List<Professor> listaProfessores(){
        Query query = manager.createQuery("SELECT p FROM Professor as p");
        return query.getResultList();
    }

    //Remover
    public boolean removeProfessor(int codFuncionario){
        Professor professor = this.manager.find(Professor.class, codFuncionario);

        if(professor==null){
            return false;
        }

        this.manager.getTransaction().begin();
        this.manager.remove(professor);
        this.manager.getTransaction().commit();

        return true;
    }
}
