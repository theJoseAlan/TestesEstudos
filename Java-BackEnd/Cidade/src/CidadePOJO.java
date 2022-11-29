public class CidadePOJO {
    private int ddd;
    private String nome;

    private int nro_habitantes;
    private double renda_per_capita;
    private boolean capital;
    private String estado;
    private String nome_prefeito;

    public CidadePOJO(int ddd, String nome, int nro_habitantes, double renda_per_capita, boolean capital, String estado, String nome_prefeito) {
        this.ddd = ddd;
        this.nome = nome;
        this.nro_habitantes = nro_habitantes;
        this.renda_per_capita = renda_per_capita;
        this.capital = capital;
        this.estado = estado;
        this.nome_prefeito = nome_prefeito;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNro_habitantes() {
        return nro_habitantes;
    }

    public void setNro_habitantes(int nro_habitantes) {
        this.nro_habitantes = nro_habitantes;
    }

    public double getRenda_per_capita() {
        return renda_per_capita;
    }

    public void setRenda_per_capita(double renda_per_capita) {
        this.renda_per_capita = renda_per_capita;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome_prefeito() {
        return nome_prefeito;
    }

    public void setNome_prefeito(String nome_prefeito) {
        this.nome_prefeito = nome_prefeito;
    }
}
