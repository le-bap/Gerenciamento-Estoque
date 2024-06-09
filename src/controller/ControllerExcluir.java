package controller;

import DAO.Conexao;
import DAO.EstoqueDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Roupa;
import view.Excluir;

/**
 *
 * @author Letizia
 */
public class ControllerExcluir {
    private Excluir view;

    public ControllerExcluir(Excluir view) {
        this.view = view;
    }    
    
    public void remover(){
        String marca = view.getTxtMarca().getText();
        String desc = view.getTxtDescricao().getText();
        int option = JOptionPane.showConfirmDialog(view, 
                "realmente quer excluir esta peça?");
        
        
        
        if(option != 1){
            Conexao conexao = new Conexao();
            
            try{
                Connection conn = conexao.getConnection();
                EstoqueDAO dao = new EstoqueDAO(conn);
                dao.excluir(marca, desc);
                JOptionPane.showMessageDialog(view, "excluido com sucesso");
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(view, e);

            }
        }   
    }
}
