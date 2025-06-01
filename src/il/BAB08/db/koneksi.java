package il.BAB08.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rpl a
 */
public class koneksi {
 Connection konek=null;
    public static Connection ordal(){
    try {
    String url="jdbc:mysql://localhost/il";
    String user="root";
    String pass="";
    Class.forName("com.mysql.jdbc.Driver");
    Connection koneksi=DriverManager.getConnection(url,user,pass);
    return koneksi;
    }
    catch (Exception e){
    JOptionPane.showMessageDialog(null, e);
    return null;
    }
    }
    }
