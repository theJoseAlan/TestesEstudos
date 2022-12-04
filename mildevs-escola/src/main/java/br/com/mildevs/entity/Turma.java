package br.com.mildevs.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera o valor automaticamente (Serial)
    @Column(name = "cod_turma")
    private int codTurma;

    @ManyToOne //Muitas turmas para um professor
    @JoinColumn(name = "cod_funcionario_fk", referencedColumnName = "cod_funcionario")//Indica a relação, tipo o que une uma entidade a outra
    private Professor professor;

    @ManyToMany(mappedBy = "turmas", cascade = CascadeType.ALL)
    private List<Aluno> alunos;


    @OneToOne(mappedBy = "turma", cascade = CascadeType.ALL)
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Turma [codTurma=" + codTurma + ", getProfessor()=" + getProfessor() + ", getAlunos()=" + getAlunos()
                + ", getSala()=" + getSala() + "]\n";
    }
}
