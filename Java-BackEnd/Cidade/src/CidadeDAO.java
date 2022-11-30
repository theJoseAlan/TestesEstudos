import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public List<CidadePOJO> listaCidades(){
        String sql = "SELECT * FROM cidade.cidade";
        List<CidadePOJO> listaRetornada = new ArrayList<>();

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            populaLista(listaRetornada, rs);

        } catch (SQLException e) {
            System.out.println("Erro ao listar cidades!");
            System.err.println(e.getMessage());
        }

        return listaRetornada;
    }

    public CidadePOJO consultacidade(int ddd){
        String sql = "SELECT * FROM cidade.cidade WHERE ddd=?";

        PreparedStatement stmt;

        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, ddd);
            ResultSet rs = stmt.executeQuery(); //Objeto que contem os resultados da consulta

            if (rs.next()){//Se retornar, é porque achei um registro na tabela, no caso o que quero
                CidadePOJO cidadeRetornada = new CidadePOJO();
                cidadeRetornada.setDdd(rs.getInt("ddd"));
                cidadeRetornada.setNome(rs.getString("nome"));
                cidadeRetornada.setNro_habitantes(rs.getInt("nro_habitantes"));
                cidadeRetornada.setRenda_per_capita(rs.getDouble("renda_per_capita"));
                cidadeRetornada.setCapital(rs.getBoolean("capital"));
                cidadeRetornada.setEstado(rs.getString("estado"));
                cidadeRetornada.setNome_prefeito(rs.getString("nome_prefeito"));

                return cidadeRetornada;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar cidade!");
            System.err.println(e.getMessage());
        }

        return null;
    }

    public List<CidadePOJO> listaCidadesQueComecamCom(String inicio){
        List<CidadePOJO> cidades = new ArrayList<CidadePOJO>();
        String sql = "SELECT * FROM cidade.cidade WHERE = ?";

        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,inicio+"%");// % Indica que começa com a String digitada e termine
                                                        // com qualquer coisa, senão ele procura a variável em todas
                                                        //as Strings
            ResultSet rs = stmt.executeQuery();
            populaLista(cidades, rs);
        }catch (SQLException e){
            System.err.println("Erro ao listar cidades que começam com "+inicio);
            System.err.println(e.getMessage());
        }
        return cidades;
    }

    public  List<CidadePOJO> listaCidadePorEstado(String estado){
        List<CidadePOJO> cidades = new ArrayList<CidadePOJO>();
        String sql = "SELECT * FROM cidade.cidade WHERE estado = ?";

        PreparedStatement stmt;
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, estado);
            ResultSet rs = stmt.executeQuery();
            populaLista(cidades, rs);

        }catch (SQLException e){
            System.err.println("Erro ao listar cidades do estado com "+estado);
            System.err.println(e.getMessage());
        }
        return cidades;
    }

    public int contaCidadesPorEstado(String estado){
        String sql = "SELECT COUNT(*) as contagem FROM cidade.cidades WHERE estado = ?";
        PreparedStatement stmt;

        try{
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, estado);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            return rs.getInt("contagem");

        }catch (SQLException e){
            System.err.println("Erro ao contar cidades do estado com "+estado);
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public List<CidadePOJO> listaCidadesFiltradasPOrCapital(boolean ehCapital){
        List <CidadePOJO> cidades = new ArrayList<CidadePOJO>();
        String sql = "SELECT * FROM cidade.cidade WHERE capital is ?";
        PreparedStatement stmt;

        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setBoolean(1, ehCapital);
            ResultSet rs = stmt.executeQuery();

            populaLista(cidades, rs);

        }catch (SQLException e){
            System.err.println("Erro ao listar cidades pela coluna capital ");
            System.err.println(e.getMessage());
        }


        return cidades;
    }


    //Método de listagem, pra não ficar repetindo código
    private static void populaLista(List<CidadePOJO> listaRetornada, ResultSet rs) throws SQLException {
        while (rs.next()){
            CidadePOJO cidadeRetornada = new CidadePOJO();

            cidadeRetornada.setDdd(rs.getInt("ddd"));
            cidadeRetornada.setNome(rs.getString("nome"));
            cidadeRetornada.setNro_habitantes(rs.getInt("nro_habitantes"));
            cidadeRetornada.setRenda_per_capita(rs.getDouble("renda_per_capita"));
            cidadeRetornada.setCapital(rs.getBoolean("capital"));
            cidadeRetornada.setEstado(rs.getString("estado"));
            cidadeRetornada.setNome_prefeito(rs.getString("nome_prefeito"));

            listaRetornada.add(cidadeRetornada);
        }
    }

}
