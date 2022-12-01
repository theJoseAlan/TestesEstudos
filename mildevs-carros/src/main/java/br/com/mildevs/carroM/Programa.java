package br.com.mildevs.carroM;

import java.util.List;
import java.util.Scanner;

import br.com.mildevs.carro.dao.CarroDao;
import br.com.mildevs.carro.pojo.Carro;

public class Programa {

	public static void main(String[] args) {
		CarroDao carroDao = new CarroDao();
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Digite a placa a ser inserida: ");
		String placa = teclado.nextLine();
		
		Carro carroInserido = new Carro(placa, "ROSA", "SIM", "FIAT");
		carroDao.insereCarro(carroInserido);
		
		List<Carro> carros = carroDao.listaCarros();
		for(Carro carro:carros) {
			System.out.println(carro);
		}
		
		System.out.print("Digite a placa do carro que deseja remover: ");
		String placar = teclado.nextLine();
		carroDao.removeCarro(placar);
		
		System.out.println(carroDao.consultaCarro("ABC-123"));
		
		teclado.close();
		
		
	}

}
