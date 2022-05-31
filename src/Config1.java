import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Config1 {
    private static Connection mysqlconfig;
    public static Connection configDB()throws SQLException{
        try {
            String url="jdbc:mysql://localhost:4000/pbo_test"; //url database
            String user="root"; //user database
            String pass="123qwe123"; //password database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig=DriverManager.getConnection(url, user, pass);            
        } catch (SQLException e) {
            System.err.println("koneksi gagal "+e.getMessage()); //perintah menampilkan error pada koneksi
        }
        return mysqlconfig;
    }    
}