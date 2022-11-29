import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CidadeDAO {
    private Connection conn;

    public CidadeDAO(){
        this.conn = ConnectionFactory.getConnection();
    }

    public boolean insereCidade(CidadePOJO cidadePOJO){
        String sql = "INSERT INTO cidade.cidade(ddd, nome, nro_habitantes, renda_per_capita, capital, estado, nome_prefeito)"+
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cidadePOJO.getDdd());
            stmt.setString(2, cidadePOJO.getNome());
            stmt.setInt(3, cidadePOJO.getNro_habitantes());
            stmt.setDouble(4, cidadePOJO.getRenda_per_capita());
            stmt.setBoolean(5, cidadePOJO.isCapital());
            stmt.setString(6, cidadePOJO.getEstado());
            stmt.setString(7, cidadePOJO.getNome_prefeito());
            stmt.execute();
            stmt.close();
            System.out.println("Dados enviados!");
            return true;
        }catch (SQLException e){
            System.err.println("Erro ao enviar dados ao DB");
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean removeCidade(int ddd){
        String sql = "DELETE FROM cidade.cidade WHERE ddd=?;";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, ddd);
            stmt.execute();
            stmt.close();
            System.out.println("Cidade Removida!");
        }catch (SQLException e){
            System.out.println("Erro ao remover cidade!");
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

}
