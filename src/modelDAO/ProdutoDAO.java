package modelDAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Produto;

/**
 * BR-Software Vs. 1.0 25/09/2024
 *Projeto Supermercado
 * @author Ruberval Brasileiro
 */
public class ProdutoDAO {

    // Método para converter a primeira letra de cada palavra em maiúscula
    public String capitalizarNomeProduto(String produto) {
        // Divide o texto em palavras usando espaço como delimitador
        String[] palavras = produto.split(" ");
        StringBuilder produtoFormatado = new StringBuilder();

        // Converte a primeira letra de cada palavra para maiúscula
        for (String palavra : palavras) {
            if (palavra.length() > 0) {
                produtoFormatado.append(palavra.substring(0, 1).toUpperCase())
                        .append(palavra.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        // Remove o espaço extra no final e retorna o resultado
        return produtoFormatado.toString().trim();
    }

    public void criar(String produto, int qtd, double preco, double total) {
        Conexao conexao = new Conexao();
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            if (conexao.conectar()) {
                connection = conexao.getConn();
                String sql = "INSERT INTO produto(produto, qtd, preco, total) values(?,?,?,?)";

                stmt = connection.prepareStatement(sql);

                // Formata o nome do produto antes de inserir no banco
                produto = capitalizarNomeProduto(produto);
                stmt.setString(1, produto);
                stmt.setInt(2, qtd);
                stmt.setDouble(3, preco);
                stmt.setDouble(4, total);

                stmt.execute();
                JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o produto");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar o Statement: " + e.getMessage());
                }
            }
            if (connection != null) {
                conexao.desconectar(connection, stmt);
            }
        }
    }

