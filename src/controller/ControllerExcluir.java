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
    
    public void remover() {
        String marca = view.getTxtMarca().getText();
        String desc = view.getTxtDescricao().getText();
        int option = JOptionPane.showConfirmDialog(view, "Realmente quer excluir esta peça?");

        if (option == JOptionPane.YES_OPTION) {
            Conexao conexao = new Conexao();
            try {
                Connection conn = conexao.getConnection();
                EstoqueDAO dao = new EstoqueDAO(conn);
                boolean sucesso = dao.excluir(marca, desc);
                if (sucesso) {
                    JOptionPane.showMessageDialog(view, "Excluído com sucesso");
                    view.getTxtMarca().setText("");
                    view.getTxtDescricao().setText("");
                } else {
                    JOptionPane.showMessageDialog(view, "Peça não encontrada");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Erro ao excluir: " + e.getMessage());
            }
        }
    }
}
