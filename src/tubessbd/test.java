/*
 
* To change this license header, choose License Headers in Project Properties.
 
* To change this template file, choose Tools | Templates
 
* and open the template in the editor.
 
*/
package tubessbd;
 
import java.sql.SQLException;
import tubessbd.koneksi;
 
/**
 
*
 
* @author User
 
*/
public class test {
 
    
/**
     
* @param args the command line arguments
     
*/
    public static void main(String[] args) throws SQLException {
        koneksi connection = new koneksi();
        connection.getKoneksi();
    }
}