package br.com.mildevs.entity;

import jakarta.persistence.*;

@Entity
public class Sala {

    @Id
    @Column(name = "nro_sala", nullable = false)
    private int nroSala;

    @Column(nullable = false)
    private double largura;

    @Column(nullable = false)
    private double comprimento;

    @Column(nullable = false)
    private double altura;

    @OneToOne
    @JoinColumn(name = "turma_fk", referencedColumnName = "cod_turma")
    private Turma turma;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public int getNroSala() {
        return nroSala;
    }

    public void setNroSala(int nroSala) {
        this.nroSala = nroSala;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
