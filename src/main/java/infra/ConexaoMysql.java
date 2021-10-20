package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMysql {

    private Connection connection = null;
    private static final String USERNAME = "root";

    //Senha do mysql
    private static final String PASSWORD = "123456";

    //Dados de caminho, porta e nome da base de dados que irá ser feita a conexao
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda_tarefas?useTimezone=true&serverTimezone=UTC";

    public ConexaoMysql() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(DATABASE_URL,USERNAME, PASSWORD);
        this.connection.setAutoCommit(false);
    }

    // Retonar a conexao que foi instanciada com o banco e retornar para a classe
    public Connection getConnection(){
        return this.connection;
    }

    public void close(){
        if(this.connection != null){
            // tenta executar esse bloco de comando
            try{
                this.connection.close();
            }catch (SQLException e){
                Logger.getLogger(ConexaoMysql.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public void commit() throws SQLException {
        this.connection.commit();
        this.close();
    }

    // meta para não deixar inserir coisas incorretas no banco - gera erro
    public void rollback(){
        if(this.connection != null){
            // tenta executar esse bloco de comando
            try{
                this.connection.rollback();
            }catch (SQLException e){
                Logger.getLogger(ConexaoMysql.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
