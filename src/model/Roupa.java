package model;

/**
 *
 * @author Letizia
 */
public class Roupa {
    private String marca, descricao, preço;

    public Roupa(String marca, String descricao, String preço) {
        this.marca = marca;
        this.descricao = descricao;
        this.preço = preço;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreço() {
        return preço;
    }

    public void setPreço(String preço) {
        this.preço = preço;
    }
}
