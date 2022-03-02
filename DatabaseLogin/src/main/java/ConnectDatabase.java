import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    String hostName = "Localhost:8080";
    String dbName = "login";
    String userName = "root";
    String passWord = "123";

    String url = "jdbc:mysql://"+ hostName+"/"+dbName;

    public Connection connect(){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url,userName,passWord);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            System.out.println("Kết nối không thành công "+e.getMessage());
        }
        return conn;
    }
}