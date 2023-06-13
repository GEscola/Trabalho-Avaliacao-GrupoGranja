/*
 * Os Design Patterns (Padroes de Design) sao solucoes amplamente testadas 
 * que ajudam a reduzir a complexidade do processo de desenvolvimento.
 * 
 * Classe MySQLJDBC (c/ Singleton) 
 * A Classe MySQLJDBC aplica o padrao Singleton.
 * 
 * O Singleton e um padrao de design que garante:
 * - apenas existir uma instancia da classe em toda a aplicacao.
 * - se nao existir instancia da classe, e imediatamente instanciada e retornada. 
 * 
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLJDBC {

    // atributo da instancia
    private Connection conn;
    // atributo da Classe 
    private static MySQLJDBC bdConnInstance;

    // metodo construtor privado
    private MySQLJDBC() throws ClassNotFoundException, SQLException {        
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/bd_company", "root", "root");
    }

    // metodo getInstance retorna a instancia
    // se instancia nao existe, cria e retorna instancia
    public static MySQLJDBC getInstance() throws SQLException, ClassNotFoundException {
        if (bdConnInstance == null){
            bdConnInstance = new MySQLJDBC();
        }
        return bdConnInstance;
    }

    // metodo getConnection retorna instancia da Classe Connection
    public Connection getConnection(){
        return this.conn;
    }

    // metodo closeConnection fecha ligação à base de dados
    public void closeConnection(){
        if(this.conn != null){
            try{
                this.conn.close();					   
                System.out.println ("\n\nLigacao BD encerrada...");
                
            }catch(SQLException ex){
                System.out.println("Erro ao terminar ligacao a BD!");
            }			   
        }
    }
    
}