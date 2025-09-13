
package models;

/**
 *BR-Software Vs. 1.0 25/09/2024
 * Projeto Supermercado
 * @author Ruberval Brasileiro
 */
public class Categoria extends Produto {
    private String cereais;
    private String verduras;
    private String frutas;
    private String carnes;
    private String frios;
    private String limpesa;
    private String perfumaria;
   
    public Categoria(int id, String produto, int qtd, double preco, double total, String categoria, String supermercado) {
        super(id, produto, qtd, preco, total, categoria, supermercado);
    }

    public Categoria(String cereais, String verduras, String frutas, String carnes, String frios, String limpesa, String perfumaria, int id, String produto, int qtd, double preco, double total, String categoria, String supermercado) {
        super(id, produto, qtd, preco, total, categoria, supermercado);
        this.cereais = cereais;
        this.verduras = verduras;
        this.frutas = frutas;
        this.carnes = carnes;
        this.frios = frios;
        this.limpesa = limpesa;
        this.perfumaria = perfumaria;
    }

    public String getCereais() {
        return cereais;
    }

    public void setCereais(String cereais) {
        this.cereais = cereais;
    }

    public String getVerduras() {
        return verduras;
    }

    public void setVerduras(String verduras) {
        this.verduras = verduras;
    }

    public String getFrutas() {
        return frutas;
    }

    public void setFrutas(String frutas) {
        this.frutas = frutas;
    }

    public String getCarnes() {
        return carnes;
    }

    public void setCarnes(String carnes) {
        this.carnes = carnes;
    }

    public String getFrios() {
        return frios;
    }

    public void setFrios(String frios) {
        this.frios = frios;
    }

    public String getLimpesa() {
        return limpesa;
    }

    public void setLimpesa(String limpesa) {
        this.limpesa = limpesa;
    }

    public String getPerfumaria() {
        return perfumaria;
    }

    public void setPerfumaria(String perfumaria) {
        this.perfumaria = perfumaria;
    }
    
}
