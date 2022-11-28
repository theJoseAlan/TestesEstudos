import java.lang.invoke.StringConcatFactory;
import java.sql.ResultSet;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Conexao con = new Conexao(); //Instanciando a classe de conexão | se a conecxão der bom, ele mostra na tela
        /*
        EXECUTA UMA INSERÇÃO NO BD


        String sql = "INSERT INTO cliente (id, nome, email) VALUES (default, 'Grupis', 'salesalan843@gmail.com')";
        int res = con.executaSQL(sql);
        if(res>0){ //Se o res for maior que 0, quer dizer que mais um cadastro foi feito
            System.out.println("Cadastro realizado!");
        }else{
            System.out.println("Erro durante o cadastro. Tente novamente!");
        }
        */

        //EXECUTA UMA BUSCA NO BD
        String sql = "SELECT * FROM cliente";
        ResultSet rs = con.executaBusca(sql);

        try{
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                System.out.println(id+" - "+nome+" - "+email);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}