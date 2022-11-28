import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PilotoDAO {

    private Connection conn;

    public PilotoDAO(){
        this.conn = ConnectionFactory.getConnection();
    }

    public boolean inserePiloto(Piloto piloto){
        String sql = "INSERT INTO aeronaves.pilotos(matricula, nome, num_aeronave, salario, horas_voo)"+
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,piloto.getMatricula());
            stmt.setString(2, piloto.getNome());
            stmt.setInt(3, piloto.getNumAeronave());
            stmt.setDouble(4, piloto.getSalario());
            stmt.setInt(5,piloto.getHorasVoo());
            stmt.execute();
            stmt.close();
            System.out.println("Dado enviado!");
            return true;
        }catch (SQLException e){
            System.err.println("Erro ao enviar dado ao DB");
            System.err.println(e.getMessage());
            return false;
        }

    }

}
