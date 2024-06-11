package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Roupa;

/**
 *
 * @author Letizia
 */
public class EstoqueDAO {
    private Connection conn;

    public EstoqueDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(String marca, String desc) throws SQLException {
        String sql = "SELECT * FROM estoque WHERE LOWER(marca) LIKE ? AND LOWER(descricao) LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + marca.toLowerCase() + "%");
        stmt.setString(2, "%" + desc.toLowerCase() + "%");
        return stmt.executeQuery();
    }
    
    public ResultSet consultarTodos() throws SQLException{
        String sql = "select * from estoque";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        ResultSet resul = statement.getResultSet();
        return resul;
    }
    
    public ResultSet consultarMarca(String marca) throws SQLException{
        String sql = "SELECT * FROM estoque WHERE LOWER(marca) LIKE ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + marca.toLowerCase() + "%");
        statement.execute();
        ResultSet resul = statement.getResultSet();
        return resul;
    }
    
    public void inserir(Roupa roupa) throws SQLException{
        String sql = "insert into estoque (marca, preço, descricao) values('" +
                roupa.getMarca() + "', '" + roupa.getPreço() +
                "', '" + roupa.getDescricao() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public boolean excluir(String marca, String desc) throws SQLException{
        String sql = "delete from estoque where marca = ? AND descricao = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, marca);
            stmt.setString(2, desc);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
}
