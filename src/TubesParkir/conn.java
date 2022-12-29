package TubesParkir;

import TubesParkir.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class conn {
    public static Connection getKoneksi(){
        String url = "jdbc:jtds:sqlserver://127.0.0.1:1433/DBSmartParkir;"
                + "database=DBSmartParkir;"
                + "user=thoriqafa;"
                + "password=thoriq123;";
        
        try {
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        
    }
}
