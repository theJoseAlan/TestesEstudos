import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CidadeDAO {
    private Connection conn;

    public CidadeDAO(){
        this.conn = ConnectionFactory.getConnection();
    }

    public boolean insereCidade(Cidade cidade){
        String sql = "INSERT INTO cidade.cidade(ddd, nome, nro_habitantes, renda_per_capita, capital, estado, nome_prefeito)"+
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cidade.getDdd());
            stmt.setString(2, cidade.getNome());
            stmt.setInt(3, cidade.getNro_habitantes());
            stmt.setDouble(4, cidade.getRenda_per_capita());
            stmt.setBoolean(5, cidade.isCapital());
            stmt.setString(6, cidade.getEstado());
            stmt.setString(7, cidade.getNome_prefeito());
            stmt.execute();
            stmt.close();
            System.out.println("Dado enviado!");
            return true;
        }catch (SQLException e){
            System.err.println("Erro ao enviar dados ao DB");
            System.err.println(e.getMessage());
            return false;
        }
    }

}
