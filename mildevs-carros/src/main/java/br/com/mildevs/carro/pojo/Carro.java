package br.com.mildevs.carro.pojo;

public class Carro {
	private String placa;
	private String cor;
	private String marca;
	private String modelo;
	
	public Carro(String placa, String cor, String marca, String modelo) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Carro() {
		// TODO Auto-generated constructor stub
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", cor=" + cor + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
	
	
	
}
