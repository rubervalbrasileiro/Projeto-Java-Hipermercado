package models;

import java.util.List;

/**
 * BR-Software Vs. 1.0 25/09/2024
 *
 * @author Ruberval Brasileiro
 */
public class Supermercado {

    private int id;
    private String nome;
    private String endereco;
    private List<Produto> produtos;  // Associação com a classe Produto

    public Supermercado(int id, String nome, String endereco, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    // Método para adicionar produto ao supermercado
    public void adicionarProduto(Produto produto, String categoria) {
       produto.setCategoria(categoria);   // Associar a categoria ao produto
       produto.setSupermercado(this.nome); // Associar o produto ao supermercado atual
       this.produtos.add(produto);          // Adiciona o produto à lista de produtos do supermercado
    }

    // Método para remover produto do supermercado
    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    // Método para atualizar produto so supermercado
    public void atualizarProduto(Produto produtoAtualizado) {
        // Itera pela lista de produtos para encontrar o produto correspondente
        for (int i = 0; i < this.produtos.size(); i++) {
            Produto p = this.produtos.get(i);

            // Verifica se o ID do produto corresponde ao produto que deve ser atualizado
            if (p.getId() == produtoAtualizado.getId()) {
                // Atualiza as informações do produto
                this.produtos.set(i, produtoAtualizado);
                System.out.println("Produto atualizado com sucesso.");
                return;
            }
        }
    }

}
