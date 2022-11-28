import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExemploJDBC {
    public static void main(String[] args) throws SQLException {
        Scanner teclado = new Scanner(System.in);
        PilotoDAO pilotoDao = new PilotoDAO();

        System.out.println("INSERÇÂO DE PILOTOS");
        System.out.print("Matricula: ");
        int matricula = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("Numero da aeronave: ");
        int numAeronave = teclado.nextInt();
        System.out.print("Salário: ");
        double salario = teclado.nextDouble();
        System.out.print("Horas de voo: ");
        int horasVoo = teclado.nextInt();

        Piloto pilotoASerInserido = new Piloto(matricula, nome, numAeronave, salario, horasVoo);
        pilotoDao.inserePiloto(pilotoASerInserido);

        teclado.close();
    }
}