package conexao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * BR-Software Vs. 1.0 25/09/2024
 * Projeto Supermercado
 * @author Ruberval Brasileiro
 */
public class Conexao {
    
    private String url;
    private String user;
    private String password;
    public Connection conn;

    /**
     * Carrega as configurações do banco de dados a partir do arquivo config.properties
     */
    private void carregarConfiguracoes() {
        Properties props = new Properties();
        try (FileInputStream fs = new FileInputStream("config.properties")) {
            props.load(fs);
            this.url = props.getProperty("db.url");
            this.user = props.getProperty("db.user");
            this.password = props.getProperty("db.password");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler config.properties: " + e.getMessage());
        }
    }

    public boolean conectar() {
        carregarConfiguracoes(); // Busca os dados do arquivo antes de conectar
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password); 
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexao com o banco de dados: " + ex.getMessage());
            return false;
        }
    }

    public Connection getConn() {
        return conn;
    }
    
    public void desconectar(Connection conn, Statement stmt) {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex.getMessage());
        }
    }

    public static void main(String[] Args) {
        Conexao conexao = new Conexao();
        if (conexao.conectar()) {
            System.out.println("Conexão estabelecida via arquivo de configuração!");
            System.out.println("Seja bem vindo.");
        } else {
            System.out.println("Falha na conexão.");
        }
    }
}