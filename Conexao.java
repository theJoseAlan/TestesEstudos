import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexao{
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	public Conexao() {
		super();
		this.url = "jdbc:postgresql://localhost:5432/postgres"; //meu bd local do postgres
		this.usuario = "postgres"; //era pra ser eu, mas esse ai é o padrão e não vou mudar
		this.senha = "04032000"; //senha do meu bd
		
		try {
			Class.forName("org.postgresql.Driver"); //Para fazer tudo do JDBC precisa de um driver (.jar) do postgreSql
			con = DriverManager.getConnection(url, usuario, senha);//Para criar a coneção o java precisa saber o caminho, usuario e senha
			System.out.println("Conetado com sucesso!"); // se der bom, vai mostrar isso
		} catch (Exception e) { //É necessário usar o tryCatch para não dar ruim futuramente
			e.printStackTrace();//Se der ruim, ele mostra o erro
		}
	}
	
	public int executaSQL(String sql) { //Funçãozinha pra rodar uns comandos sql pra fazer os inserts no bd
		try {
			Statement stm = con.createStatement(); //PRecisa fazer isso em toda função para conctar ao bd e passar os comandos 
			int res = stm.executeUpdate(sql); //Aqui vão ficar os comandos, olha o parâmetro lá, é uma String
			con.close(); //Lembre de fechar a conexão, senão dá ruim
			return res; //Retorna aqui se der bom
			
		} catch (Exception e) {
			e.printStackTrace(); //Esse você já sabe
			return 0; //Retorna aqui se der ruim
		}
	}
	
	public ResultSet executaBusca(String sql) { //Funçãozinha para fazer uns SELECT'S no bd
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			con.close();
			return rs;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}