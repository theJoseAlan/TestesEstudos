package br.com.mildevs.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Turma {

    @Id
    @Column(name = "cod_turma")
    private int codTurma;

    @ManyToOne //Muitas turmas para um professor
    @JoinColumn(name = "cod_funcionario_fk", referencedColumnName = "cod_funcionario")//Indica a relação, tipo o que une uma entidade a outra
    private Professor professor;

    @ManyToMany(mappedBy = "turmas")
    private List<Aluno> alunos;


    @OneToOne(mappedBy = "turma")
    private Sala sala;
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
