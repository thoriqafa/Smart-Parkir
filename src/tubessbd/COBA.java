package tubessbd;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class COBA {
    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        long op = millis+(3600000*25);
        long by = 5000;
        
        java.sql.Date sqlDate = new java.sql.Date(millis);
        java.sql.Date sqlDate1 = new java.sql.Date(op);
        java.sql.Time timedat = new java.sql.Time(millis);
        java.sql.Time timedat1 = new java.sql.Time(op);
        
        System.out.println(millis);
        System.out.println("sqlDate: " + sqlDate);
        System.out.println(sqlDate1);
        System.out.println("sqlDate: " + timedat);
        System.out.println("sqlDate: " + timedat1);
        
        long dif = timedat1.getTime()-timedat.getTime();
        
        long diffHours = dif / (60 * 60 * 1000);
        long tot = diffHours*by;
        String biaya=String.valueOf(tot);
        String lama_jam=String.valueOf(diffHours);
        System.out.println(lama_jam);
        System.out.println(biaya);
        
    }
}
