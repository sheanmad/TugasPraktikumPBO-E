
package projekakhir.modeldatabase;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author pc msi
 */
public class Model {
    String DBurl;
    String DBusername = "root";
    String DBpassword = "";
    public Connection koneksi;
    public Statement stmt;

    public Model() {
        this.DBurl = "jdbc:mysql://localhost/movie_db";
        System.out.println(this.DBurl);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            stmt = koneksi.createStatement();
            System.out.println("Koneksi Berhasil");
        }
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
