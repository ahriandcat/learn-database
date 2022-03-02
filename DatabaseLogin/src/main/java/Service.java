import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Service {
    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection conn = connectDatabase.connect();

    public void login(String user_name, String pass) {
        String query = "select count(u.username) from users u" +
                " where u.username  = " + "'" + user_name + "'" + " and u.password = " + "'" + pass + "'";
        int loginResult = 0;
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            result.next();
            loginResult = result.getInt("count(u.username)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(loginResult == 1) System.out.println("Dang nhap thanh cong!");
        if(loginResult == 0) System.out.println("Dang nhap that bai!");
    }
}