    // Método para listar os produtos do banco de dados
    public List<Produto> listaProdutos() {
        List<Produto> produtos = new ArrayList<>();
        Conexao conexao = new Conexao();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        // Verifica se a conexão foi estabelecida com sucesso
        try {
            if (conexao.conectar()) {
                connection = conexao.getConn();
                String sql = "SELECT * FROM produto WHERE status = 1";
                //String sql = "SELECT id, produto, qtd, preco, total FROM produto";  // SQL corrigido para a tabela produto
                stmt = connection.prepareStatement(sql);
                rs = stmt.executeQuery();

                // Itera pelos resultados e adiciona na lista de produtos
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("id"));  // Atualiza o nome da coluna para idproduto
                    p.setProduto(rs.getString("produto"));  // Atualiza o nome da coluna para nome
                    p.setQtd(rs.getInt("qtd"));  // Atualiza o nome da coluna para estoque
                    p.setPreco((double) rs.getDouble("preco"));  // Atualiza o nome da coluna para fabricante
                    p.setTotal(rs.getDouble("total"));
                    produtos.add(p);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos: " + e.getMessage());
        } finally {
            // Garante que o ResultSet, PreparedStatement e Connection sejam fechados
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    conexao.desconectar(connection, stmt);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return produtos;  // Retorna a lista de produtos obtida
    }

    public void atualizar(int id, String produto, int qtd, double preco, double total) {
        Conexao conexao = new Conexao();
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            if (conexao.conectar()) {
                connection = conexao.getConn();

                String sql = ("UPDATE produto set produto = ?, qtd = ?, preco = ?, total = ? where id = ?");

                stmt = connection.prepareStatement(sql);

                // Formata o nome do produto antes de atualizar no banco
                produto = capitalizarNomeProduto(produto);
                stmt.setString(1, produto);
                stmt.setInt(2, qtd);
                stmt.setDouble(3, preco);
                stmt.setDouble(4, total);
                stmt.setInt(5, id);  // Define o identificador do produto a ser atualizado

                int linhasAfetadas = stmt.executeUpdate();  // Executa a atualização

                // Verifica se o produto foi atualizado com sucesso
                if (linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum produto encontrado com o ID fornecido.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o produto: " + e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar o Statement: " + e.getMessage());
                }
            }
            if (connection != null) {
                conexao.desconectar(connection, stmt);
            }
        }
    }
   
    public boolean produtoExiste(String nomeProduto) {
        Conexao conexao = new Conexao();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            if (conexao.conectar()) {
                connection = conexao.getConn();
                String sql = "SELECT COUNT(*) FROM produto WHERE produto = ?";
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, nomeProduto);
                rs = stmt.executeQuery();

                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // Produto já existe
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar se o produto já existe: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) conexao.desconectar(connection, stmt);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return false; // Produto não existe
    }

    public void inativarProduto(int id){
        Conexao conexao = new Conexao();
        Connection connection = null;
        PreparedStatement stmt = null;
        
        try{
            if(conexao.conectar()){
                connection = conexao.getConn();
                 // Atualiza o status para 0 (inativo)
                 String sql = "UPDATE produto SET status = 0 WHERE id = ?";
                 
                 stmt = connection.prepareStatement(sql);
                 stmt.setInt(1, id); // Passa o ID do produto que será inativado
//                 JOptionPane.showMessageDialog(null, "Você deseja realmente excluir o produto selecionado!");
                 int rowsAffected = stmt.executeUpdate();
                 if(rowsAffected > 0){
                     JOptionPane.showMessageDialog(null, "Produto inativado com Sucesso!");
                 }else{
                     JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                 }
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao conectar o banco de dados");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao inativar o Produto" + e.getMessage());
        }
        if(connection != null){
            conexao.desconectar(connection, stmt);
        }
    }
    
    
    
    // Método para buscar produtos filtrados com base nos campos fornecidos
    public List<Produto> filtro(String produto, Integer qtd, Double preco, Double total) throws SQLException {
    Conexao conexao = new Conexao();
    Connection connection = null;
    List<Produto> produtos = new ArrayList<>();

    try {
        if (conexao.conectar()) {
            connection = conexao.getConn();
            
            String sql = "SELECT * FROM produto WHERE 1=1"; // Começa com uma condição sempre verdadeira

            // Constrói a consulta com base nos parâmetros recebidos
            if (produto != null && !produto.isEmpty()) {
                sql += " AND produto LIKE ?";
            }
            if (qtd != null) {
                sql += " AND qtd = ?";
            }
            if (preco != null) {
                sql += " AND preco = ?";
            }
            if (total != null) {
                sql += " AND total = ?";
            }

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                int index = 1;

                // Preenche os valores dos parâmetros na consulta
                if (produto != null && !produto.isEmpty()) {
                    stmt.setString(index++, "%" + produto + "%");
                }
                if (qtd != null) {
                    stmt.setInt(index++, qtd);
                }
                if (preco != null) {
                    stmt.setDouble(index++, preco);
                }
                if (total != null) {
                    stmt.setDouble(index++, total);
                }

                ResultSet rs = stmt.executeQuery();

                // Processa o resultado da consulta
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("id"));
                    p.setProduto(rs.getString("produto"));
                    p.setQtd(rs.getInt("qtd"));
                    p.setPreco(rs.getDouble("preco"));
                    p.setTotal(rs.getDouble("total"));
                    produtos.add(p);
                }
            }
        } else {
            throw new SQLException("Erro ao conectar ao banco de dados");
        }
    } finally {
        if (connection != null) {
            conexao.desconectar(connection, null);
        }
    }
    return produtos;
}

 /*   
public void atualizarTabela(List<Produto> produtos) {
    // Obtém o modelo da tabela
    DefaultTableModel model = (DefaultTableModel) tblTabela.getModel();

    // Limpa a tabela atual
    model.setRowCount(0);

    // Percorre a lista de produtos e adiciona os dados na tabela
    for (Produto p : produtos) {
        // Cria uma linha com os dados do produto
        Object[] row = new Object[4];
        row[0] = p.getId();
        row[1] = p.getProduto();
        row[2] = p.getQtd();
        row[3] = p.getPreco();
        row[4] = p.getTotal();
        

        // Adiciona a linha ao modelo da tabela
        model.addRow(row);
    }
}
    */
    
    
    
    
    
    
    
    
}
