
package controller;

import DAO.Conexao;
import DAO.EstoqueDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.Pesquisar;

/**
 *
 * @author Letizia
 */
public class ControllerPesquisar {
    private Pesquisar view;

    public ControllerPesquisar(Pesquisar view) {
        this.view = view;
    }
    
    public void pesquisaTodos(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            EstoqueDAO dao = new EstoqueDAO(conn);
            ResultSet res = dao.consultarTodos();
            StringBuilder texto = new StringBuilder(); 
            while (res.next()){
                String marca = res.getString("marca");
                String desc = res.getString("descricao");
                String preco = res.getString("preço");
                
                texto.append("Marca: ").append(marca).append("   Descrição: ")
                        .append(desc).append("   Preço: ").append(preco)
                        .append("\n\n");
                view.getTxtResul().setText(texto.toString());
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }
    }
    
    public void pesquisa(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            EstoqueDAO dao = new EstoqueDAO(conn);
            ResultSet res = dao.consultar(view.getTxtMarca().getText(),
                    view.getTxtDescricao().getText());
            StringBuilder texto = new StringBuilder(); 
            if (!res.isBeforeFirst()) { 
                JOptionPane.showMessageDialog(view, "Peça não encontrada");
                return;
            }
            while (res.next()){
                String marca = res.getString("marca");
                String desc = res.getString("descricao");
                String preco = res.getString("preço");
                
                texto.append("Marca: ").append(marca).append("   Descrição: ")
                        .append(desc).append("   Preço: ").append(preco)
                        .append("\n\n");
                view.getTxtResul().setText(texto.toString());
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }
    }
    
    public void pesquisaM(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            EstoqueDAO dao = new EstoqueDAO(conn);
            ResultSet res = dao.consultarMarca(view.getTxtMarca().getText());
            StringBuilder texto = new StringBuilder(); 
            if (!res.isBeforeFirst()) { 
                JOptionPane.showMessageDialog(view, "Marca não encontrada");
                return;
            }
            while (res.next()){
                String marca = res.getString("marca");
                String desc = res.getString("descricao");
                String preco = res.getString("preço");
                
                texto.append("Marca: ").append(marca).append("   Descrição: ")
                        .append(desc).append("   Preço: ").append(preco)
                        .append("\n\n");
                view.getTxtResul().setText(texto.toString());
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }
    }
}
