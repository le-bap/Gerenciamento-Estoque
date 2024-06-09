package controller;

import view.Adicionar;
import view.Excluir;
import view.Inicio;
import view.Pesquisar;

/**
 *
 * @author Letizia
 */
public class ControllerInicio {
    private Inicio view;

    public ControllerInicio(Inicio view) {
        this.view = view;
    }
    
    public void excluir(){
        Excluir e = new Excluir();
        e.setVisible(true);
    }
    
    public void pesquisa(){
        Pesquisar p = new Pesquisar();
        p.setVisible(true);
    }
    
    public void adicionar(){
        Adicionar a = new Adicionar();
        a.setVisible(true);
    }
}
