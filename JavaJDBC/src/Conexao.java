import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private String url;
    private String user;
    private String senha;
    private Connection con;

    public Conexao(){
        url="jdbc:postgresql://localhost:5432/postgres"; //Driver/sgbd/bdLocal/porta/BancoDeDados
        user="postgres";//Usuario
        senha="04032000";//Senha do BD ou sgbd

        try{
            Class.forName("org.postgresql.Driver");//Driver do postgres
            con = DriverManager.getConnection(url, user, senha);//Faz a conexão
            System.out.println("Conexão bem sucedida");
        }catch (Exception e){
            e.printStackTrace();//Se der erro, ele mostra na tela
        }
    }


}
