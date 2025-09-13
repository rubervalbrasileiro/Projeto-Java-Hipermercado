
package models;

/**
 *BR-Software Vs. 1.0 25/09/2024
 * Projeto Supermercado
 * @author Ruberval Brasileiro
 */
public class Produto {
    private int id;
    private String produto;
    private int qtd;
    private double preco;
    private double total;
    private String categoria;
    private String supermercado;

    public Produto() {
    }

    public Produto(int id, String produto, int qtd, double preco, double total, String categoria) {
        this.id = id;
        this.produto = produto;
        this.qtd = 1;
        this.preco = preco;
        this.total = qtd * preco;
        this.categoria = categoria;
    }
    

    public Produto(int id, String produto, int qtd, double preco, double total, String categoria, String supermercado) {
        this.id = id;
        this.produto = produto;
        this.qtd = 1;
        this.preco = preco;
        this.total = qtd * preco;
        this.categoria = categoria;
        this.supermercado = supermercado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(String supermercado) {
        this.supermercado = supermercado;
    }
    
    
    
}
