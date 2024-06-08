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
    
    public ResultSet consultar(Roupa roupa) throws SQLException{
        String sql = "select * from estoque where marca = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
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
    
    public void excluir(Roupa roupa) throws SQLException{
        String sql = "delete from estoque where marca = ? descricao = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, roupa.getMarca());
        statement.setString(1, roupa.getDescricao());
        statement.execute();
        conn.close();
    }
}
