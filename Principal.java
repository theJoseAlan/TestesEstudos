import java.sql.ResultSet;

public class Principal {

	public static void main(String[] args) {
		
		Conexao con = new Conexao();
		
		/*String sql = "INSERT INTO cliente (id, nome, email) VALUES (default, 'Marcia Rudrigue', 'marciarudrigue@gmail.com')";
		
		int res = con.executaSQL(sql);
		
		if(res>0) {
			System.out.println("Cadastrado com sucesso!");
		}else {
			System.out.println("Erro durante o cadastro");
		}*/
		
		String sql = "SELECT * FROM cliente";
		
		ResultSet rs = con.executaBusca(sql);
		
		try {
			while(rs.next()) { //O next indica próxima linha do bd, ele percorre as linhas enquanto não achar uma vazia
				int id = rs.getInt("id"); //o id entre aspas é o id dentro do bd
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				System.out.println(id + " - "+nome+" - "+email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
