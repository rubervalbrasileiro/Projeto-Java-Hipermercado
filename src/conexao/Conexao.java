
package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * BR-Software Vs. 1.0 25/09/2024
 *
 * @author Ruberval Brasileiro
 */
public class Conexao {
    private final String url = "jdbc:mysql://localhost:3306/hipermercado"; // nome do banco de dados
    private final String user = "root"; // usuario
    private final String password = ""; //senha do MySQL
    
    public Connection conn; //criando um objeto do tipo connection chamado conn
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password); 
            //System.out.println("Conexão realizada com sucesso"); desativado poluição visual no console
            return true;
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Falha na conexao com o banco de dados" + ex.getMessage());
            return false;
        }
    }

    public Connection getConn() {
        return conn;
    }
    
    public void desconectar(Connection conn, Statement stmt){
        try {
            conn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível se conectar ao banco ");
        }
    }
    public static void main(String[]Args){
       Conexao conexao = new Conexao();
        if (conexao.conectar()) {
            System.out.println("Seja bem vindo.");
        } else {
            System.out.println("Falha na conexão.");
        }
    }
        
}
