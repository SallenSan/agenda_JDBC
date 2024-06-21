package org.example.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {
    // bloqueio para a sincronização
    private static final Object lock = new Object();
    private static Connection connection = null;
    
    public static Connection getConnection() {
        synchronized (lock) {
            try{
                // este bloco ira verificar se a conexão está fechada e tentará reabri-la caso haja necessidade
                if (connection == null || connection.isClosed()) {
                    String url = "jdbc:postgresql://localhost:5432/agenda";
                    String user = "postgres";
                    String password = "postgres";
                    connection = DriverManager.getConnection(url, user, password);
                }
            }catch(Exception e){
                throw new RuntimeException("Não foi possível conectar-se ao banco de dados! " + e);
            }
        }
        return connection;
    }
}
