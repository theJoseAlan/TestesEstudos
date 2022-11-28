public class Piloto {
    private int matricula;
    private String nome;
    private int numAeronave;
    private double salario;
    private int horasVoo;

    public Piloto(int matricula, String nome, int numAeronave, double salario, int horasVoo) {
        super();
        this.matricula = matricula;
        this.nome = nome;
        this.numAeronave = numAeronave;
        this.salario = salario;
        this.horasVoo = horasVoo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumAeronave() {
        return numAeronave;
    }

    public void setNumAeronave(int numAeronave) {
        this.numAeronave = numAeronave;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getHorasVoo() {
        return horasVoo;
    }

    public void setHorasVoo(int horasVoo) {
        this.horasVoo = horasVoo;
    }
}
