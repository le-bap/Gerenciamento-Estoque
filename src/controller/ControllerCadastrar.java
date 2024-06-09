package controller;

import DAO.Conexao;
import DAO.EstoqueDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Roupa;
import view.Adicionar;

/**
 *
 * @author Letizia
 */
public class ControllerCadastrar {
    
    private Adicionar view;

    public ControllerCadastrar(Adicionar view) {
        this.view = view;
    }
    
    public void cadastrar(){
        String marca = view.getTxtMarca().getText();
        String descricao = view.getTxtDescricao().getText();
        String preco = view.getTxtPreco().getText();
        
        Roupa roupa = new Roupa(marca, descricao, preco);
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            EstoqueDAO dao = new EstoqueDAO(conn);
            dao.inserir(roupa);
            JOptionPane.showMessageDialog(view, "Roupa cadastrada");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }
    }
    
}
