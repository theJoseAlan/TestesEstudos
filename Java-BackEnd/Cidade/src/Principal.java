import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CidadeDAO cidadeDao = new CidadeDAO();

        System.out.println("=== INSERÇÃO DE CIDADE ===");
        System.out.print("DDD: ");
        int ddd = input.nextInt();
        input.nextLine();
        System.out.print("NOME: ");
        String nome = input.nextLine();
        System.out.print("NÚMERO DE HABITANTES: ");
        int nro_habitantes = input.nextInt();
        System.out.print("RENDA PER CAPITA: ");
        double renda_per_capita = input.nextDouble();
        System.out.print("CAPITAL [TRUE/FALSE]? ");
        boolean capital = input.nextBoolean();
        input.nextLine();
        System.out.print("ESTADO: ");
        String estado = input.nextLine();
        System.out.print("PREFEITO: ");
        String prefeito = input.nextLine();


        Cidade cidadeAserInserida = new Cidade(ddd,nome,nro_habitantes,renda_per_capita,capital,estado,prefeito);
        cidadeDao.insereCidade(cidadeAserInserida);

        input.close();

    }
}