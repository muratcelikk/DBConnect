package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author Murat Çelik Pegamis
 */
public class DB {

    final private String url = "jdbc:mysql://localhost/";
    final private String dbName = "proje_ee";
    final private String dbUser = "root";
    final private String dbPass = "";

    final private String driver = "com.mysql.jdbc.Driver";

    private Connection conn = null;
    private PreparedStatement st;

    public DB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url + dbName, dbUser, dbPass);
            System.out.println("Baglanti Basarili");
        } catch (Exception e) {
            System.err.println("Baglanti Hatasi : " + e);
        }
    }

    public PreparedStatement connect(String query) {
        try {
            st = conn.prepareStatement(query);
            return st;
        } catch (Exception e) {
            System.err.println("Pre St Hatasi : " + e);
        }
        return st;
    }
}
