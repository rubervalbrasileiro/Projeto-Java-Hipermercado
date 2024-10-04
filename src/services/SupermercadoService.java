
package services;
import models.Produto;
import models.Supermercado;

import java.util.List;

/**
 * BR-Software Vs. 1.0 25/09/2024
 *
 * @author Ruberval Brasileiro
 */
public class SupermercadoService {

    private List<Supermercado> supermercados;  // Lista de supermercados para comparação

    public SupermercadoService(List<Supermercado> supermercados) {
        this.supermercados = supermercados;
    }
    
    // Método para buscar o menor preço de um item entre diferentes supermercados
    public Produto buscarMenorPreco(String nomeProduto) {
        Produto produtoComMenorPreco = null;

        // Itera sobre todos os supermercados
        for (Supermercado supermercado : supermercados) {
            // Itera sobre todos os produtos do supermercado
            for (Produto produto : supermercado.getProdutos()) {
                // Verifica se o nome do produto corresponde ao produto que estamos procurando
                if (produto.getProduto().equalsIgnoreCase(nomeProduto)) {
                    // Se produtoComMenorPreco for nulo ou se o preço do produto atual for menor que o do produtoComMenorPreco
                    if (produtoComMenorPreco == null || produto.getPreco() < produtoComMenorPreco.getPreco()) {
                        produtoComMenorPreco = produto;  // Atualiza o produto com menor preço
                    }
                }
            }
        }
        return produtoComMenorPreco;  // Retorna o produto com o menor preço encontrado
    }

    // Getters e setters
    public List<Supermercado> getSupermercados() {
        return supermercados;
    }

    public void setSupermercados(List<Supermercado> supermercados) {
        this.supermercados = supermercados;
    }
}
