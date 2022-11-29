import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CidadeDAO cidadeDao = new CidadeDAO();
        System.out.print("1 - ADD cidade\n2 - Remover cidade\nR: ");
        int op = input.nextInt();

        if(op==1){

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

            CidadePOJO cidadePOJOAserInserida = new CidadePOJO(ddd,nome,nro_habitantes,renda_per_capita,capital,estado,prefeito);
            cidadeDao.insereCidade(cidadePOJOAserInserida);

        } else if (op==2) {
            System.out.print("Insira o DDD da cidade para removê-la: ");
            int dddr = input.nextInt();
            cidadeDao.removeCidade(dddr);
        }

        input.close();

    }
}