/*
 
* To change this license header, choose License Headers in Project Properties.
 
* To change this template file, choose Tools | Templates
 
* and open the template in the editor.
 
*/
package tubessbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
 
    private Connection koneksi;
 
    public Connection getKoneksi() {
        if (koneksi == null) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                System.out.println("Class Driver Ditemukan");
                try {
                    String url = "jdbc:jtds:sqlserver://127.0.0.1:1433/DBSmartParkir"; //buka =  nama database yang digunakan 
                    koneksi = DriverManager.getConnection(url, "thoriqafa", "thoriq123"); 
                    System.out.println("Koneksi Database sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi Database Gagal error:" + se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class tidak ditemukan, error: " + cnfe);
                System.exit(0);
            }
        }
        return koneksi;
    }
}