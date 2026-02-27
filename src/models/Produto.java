
package models;


/**
 * BR-Software Vs. 1.0 25/09/2024
 * Projeto Supermercado
 * 
 * @author Ruberval Brasileiro
 */
public class Produto {
    private int id;
    private String produto;
    private double qtd;
    private double preco;
    private double total;
    private String categoria;
    private String supermercado;

    public Produto() {
    }

    public Produto(int id, String produto, double qtd, double preco, double total, String categoria) {
        this.id = id;
        this.produto = produto;
        this.qtd = qtd;
        this.preco = preco;
        this.total = qtd * preco;
        this.categoria = categoria;
    }

    public Produto(int id, String produto, double qtd, double preco, double total, String categoria,
            String supermercado) {
        this.id = id;
        this.produto = produto;
        this.qtd = qtd;
        this.preco = preco;
        this.total = qtd * preco;
        this.categoria = categoria;
        this.supermercado = supermercado;
    }

    public double gettotalReal() {
    // Se o total estiver zerado mas houver preço e qtd, ele calcula na hora de devolver
    if (this.total == 0 && this.qtd > 0 && this.preco > 0) {
        return this.qtd * this.preco;
    }
    return total;
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

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTotal() {
        if (this.total == 0 && this.qtd > 0 && this.preco > 0) {
        return this.qtd * this.preco;
    }
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
