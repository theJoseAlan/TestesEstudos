package br.com.mildevs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Turma {

    @Id
    private int codTurma;

    @ManyToOne //Muitas turmas para um professor
    @JoinColumn(name = "cod_funcionario_fk", referencedColumnName = "cod_funcionario")//Indica a relação, tipo o que une uma entidade a outra
    private Professor professor;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }
}
