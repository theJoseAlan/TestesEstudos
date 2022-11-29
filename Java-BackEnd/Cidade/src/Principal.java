import java.util.Scanner;
public class Principal {
    //Metodo para remoção de cidade
    private static void remocao(Scanner input, CidadeDAO cidadeDao) {
        System.out.print("Insira o DDD da cidade para removê-la: ");
        int dddr = input.nextInt();
        cidadeDao.removeCidade(dddr);
    }

    //Metodo para adição de cidade
    private static void insercao(Scanner input, CidadeDAO cidadeDao) {
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
    }


    //Programa Principal
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CidadeDAO cidadeDao = new CidadeDAO();

        int op=0;

        do {
            System.out.print("1 - ADD cidade\n2 - Remover cidade\n-1 - Sair\nR: ");
            op = input.nextInt();

            if(op==1){

                insercao(input, cidadeDao);

            } else if (op==2) {
                remocao(input, cidadeDao);
            }

        }while (op!=-1);

        System.out.println("Até a próxima");
        input.close();

    }
}