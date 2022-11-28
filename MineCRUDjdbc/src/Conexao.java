import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public int executaSQL(String sql){
        try {
            Statement stm = con.createStatement(); //Cria um statement a partir da conexao com o bd
            int res = stm.executeUpdate(sql); //Quando executa o comando sql ele retorna o numero de execuções
            con.close(); //Fecha a conexão
            return res;//Retorna o numero de execuções até ali
        }catch (Exception e) {
            e.printStackTrace();
            return 0;//Se cair aqui é porque a execução do sql não foi feita
        }
    }

    public ResultSet executaBusca(String sql){ //Retorna um ResultSet e precisa de uma string com o comando SQL
        try {
            Statement stm = con.createStatement();//Criando um Statement a partir da conexão
            ResultSet rs = stm.executeQuery(sql); //Executa o comando SQL
            con.close();
            return rs;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
