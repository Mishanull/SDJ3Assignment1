package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.locks.ReentrantLock;

public class DBSConnection {
    private static DBSConnection connection;
    private final String url;
    private final String user;
    private final String password;
    private final static ReentrantLock lock = new ReentrantLock();

    private DBSConnection(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    static DBSConnection getInstance(){
        if(connection==null){
            synchronized (lock){
                if(connection==null){
                    connection= new DBSConnection(
                            "jdbc:postgresql://localhost:5432/postgres","postgres","12345"
                    );
                }
            }
        }
        return connection;
    }

    public Connection connect(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
